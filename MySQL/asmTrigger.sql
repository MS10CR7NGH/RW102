-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước 
DELIMITER $$
CREATE TRIGGER trg_check_group_create_date
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
    IF NEW.create_date <= DATE_SUB(CURRENT_DATE(), INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Ngày tạo group không được trước 1 năm!';
    END IF;
END $$
DELIMITER ;

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user" 
DELIMITER $$
CREATE TRIGGER trg_prevent_insert_sale_department
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    DECLARE v_sale_dept_id TINYINT UNSIGNED;
    
    SELECT department_id INTO v_sale_dept_id 
    FROM department 
    WHERE department_name = 'Sale' LIMIT 1;
    
    IF NEW.department_id = v_sale_dept_id THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END $$
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user 
DELIMITER $$
CREATE TRIGGER trg_limit_account_in_group
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
    DECLARE v_user_count TINYINT;
    
    SELECT COUNT(*) INTO v_user_count 
    FROM group_account 
    WHERE group_id = NEW.group_id;
    
    IF v_user_count >= 5 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Group này đã đủ tối đa 5 user, không thể thêm!';
    END IF;
END $$
DELIMITER ;

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question 
DELIMITER $$
CREATE TRIGGER trg_limit_question_in_exam
BEFORE INSERT ON exam_question
FOR EACH ROW
BEGIN
    DECLARE v_question_count TINYINT;
    
    SELECT COUNT(*) INTO v_question_count 
    FROM exam_question 
    WHERE exam_id = NEW.exam_id;
    
    IF v_question_count >= 10 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Bài thi này đã chứa tối đa 10 câu hỏi!';
    END IF;
END $$
DELIMITER ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó 
DELIMITER $$
CREATE TRIGGER trg_prevent_delete_admin
BEFORE DELETE ON account
FOR EACH ROW
BEGIN
    IF OLD.email = 'admin@gmail.com' THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Đây là tài khoản admin, không được phép xóa!';
    END IF;
END $$
DELIMITER ;

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"   
DELIMITER $$
CREATE TRIGGER trg_set_default_department
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    DECLARE v_waiting_dept_id TINYINT UNSIGNED;
    
    IF NEW.department_id IS NULL THEN
        SELECT department_id INTO v_waiting_dept_id 
        FROM department 
        WHERE department_name = 'waiting Department' LIMIT 1;
        
        IF v_waiting_dept_id IS NULL THEN
            INSERT INTO department(department_name) VALUES ('waiting Department');
            SET v_waiting_dept_id = LAST_INSERT_ID();
        END IF;
        
        SET NEW.department_id = v_waiting_dept_id;
    END IF;
END $$
DELIMITER ;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng. 
DELIMITER $$
CREATE TRIGGER trg_limit_answer_per_question
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
    DECLARE v_total_answers TINYINT;
    DECLARE v_correct_answers TINYINT;
    
    SELECT COUNT(*), SUM(IF(is_correct = TRUE, 1, 0)) 
    INTO v_total_answers, v_correct_answers
    FROM answer 
    WHERE question_id = NEW.question_id;
    
    IF v_total_answers >= 4 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Mỗi câu hỏi chỉ được tạo tối đa 4 đáp án!';
    END IF;
    
    IF NEW.is_correct = TRUE AND v_correct_answers >= 2 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Mỗi câu hỏi chỉ được chứa tối đa 2 đáp án đúng!';
    END IF;
END $$
DELIMITER ;

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database 

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 
DROP TRIGGER IF EXISTS trg_prevent_delete_recent_exam;
DELIMITER $$
CREATE TRIGGER trg_prevent_delete_recent_exam
BEFORE DELETE ON exam
FOR EACH ROW
BEGIN
    IF OLD.create_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 2 DAY) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Bài thi mới tạo trong vòng 2 ngày không được phép xóa!';
    END IF;
END $$
DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào 
DELIMITER $$
CREATE TRIGGER trg_prevent_delete_used_question
BEFORE DELETE ON question
FOR EACH ROW
BEGIN
    DECLARE v_exam_count INT;
    
    SELECT COUNT(*) INTO v_exam_count 
    FROM exam_question 
    WHERE question_id = OLD.question_id;
    
    IF v_exam_count > 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Câu hỏi này đã có trong bài thi, không thể xóa!';
    END IF;
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER trg_prevent_update_used_question
BEFORE UPDATE ON question
FOR EACH ROW
BEGIN
    DECLARE v_exam_count INT;
    
    SELECT COUNT(*) INTO v_exam_count 
    FROM exam_question 
    WHERE question_id = NEW.question_id;
    
    IF v_exam_count > 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Câu hỏi này đã có trong bài thi, không thể cập nhật!';
    END IF;
END $$
DELIMITER ;

