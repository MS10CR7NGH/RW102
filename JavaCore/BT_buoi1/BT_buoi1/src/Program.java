import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {

        // 1. Department
        Department dept1 = new Department(1, "Marketing");
        Department dept2 = new Department(2, "Sale");
        Department dept3 = new Department(3, "Kỹ thuật");

        // 2. Position
        Position pos1 = new Position(1, PositionName.DEV);
        Position pos2 = new Position(2, PositionName.TEST);
        Position pos3 = new Position(3, PositionName.PM);

        // 3. Account
        Account acc1 = new Account();
        acc1.setId(1);
        acc1.setEmail("haidang29@gmail.com");
        acc1.setUsername("haidang29");
        acc1.setFullName("Nguyễn Hậu");
        acc1.setDepartment(dept3);
        acc1.setPosition(pos1);
        acc1.setCreateDate(LocalDate.of(2023, 1, 15));

        Account acc2 = new Account();
        acc2.setId(2);
        acc2.setEmail("quangnguyen@gmail.com");
        acc2.setUsername("quangnguyen");
        acc2.setFullName("Nguyễn Vinh Quang");
        acc2.setDepartment(dept1);
        acc2.setPosition(pos2);
        acc2.setCreateDate(LocalDate.of(2023, 2, 20));

        Account acc3 = new Account();
        acc3.setId(3);
        acc3.setEmail("hainguyen@gmail.com");
        acc3.setUsername("hainguyen");
        acc3.setFullName("Nguyễn Văn Hải");
        acc3.setDepartment(dept2);
        acc3.setPosition(pos3);
        acc3.setCreateDate(LocalDate.of(2023, 3, 10));

        // 4. Group
        Group group1 = new Group();
        group1.setId(1);
        group1.setName("Testing System");
        group1.setCreator(acc1);
        group1.setCreateDate(LocalDate.of(2023, 4, 1));

        Group group2 = new Group();
        group2.setId(2);
        group2.setName("Development");
        group2.setCreator(acc2);
        group2.setCreateDate(LocalDate.of(2023, 4, 5));

        Group group3 = new Group();
        group3.setId(3);
        group3.setName("VTI Sale 01");
        group3.setCreator(acc3);
        group3.setCreateDate(LocalDate.of(2023, 4, 10));

        // 5. GroupAccount
        GroupAccount ga1 = new GroupAccount(group1, acc1, LocalDate.of(2023, 4, 2));
        GroupAccount ga2 = new GroupAccount(group1, acc2, LocalDate.of(2023, 4, 3));
        GroupAccount ga3 = new GroupAccount(group2, acc3, LocalDate.of(2023, 4, 6));

        // 6. TypeQuestion
        TypeQuestion type1 = new TypeQuestion();
        type1.setId(1);
        type1.setName(TypeName.ESSAY);

        TypeQuestion type2 = new TypeQuestion();
        type2.setId(2);
        type2.setName(TypeName.MULTIPLE_CHOICE);

        TypeQuestion type3 = new TypeQuestion();
        type3.setId(3);
        type3.setName(TypeName.ESSAY);

        // 7. CategoryQuestion
        CategoryQuestion cat1 = new CategoryQuestion();
        cat1.setId(1);
        cat1.setName("Java");

        CategoryQuestion cat2 = new CategoryQuestion();
        cat2.setId(2);
        cat2.setName("ASP.NET");

        CategoryQuestion cat3 = new CategoryQuestion();
        cat3.setId(3);
        cat3.setName("SQL");

        // 8. Question
        Question q1 = new Question();
        q1.setId(1);
        q1.setContent("Hỏi về Java OOP");
        q1.setCategory(cat1);
        q1.setType(type1);
        q1.setCreator(acc1);
        q1.setCreateDate(LocalDate.of(2023, 5, 1));

        Question q2 = new Question();
        q2.setId(2);
        q2.setContent("Hỏi về ASP.NET Core");
        q2.setCategory(cat2);
        q2.setType(type2);
        q2.setCreator(acc2);
        q2.setCreateDate(LocalDate.of(2023, 5, 2));

        Question q3 = new Question();
        q3.setId(3);
        q3.setContent("Hỏi về SQL Join");
        q3.setCategory(cat3);
        q3.setType(type2);
        q3.setCreator(acc3);
        q3.setCreateDate(LocalDate.of(2023, 5, 3));

        // 9. Answer
        Answer ans1 = new Answer();
        ans1.setId(1);
        ans1.setContent("Trả lời 01 - Java là ngôn ngữ OOP");
        ans1.setQuestion(q1);
        ans1.setCorrect(true);

        Answer ans2 = new Answer();
        ans2.setId(2);
        ans2.setContent("Trả lời 02 - ASP.NET chạy trên .NET Framework");
        ans2.setQuestion(q2);
        ans2.setCorrect(false);

        Answer ans3 = new Answer();
        ans3.setId(3);
        ans3.setContent("Trả lời 03 - SQL Join ghép bảng dựa trên PK/FK");
        ans3.setQuestion(q3);
        ans3.setCorrect(true);

        // 10. Exam
        Exam exam1 = new Exam();
        exam1.setId(1);
        exam1.setCode("VTIQ001");
        exam1.setTitle("Đề thi Java Basic");
        exam1.setCategory(cat1);
        exam1.setDuration(60);
        exam1.setCreator(acc1);
        exam1.setCreateDate(LocalDate.of(2023, 6, 1));

        Exam exam2 = new Exam();
        exam2.setId(2);
        exam2.setCode("VTIQ002");
        exam2.setTitle("Đề thi C# / ASP.NET");
        exam2.setCategory(cat2);
        exam2.setDuration(90);
        exam2.setCreator(acc2);
        exam2.setCreateDate(LocalDate.of(2023, 6, 2));

        Exam exam3 = new Exam();
        exam3.setId(3);
        exam3.setCode("VTIQ003");
        exam3.setTitle("Đề thi SQL Advanced");
        exam3.setCategory(cat3);
        exam3.setDuration(120);
        exam3.setCreator(acc3);
        exam3.setCreateDate(LocalDate.of(2023, 6, 3));

        // 11. ExamQuestion
        ExamQuestion eq1 = new ExamQuestion(exam1, q1);
        ExamQuestion eq2 = new ExamQuestion(exam1, q3);
        ExamQuestion eq3 = new ExamQuestion(exam2, q2);

        // IN GIÁ TRỊ CỦA TẤT CẢ CÁC ĐỐI TƯỢNG RA MÀN HÌNH
        System.out.println("========== IN GIÁ TRỊ CÁC ĐỐI TƯỢNG ==========\n");
        System.out.println("1. Department Name: " + dept1.getName());
        System.out.println("2. Position Name: " + pos1.getName().getValue());
        System.out.println("3. Account FullName: " + acc1.getFullName());
        System.out.println("4. Group Name: " + group1.getName());
        System.out.println("5. GroupAccount JoinDate: " + ga1.getJoinDate());
        System.out.println("6. TypeQuestion Name: " + type1.getName().getValue());
        System.out.println("7. CategoryQuestion Name: " + cat1.getName());
        System.out.println("8. Question Content: " + q1.getContent());
        System.out.println("9. Answer Content: " + ans1.getContent());
        System.out.println("10. Exam Title: " + exam1.getTitle());
        System.out.println("11. ExamQuestion Code: " + eq1.getExam().getCode());
    }
}