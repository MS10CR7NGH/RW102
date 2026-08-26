-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
		CREATE OR REPLACE VIEW vw_sale_accounts AS
		SELECT a.account_id, a.email, a.username, a.full_name, d.department_name
		FROM account a
		JOIN department d ON a.department_id = d.department_id
		WHERE d.department_name = 'Sale';
		SELECT * FROM vw_sale_accounts;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
		WITH account_group_count AS (
			SELECT account_id, COUNT(group_id) AS group_count
			FROM group_account
			GROUP BY account_id
		),
		max_group_count AS (
			SELECT MAX(group_count) AS max_count 
			FROM account_group_count
		)
		SELECT a.*, agc.group_count
		FROM account a
		JOIN account_group_count agc ON a.account_id = agc.account_id
		WHERE agc.group_count = (SELECT max_count FROM max_group_count);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
		WITH long_questions AS (
			SELECT question_id 
			FROM question
			WHERE (LENGTH(TRIM(content)) - LENGTH(REPLACE(TRIM(content), ' ', '')) + 1) > 300
		)
		SELECT * FROM question WHERE question_id IN (SELECT question_id FROM long_questions);

		WITH long_questions AS (
			SELECT question_id 
			FROM question
			WHERE (LENGTH(TRIM(content)) - LENGTH(REPLACE(TRIM(content), ' ', '')) + 1) > 300
		)
		DELETE FROM question 
		WHERE question_id IN (SELECT question_id FROM long_questions);

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
		WITH dept_account_count AS (
			SELECT d.department_id, d.department_name, COUNT(a.account_id) AS total_account
			FROM department d
			LEFT JOIN account a ON d.department_id = a.department_id
			GROUP BY d.department_id, d.department_name
		),
		max_dept_count AS (
			SELECT MAX(total_account) AS max_count 
			FROM dept_account_count
		)
		SELECT * 
		FROM dept_account_count
		WHERE total_account = (SELECT max_count FROM max_dept_count);

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
		CREATE OR REPLACE VIEW vw_questions_by_nguyen AS
		SELECT q.question_id, q.content, a.full_name AS creator_name, q.create_date
		FROM question q
		JOIN account a ON q.creator_id = a.account_id
		WHERE a.full_name LIKE 'Nguyễn%';

		SELECT * FROM vw_questions_by_nguyen;
