
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
		SELECT a.*, d.department_name
		FROM account a
		JOIN department d ON a.department_id = d.department_id;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010  
		SELECT a.*, d.department_name, p.position_name
		FROM account a
		JOIN department d ON a.department_id = d.department_id
		JOIN `position` p ON a.position_id = p.position_id
		WHERE a.create_date > '2010-12-20';
        
-- Question 3: Viết lệnh để lấy ra tất cả các developer  
		SELECT a.*, p.position_name
		FROM account a
		JOIN `position` p ON a.position_id = p.position_id
		WHERE p.position_name = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên Question 
		SELECT d.department_id, d.department_name, COUNT(a.account_id) AS total_account
		FROM department d
		JOIN account a ON d.department_id = a.department_id
		GROUP BY d.department_id, d.department_name
		HAVING COUNT(a.account_id) > 3;

-- 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
		SELECT q.*, COUNT(eq.exam_id) AS total_exam
		FROM question q
		JOIN exam_question eq ON q.question_id = eq.question_id
		GROUP BY q.question_id
		HAVING COUNT(eq.exam_id) = (
			SELECT MAX(exam_count)
			FROM (
				SELECT COUNT(exam_id) AS exam_count
				FROM exam_question
				GROUP BY question_id
			) AS temp
		);
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question 
		SELECT cq.category_id, cq.category_name, COUNT(q.question_id) AS total_question
		FROM category_question cq
		LEFT JOIN question q ON cq.category_id = q.category_id
		GROUP BY cq.category_id, cq.category_name;
        
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam /
		SELECT q.question_id, q.content, COUNT(eq.exam_id) AS total_exam
		FROM question q
		LEFT JOIN exam_question eq ON q.question_id = eq.question_id
		GROUP BY q.question_id, q.content;	

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất 
		SELECT q.*, COUNT(a.answer_id) AS total_answer
		FROM question q
		JOIN answer a ON q.question_id = a.question_id
		GROUP BY q.question_id
		HAVING COUNT(a.answer_id) = (
			SELECT MAX(answer_count)
			FROM (
				SELECT COUNT(answer_id) AS answer_count
				FROM answer
				GROUP BY question_id
			) AS temp
		);

-- Question 9: Thống kê số lượng account trong mỗi group  
		SELECT g.group_id, g.group_name, COUNT(ga.account_id) AS total_account
		FROM `group` g
		LEFT JOIN group_account ga ON g.group_id = ga.group_id
		GROUP BY g.group_id, g.group_name;

-- Question 10: Tìm chức vụ có ít người nhất  
		SELECT p.position_id, p.position_name, COUNT(a.account_id) AS total_account
		FROM `position` p
		LEFT JOIN account a ON p.position_id = a.position_id
		GROUP BY p.position_id, p.position_name
		HAVING COUNT(a.account_id) = (
			SELECT MIN(account_count)
			FROM (
				SELECT COUNT(account_id) AS account_count
				FROM `position` p2
				LEFT JOIN account a2 ON p2.position_id = a2.position_id
				GROUP BY p2.position_id
			) AS temp
		);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM  
		SELECT 
			d.department_name,
			COUNT(CASE WHEN p.position_name = 'Dev' THEN 1 END) AS dev_count,
			COUNT(CASE WHEN p.position_name = 'Test' THEN 1 END) AS test_count,
			COUNT(CASE WHEN p.position_name = 'Scrum_Master' THEN 1 END) AS scrum_master_count,
			COUNT(CASE WHEN p.position_name = 'PM' THEN 1 END) AS pm_count
		FROM department d
		LEFT JOIN account a ON d.department_id = a.department_id
		LEFT JOIN `position` p ON a.position_id = p.position_id
		GROUP BY d.department_id, d.department_name;
 
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … 
		SELECT 
			q.question_id,
			q.content AS question_content,
			cq.category_name,
			tq.type_name,
			a_creator.full_name AS creator_name,
			ans.content AS answer_content,
			ans.is_correct
		FROM question q
		LEFT JOIN category_question cq ON q.category_id = cq.category_id
		LEFT JOIN type_question tq ON q.type_id = tq.type_id
		LEFT JOIN account a_creator ON q.creator_id = a_creator.account_id
		LEFT JOIN answer ans ON q.question_id = ans.question_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm 
		SELECT tq.type_id, tq.type_name, COUNT(q.question_id) AS total_question
		FROM type_question tq
		LEFT JOIN question q ON tq.type_id = q.type_id
		GROUP BY tq.type_id, tq.type_name;

-- Question 14:Lấy ra group không có account nào 
		SELECT g.*
		FROM `group` g
		LEFT JOIN group_account ga ON g.group_id = ga.group_id
		WHERE ga.account_id IS NULL;
        
-- Question 16: Lấy ra question không có answer nào 
		SELECT q.*
		FROM question q
		LEFT JOIN answer a ON q.question_id = a.question_id
		WHERE a.answer_id IS NULL;

