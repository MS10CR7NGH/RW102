-- Question 12: Lấy ra thông tin exam trong đó: 
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time" 
SELECT 
    exam_id,
    `code`,
    title,
    duration,
    CASE 
        WHEN duration <= 30 THEN 'Short time'
        WHEN duration <= 60 THEN 'Medium time'
        ELSE 'Long time'
    END AS duration_type
FROM exam;

-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time" Duration > 60 thì sẽ đổi thành giá trị "Long time" 
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few 
-- Nếu số lượng user trong group <= 20 và > 5  thì sẽ có giá trị là normal 
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher 
SELECT 
    g.group_id,
    g.group_name,
    COUNT(ga.account_id) AS total_user,
    CASE 
        WHEN COUNT(ga.account_id) <= 5 THEN 'few'
        WHEN COUNT(ga.account_id) <= 20 THEN 'normal'
        ELSE 'higher'
    END AS the_number_user_amount
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User" 
SELECT 
    d.department_id,
    d.department_name,
    CASE 
        WHEN COUNT(a.account_id) = 0 THEN 'Không có User'
        ELSE CAST(COUNT(a.account_id) AS CHAR)
    END AS user_count_status
FROM department d
LEFT JOIN account a ON d.department_id = a.department_id
GROUP BY d.department_id, d.department_name;

