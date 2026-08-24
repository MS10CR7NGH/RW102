
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
    DepartmentID    TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName  VARCHAR(50) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
    PositionID      TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName    ENUM('Dev', 'Test', 'Scrum_Master', 'PM') NOT NULL UNIQUE
);

DROP TABLE IF EXISTS Account;
CREATE TABLE Account (
    AccountID       INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email           VARCHAR(100) NOT NULL UNIQUE,
    Username        VARCHAR(50) NOT NULL UNIQUE,
    FullName        VARCHAR(100) NOT NULL,
    DepartmentID    TINYINT UNSIGNED NOT NULL,
    PositionID      TINYINT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID) ON DELETE CASCADE,
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
    GroupID         INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName       VARCHAR(100) NOT NULL,
    CreatorID       INT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
    GroupID         INT UNSIGNED NOT NULL,
    AccountID       INT UNSIGNED NOT NULL,
    JoinDate        DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE,
    FOREIGN KEY (AccountID) REFERENCES Account(AccountID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID          TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName        ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE
);

DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion (
    CategoryID      TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName    VARCHAR(50) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
    QuestionID      INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content         TEXT NOT NULL,
    CategoryID      TINYINT UNSIGNED NOT NULL,
    TypeID          TINYINT UNSIGNED NOT NULL,
    CreatorID       INT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
    AnswerID        INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content         TEXT NOT NULL,
    QuestionID      INT UNSIGNED NOT NULL,
    isCorrect       BOOLEAN DEFAULT TRUE,
    
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
    ExamID          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`          VARCHAR(20) NOT NULL UNIQUE,
    Title           VARCHAR(100) NOT NULL,
    CategoryID      TINYINT UNSIGNED NOT NULL,
    Duration        TINYINT UNSIGNED NOT NULL, -- Thời gian tính theo phút
    CreatorID       INT UNSIGNED NOT NULL,
    CreateDate      DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
    ExamID          INT UNSIGNED NOT NULL,
    QuestionID      INT UNSIGNED NOT NULL,
    
    PRIMARY KEY (ExamID, QuestionID),
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID) ON DELETE CASCADE,
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE
);

USE TestingSystem;
-- 1.Department
INSERT INTO Department (DepartmentName)
VALUES 
    (N'Marketing'),
    (N'Sale'),
    (N'Bảo vệ'),
    (N'Nhân sự'),
    (N'Kỹ thuật');

-- 2.Position
INSERT INTO `Position` (PositionName)
VALUES 
    ('Dev'),
    ('Test'),
    ('Scrum_Master'),
    ('PM');

-- 3.Account
INSERT INTO Account (Email, Username, FullName, DepartmentID, PositionID)
VALUES 
    ('haidang29@gmail.com', 'haidang29', N'Nguyễn Hải Đăng', 5, 1),
    ('account1@gmail.com', 'quangnguyen', N'Nguyễn Vinh Quang', 1, 2),
    ('account2@gmail.com', 'hainguyen', N'Nguyễn Văn Hải', 2, 2),
    ('account3@gmail.com', 'duongdo', N'Đỗ Thế Dương', 3, 3),
    ('account4@gmail.com', 'anhlan', N'Lần Thị Anh', 4, 4);

-- 4.Group
INSERT INTO `Group` (GroupName, CreatorID)
VALUES 
    (N'Testing System', 5),
    (N'Development', 1),
    (N'VTI Sale 01', 2),
    (N'VTI Sale 02', 3),
    (N'VTI Sale 03', 4);

-- 5.GroupAccount
INSERT INTO GroupAccount (GroupID, AccountID)
VALUES 
    (1, 1),
    (1, 3),
    (2, 2),
    (3, 4),
    (4, 5);

-- 6.TypeQuestion
INSERT INTO TypeQuestion (TypeName)
VALUES 
    ('Essay'),
    ('Multiple-Choice');

-- 7.CategoryQuestion
INSERT INTO CategoryQuestion (CategoryName)
VALUES 
    ('Java'),
    ('ASP.NET'),
    ('ADO.NET'),
    ('SQL'),
    ('Postman');

-- 8.Question
INSERT INTO Question (Content, CategoryID, TypeID, CreatorID)
VALUES 
    (N'Hỏi về Java', 1, 1, 1),
    (N'Hỏi về ASP.NET', 2, 2, 2),
    (N'Hỏi về ADO.NET', 3, 2, 3),
    (N'Hỏi về SQL', 4, 1, 4),
    (N'Hỏi về Postman', 5, 1, 5);

-- 9.Answer
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES 
    (N'Trả lời 01 - Java', 1, 0),
    (N'Trả lời 02 - ASP.NET', 1, 1),
    (N'Trả lời 03 - ADO.NET', 2, 0),
    (N'Trả lời 04 - SQL', 3, 1),
    (N'Trả lời 05 - Postman', 4, 1);

-- 10.Exam
INSERT INTO Exam (`Code`, Title, CategoryID, Duration, CreatorID)
VALUES 
    ('VTIQ001', N'Đề thi Java', 1, 60, 5),
    ('VTIQ002', N'Đề thi C#', 2, 60, 1),
    ('VTIQ003', N'Đề thi SQL', 4, 120, 2),
    ('VTIQ004', N'Đề thi Postman', 5, 60, 3),
    ('VTIQ005', N'Đề thi ADO.NET', 3, 120, 4);

-- 11.ExamQuestion
INSERT INTO ExamQuestion (ExamID, QuestionID)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);