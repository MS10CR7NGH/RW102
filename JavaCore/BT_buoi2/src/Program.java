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

        printInitialValues();

//        System.out.println("\n========== EXERCISE 2: SYSTEM OUT PRINTF ==========\n");
//        Exercise2.question1();
//        Exercise2.question2();
//        Exercise2.question3();
//        Exercise2.question4();
//        Exercise2.question5();
//        Exercise2.question6(acc1, acc2, acc3);
//
//        System.out.println("\n========== EXERCISE 3: DATE FORMAT ==========\n");
//        Exercise3.question1(exam1);
//        Exercise3.question2(exam1);
//        Exercise3.question3(exam1);
//        Exercise3.question4(exam1);
//        Exercise3.question5(exam1);
//
//        System.out.println("\n========== EXERCISE 4: RANDOM NUMBER ==========\n");
//        Exercise4.question1();
//        Exercise4.question2();
//        Exercise4.question3();
//        Exercise4.question4();
//        Exercise4.question5();
//        Exercise4.question6();
//        Exercise4.question7();
//
//        Account[] accounts = { acc1, acc2, acc3 };
//        Group[] groups = { group1, group2, group3 };
//        System.out.println("\n========== EXERCISE 5: INPUT FROM CONSOLE ==========\n");
//        // Exercise5.question1();
//        // Exercise5.question2();
//        // Exercise5.question3();
//        // Exercise5.question4();
//        // Exercise5.question7();
//        Exercise5.question11(accounts, groups);
//
//        System.out.println("\n========== EXERCISE 6: METHOD ==========\n");
//        Exercise6.question1();
//        Exercise6.question2(accounts);
//        Exercise6.question3();
        Exercise5.questionDemo();


//        System.out.println("\n========== KẾT QUẢ CÁC CÂU HỎI ==========\n");
//        question1();
//        question2();
//        question3();
//        question4();
//        question5();
//        question6();
//        question7();
//        question8();
//        question9();
//        question10();
//        question11();
//        question12();
//        question13();
//        question14();
//        question15();
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
        group1.setName("Testing System");
        group1.setCreator(acc1);
        group1.setCreateDate(LocalDate.of(2023, 4, 1));

        group2 = new Group();
        group2.setId(2);
        group2.setName("Development");
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

    public static void printInitialValues() {
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


    public static void question1() {
        System.out.println("--- Question 1 ---");
        if (acc2.getDepartment() == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + acc2.getDepartment().getName());
        }
    }

    public static void question2() {
        System.out.println("--- Question 2 ---");
        GroupAccount[] groupAccounts = { ga1, ga2, ga3 };

        int groupCountAcc2 = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.getAccount().getId() == acc2.getId()) {
                groupCountAcc2++;
            }
        }

        if (groupCountAcc2 == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (groupCountAcc2 == 1 || groupCountAcc2 == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (groupCountAcc2 == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    public static void question3() {
        System.out.println("\n--- Question 3 ---");
        String deptResult = (acc2.getDepartment() == null)
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là " + acc2.getDepartment().getName();
        System.out.println(deptResult);
    }

    public static void question4() {
        System.out.println("\n--- Question 4 ---");
        //CHÚ Ý: TRONG ACCOUT PHẢI CÓ GIÁ TRỊ => PHẢI CHECK TRC ĐỂ XEM CÓ GIÁ TRỊ KO NẾU KO CHECK MÀ RƠI VÀO TRƯỜNG HỢP POSITION = NULL THÌ SẼ LỖI KO CHECK DC POSITION.GETNAME (VÌ NULL KO PHẢI LÀ GIÁ TRỊ)
        String devResult = (acc1.getPosition() != null && acc1.getPosition().getName() == PositionName.DEV)
                ? "Đây là Developer"
                : "Người này không phải là Developer";
        System.out.println(devResult);

    }

    public static void question5() {
        System.out.println("--- Question 5 ---");
        GroupAccount[] groupAccounts = { ga1, ga2, ga3 };

        int accountCountGroup1 = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.getGroup().getId() == group1.getId()) {
                accountCountGroup1++;
            }
        }

        switch (accountCountGroup1) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }
    }

    public static void question6() {
        System.out.println("\n--- Question 6 ---");
        GroupAccount[] groupAccounts = { ga1, ga2, ga3 };


        int groupCountAcc2 = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.getAccount().getId() == acc2.getId()) {
                groupCountAcc2++;
            }
        }

        switch (groupCountAcc2) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
        }
    }

    public static void question7() {
        System.out.println("\n--- Question 7 ---");
        PositionName posNameAcc1 = (acc1.getPosition() != null) ? acc1.getPosition().getName() : null;

        if (posNameAcc1 != null) {
            switch (posNameAcc1) {
                case DEV:
                    System.out.println("Đây là Developer");
                    break;
                default:
                    System.out.println("Người này không phải là Developer");
                    break;
            }
        } else {
            System.out.println("Người này không phải là Developer");
        }
    }

    public static void question8() {
        System.out.println("\n--- Question 8 ---");
        Account[] accounts = { acc1, acc2, acc3 };

        for (Account acc : accounts) {
            String deptName = (acc.getDepartment() != null) ? acc.getDepartment().getName() : "Chưa có";
            System.out.println("Email: " + acc.getEmail() + " | FullName: " + acc.getFullName() + " | Phòng ban: " + deptName);
        }
    }

    public static void question9() {
        System.out.println("\n--- Question 9 ---");
        Department[] departments = { dept1, dept2, dept3 };

        for (Department dept : departments) {
            System.out.println("ID: " + dept.getId() + " | Name: " + dept.getName());
        }
    }

    public static void question10() {
        System.out.println("\n--- Question 10 ---");
        Account[] accounts = { acc1, acc2, acc3 };

        for (int i = 0; i < accounts.length; i++) {
            String deptName = (accounts[i].getDepartment() != null) ? accounts[i].getDepartment().getName() : "N/A";
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            System.out.println("Phòng ban: " + deptName + "\n");
        }
    }

    public static void question11() {
        System.out.println("\n--- Question 11 ---");
        Department[] departments = { dept1, dept2, dept3 };

        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\tId: " + departments[i].getId());
            System.out.println("\tName: " + departments[i].getName());
        }
    }

    public static void question12() {
        System.out.println("\n--- Question 12 ---");
        Department[] departments = { dept1, dept2, dept3 };

        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\tId: " + departments[i].getId());
            System.out.println("\tName: " + departments[i].getName());
        }
    }

    public static void question13() {
        System.out.println("\n--- Question 13 ---");
        Account[] accounts = { acc1, acc2, acc3 };

        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) {
                continue;
            }
            String deptName = (accounts[i].getDepartment() != null) ? accounts[i].getDepartment().getName() : "N/A";
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].getEmail());
            System.out.println("Full name: " + accounts[i].getFullName());
            System.out.println("Phòng ban: " + deptName + "\n");
        }
    }

    public static void question14() {
        System.out.println("\n--- Question 14 ---");
        Account[] accounts = { acc1, acc2, acc3 };

        for (Account acc : accounts) {
            if (acc.getId() < 4) {
                String deptName = (acc.getDepartment() != null) ? acc.getDepartment().getName() : "N/A";
                System.out.println("ID: " + acc.getId() + " | Email: " + acc.getEmail() + " | FullName: " + acc.getFullName() + " | Phòng ban: " + deptName);
            }
        }
    }

    public static void question15() {
        System.out.println("\n--- Question 15 ---");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}