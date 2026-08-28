-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó 
DROP PROCEDURE IF EXISTS sp_get_accounts_by_dept;
DELIMITER $$
CREATE PROCEDURE sp_get_accounts_by_dept(IN in_dept_name VARCHAR(50))
BEGIN
    SELECT a.*, d.department_name
    FROM account a
    JOIN department d ON a.department_id = d.department_id
    WHERE d.department_name = in_dept_name;
END $$
DELIMITER ;
CALL sp_get_accounts_by_dept('Sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group  
DROP PROCEDURE IF EXISTS sp_count_account_in_group;
DELIMITER $$
CREATE PROCEDURE sp_count_account_in_group()
BEGIN
    SELECT g.group_id, g.group_name, COUNT(ga.account_id) AS total_account
    FROM `group` g
    LEFT JOIN group_account ga ON g.group_id = ga.group_id
    GROUP BY g.group_id, g.group_name;
END $$
DELIMITER ;

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại 
DROP PROCEDURE IF EXISTS sp_count_question_this_month;
DELIMITER $$
CREATE PROCEDURE sp_count_question_this_month()
BEGIN
    SELECT tq.type_id, tq.type_name, COUNT(q.question_id) AS total_question
    FROM type_question tq
    LEFT JOIN question q ON tq.type_id = q.type_id 
        AND MONTH(q.create_date) = MONTH(CURRENT_DATE()) 
        AND YEAR(q.create_date) = YEAR(CURRENT_DATE())
    GROUP BY tq.type_id, tq.type_name;
END $$
DELIMITER ;

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất 
DROP PROCEDURE IF EXISTS sp_get_most_question_type_id;
DELIMITER $$
CREATE PROCEDURE sp_get_most_question_type_id(OUT out_type_id TINYINT UNSIGNED)
BEGIN
    WITH type_count AS (
        SELECT type_id, COUNT(question_id) AS total_question
        FROM question
        GROUP BY type_id
    )
    SELECT type_id INTO out_type_id
    FROM type_count
    WHERE total_question = (SELECT MAX(total_question) FROM type_count)
    LIMIT 1;
END $$
DELIMITER ;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question 
DROP PROCEDURE IF EXISTS sp_get_most_question_type_name;
DELIMITER $$
CREATE PROCEDURE sp_get_most_question_type_name()
BEGIN
    DECLARE v_type_id TINYINT UNSIGNED;
    
    CALL sp_get_most_question_type_id(v_type_id);
    
    SELECT type_id, type_name 
    FROM type_question 
    WHERE type_id = v_type_id;
END $$
DELIMITER ;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào 
DROP PROCEDURE IF EXISTS sp_search_group_or_user;
DELIMITER $$
CREATE PROCEDURE sp_search_group_or_user(IN in_search_string VARCHAR(100))
BEGIN
    SELECT group_id AS id, group_name AS `name`, 'Group' AS type
    FROM `group`
    WHERE group_name LIKE CONCAT('%', in_search_string, '%')
    UNION ALL
    SELECT account_id AS id, username AS `name`, 'User' AS type
    FROM account
    WHERE username LIKE CONCAT('%', in_search_string, '%');
END $$
DELIMITER ;

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:  
--  	username sẽ giống email nhưng bỏ phần @..mail đi  	
-- positionID: sẽ có default là developer 
-- 	 	departmentID: sẽ được cho vào 1 phòng chờ 
--  Sau đó in ra kết quả tạo thành công 
DROP PROCEDURE IF EXISTS sp_insert_account;
DELIMITER $$
CREATE PROCEDURE sp_insert_account(
    IN in_full_name VARCHAR(100),
    IN in_email VARCHAR(100)
)
BEGIN
    DECLARE v_username VARCHAR(50);
    DECLARE v_position_id TINYINT UNSIGNED;
    DECLARE v_department_id TINYINT UNSIGNED;
    
    -- Trích xuất Username từ Email (bỏ chuỗi từ ký tự @)
    SET v_username = SUBSTRING_INDEX(in_email, '@', 1);
    
    -- Lấy ID của vị trí 'Dev'
    SELECT position_id INTO v_position_id FROM `position` WHERE position_name = 'Dev' LIMIT 1;
    
    -- Lấy hoặc tạo phòng ban mặc định 'Phòng chờ'
    SELECT department_id INTO v_department_id FROM department WHERE department_name = 'Phòng chờ' LIMIT 1;
    IF v_department_id IS NULL THEN
        INSERT INTO department(department_name) VALUES ('Phòng chờ');
        SET v_department_id = LAST_INSERT_ID();
    END IF;
    
    -- Thêm dữ liệu vào bảng Account
    INSERT INTO account (email, username, full_name, department_id, position_id)
    VALUES (in_email, v_username, in_full_name, v_department_id, v_position_id);
    
    SELECT 'Tạo thành công account mới!' AS message, LAST_INSERT_ID() AS new_account_id;
END $$
DELIMITER ;

-- test 
CALL sp_insert_account('Nguyen Hau', 'haunguyenkkk@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất 
DROP PROCEDURE IF EXISTS sp_get_longest_question_by_type;
DELIMITER $$
CREATE PROCEDURE sp_get_longest_question_by_type(IN in_type_name ENUM('Essay', 'Multiple-Choice'))
BEGIN
    WITH question_length AS (
        SELECT q.*, CHAR_LENGTH(q.content) AS len
        FROM question q
        JOIN type_question tq ON q.type_id = tq.type_id
        WHERE tq.type_name = in_type_name
    )
    SELECT * 
    FROM question_length 
    WHERE len = (SELECT MAX(len) FROM question_length);
END $$
DELIMITER ;

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID 
DROP PROCEDURE IF EXISTS sp_delete_exam_by_id;
DELIMITER $$
CREATE PROCEDURE sp_delete_exam_by_id(IN in_exam_id INT UNSIGNED)
BEGIN
    DELETE FROM exam WHERE exam_id = in_exam_id;
END $$
DELIMITER ;

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) 
--           Sau đó in số lượng record đã remove từ các table liên quan trong khi removing 
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc 
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay 
DROP PROCEDURE IF EXISTS sp_count_question_each_month_this_year;
DELIMITER $$
CREATE PROCEDURE sp_count_question_each_month_this_year()
BEGIN
    WITH RECURSIVE months AS (
        SELECT 1 AS `month`
        UNION ALL
        SELECT `month` + 1 FROM months WHERE `month` < 12
    )
    SELECT 
        m.`month`,
        COUNT(q.question_id) AS total_question
    FROM months m
    LEFT JOIN question q ON m.`month` = MONTH(q.create_date) AND YEAR(q.create_date) = YEAR(CURRENT_DATE())
    GROUP BY m.`month`
    ORDER BY m.`month` ASC;
END $$
DELIMITER ;

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất  
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong  tháng") 
DROP PROCEDURE IF EXISTS sp_count_question_last_6_months;
DELIMITER $$
CREATE PROCEDURE sp_count_question_last_6_months()
BEGIN
    WITH RECURSIVE last_6_months AS (
        SELECT 0 AS n
        UNION ALL
        SELECT n + 1 FROM last_6_months WHERE n < 5
    ),
    time_series AS (
        SELECT 
            MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL n MONTH)) AS `month`,
            YEAR(DATE_SUB(CURRENT_DATE(), INTERVAL n MONTH)) AS `year`
        FROM last_6_months
    )
    SELECT 
        ts.`year`,
        ts.`month`,
        CASE 
            WHEN COUNT(q.question_id) = 0 THEN 'không có câu hỏi nào trong tháng'
            ELSE CAST(COUNT(q.question_id) AS CHAR)
        END AS question_status
    FROM time_series ts
    LEFT JOIN question q ON ts.`month` = MONTH(q.create_date) AND ts.`year` = YEAR(q.create_date)
    GROUP BY ts.`year`, ts.`month`
    ORDER BY ts.`year` DESC, ts.`month` DESC;
END $$
DELIMITER ;

