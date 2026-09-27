import java.time.LocalDate;

public class Program {

    private static Department dept1, dept2, dept3;
    private static Position pos1, pos2, pos3;
    private static Account acc1, acc2, acc3;
    private static Group group1, group2, group3;
    private static GroupAccount ga1, ga2, ga3;
    private static TypeQuestion type1, type2, type3;
    private static CategoryQuestion cat1, cat2, cat3;
    private static Question q1, q2, q3;
    private static Answer ans1, ans2, ans3;
    private static Exam exam1, exam2, exam3;
    private static ExamQuestion eq1, eq2, eq3;

    public static void main(String[] args) {
        initData();

        Account[] accounts = { acc1, acc2, acc3 };
        Group[] groups = { group1, group2, group3 };
        Department[] departments = { dept1, dept2, dept3 };

        System.out.println("\n========== EXERCISE 4 ==========\n");
//        Exercise4.question1();
//        Exercise4.question2();
//        Exercise4.question3();
//        Exercise4.question4();
//        Exercise4.question5();
//        Exercise4.question6();
//        Exercise4.question7();
//        Exercise4.question8(groups);
//        Exercise4.question9(groups);
//        Exercise4.question10();
        Exercise4.question11();
//        Exercise4.question12();
//        Exercise4.question13();
//        Exercise4.question14();
//        Exercise4.question15();
//        Exercise4.question16();

        System.out.println("\n========== EXERCISE 4 ==========\n");
//        Exercise5.question5(departments);
//        Exercise5.question6();

    }


    public static void initData() {
        // 1. Department
        dept1 = new Department(1, "Marketing");
        dept2 = new Department(2, "Sale");
        dept3 = new Department(3, "Kỹ thuật");

        // 2. Position
        pos1 = new Position(1, PositionName.DEV);
        pos2 = new Position(2, PositionName.TEST);
        pos3 = new Position(3, PositionName.PM);

        // 3. Account
        acc1 = new Account();
        acc1.setId(1);
        acc1.setEmail("haidang29@gmail.com");
        acc1.setUsername("haidang29");
        acc1.setFullName("Nguyễn Hậu");
        acc1.setDepartment(dept3);
        acc1.setPosition(pos1);
        acc1.setCreateDate(LocalDate.of(2023, 1, 15));

        acc2 = new Account();
        acc2.setId(2);
        acc2.setEmail("quangnguyen@gmail.com");
        acc2.setUsername("quangnguyen");
        acc2.setFullName("Nguyễn Vinh Quang");
        acc2.setDepartment(dept1);
        acc2.setPosition(pos2);
        acc2.setCreateDate(LocalDate.of(2023, 2, 20));

        acc3 = new Account();
        acc3.setId(3);
        acc3.setEmail("hainguyen@gmail.com");
        acc3.setUsername("hainguyen");
        acc3.setFullName("Nguyễn Văn Hải");
        acc3.setDepartment(dept2);
        acc3.setPosition(pos3);
        acc3.setCreateDate(LocalDate.of(2023, 3, 10));

        // 4. Group
        group1 = new Group();
        group1.setId(1);
        group1.setName("Testing System Java");
        group1.setCreator(acc1);
        group1.setCreateDate(LocalDate.of(2023, 4, 1));

        group2 = new Group();
        group2.setId(2);
        group2.setName("Java");
        group2.setCreator(acc2);
        group2.setCreateDate(LocalDate.of(2023, 4, 5));

        group3 = new Group();
        group3.setId(3);
        group3.setName("VTI Sale 01");
        group3.setCreator(acc3);
        group3.setCreateDate(LocalDate.of(2023, 4, 10));

        // 5. GroupAccount
        ga1 = new GroupAccount(group1, acc1, LocalDate.of(2023, 4, 2));
        ga2 = new GroupAccount(group1, acc2, LocalDate.of(2023, 4, 3));
        ga3 = new GroupAccount(group2, acc3, LocalDate.of(2023, 4, 6));

        // 6. TypeQuestion
        type1 = new TypeQuestion();
        type1.setId(1);
        type1.setName(TypeName.ESSAY);

        type2 = new TypeQuestion();
        type2.setId(2);
        type2.setName(TypeName.MULTIPLE_CHOICE);

        type3 = new TypeQuestion();
        type3.setId(3);
        type3.setName(TypeName.ESSAY);

        // 7. CategoryQuestion
        cat1 = new CategoryQuestion();
        cat1.setId(1);
        cat1.setName("Java");

        cat2 = new CategoryQuestion();
        cat2.setId(2);
        cat2.setName("ASP.NET");

        cat3 = new CategoryQuestion();
        cat3.setId(3);
        cat3.setName("SQL");

        // 8. Question
        q1 = new Question();
        q1.setId(1);
        q1.setContent("Hỏi về Java OOP");
        q1.setCategory(cat1);
        q1.setType(type1);
        q1.setCreator(acc1);
        q1.setCreateDate(LocalDate.of(2023, 5, 1));

        q2 = new Question();
        q2.setId(2);
        q2.setContent("Hỏi về ASP.NET Core");
        q2.setCategory(cat2);
        q2.setType(type2);
        q2.setCreator(acc2);
        q2.setCreateDate(LocalDate.of(2023, 5, 2));

        q3 = new Question();
        q3.setId(3);
        q3.setContent("Hỏi về SQL Join");
        q3.setCategory(cat3);
        q3.setType(type2);
        q3.setCreator(acc3);
        q3.setCreateDate(LocalDate.of(2023, 5, 3));

        // 9. Answer
        ans1 = new Answer();
        ans1.setId(1);
        ans1.setContent("Trả lời 01 - Java là ngôn ngữ OOP");
        ans1.setQuestion(q1);
        ans1.setCorrect(true);

        ans2 = new Answer();
        ans2.setId(2);
        ans2.setContent("Trả lời 02 - ASP.NET chạy trên .NET Framework");
        ans2.setQuestion(q2);
        ans2.setCorrect(false);

        ans3 = new Answer();
        ans3.setId(3);
        ans3.setContent("Trả lời 03 - SQL Join ghép bảng dựa trên PK/FK");
        ans3.setQuestion(q3);
        ans3.setCorrect(true);

        // 10. Exam
        exam1 = new Exam();
        exam1.setId(1);
        exam1.setCode("VTIQ001");
        exam1.setTitle("Đề thi Java Basic");
        exam1.setCategory(cat1);
        exam1.setDuration(60);
        exam1.setCreator(acc1);
        exam1.setCreateDate(LocalDate.of(2023, 6, 1));

        exam2 = new Exam();
        exam2.setId(2);
        exam2.setCode("VTIQ002");
        exam2.setTitle("Đề thi C# / ASP.NET");
        exam2.setCategory(cat2);
        exam2.setDuration(90);
        exam2.setCreator(acc2);
        exam2.setCreateDate(LocalDate.of(2023, 6, 2));

        exam3 = new Exam();
        exam3.setId(3);
        exam3.setCode("VTIQ003");
        exam3.setTitle("Đề thi SQL Advanced");
        exam3.setCategory(cat3);
        exam3.setDuration(120);
        exam3.setCreator(acc3);
        exam3.setCreateDate(LocalDate.of(2023, 6, 3));

        // 11. ExamQuestion
        eq1 = new ExamQuestion(exam1, q1);
        eq2 = new ExamQuestion(exam1, q3);
        eq3 = new ExamQuestion(exam2, q2);
    }



}