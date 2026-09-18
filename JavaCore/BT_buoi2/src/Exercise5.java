import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {

    private static Scanner scanner = new Scanner(System.in);

    public static void question1() {
        System.out.println("--- Question 1 ---");
        System.out.println("Mời bạn nhập vào 3 số nguyên:");
        System.out.print("Số 1: ");
        int a = scanner.nextInt();
        System.out.print("Số 2: ");
        int b = scanner.nextInt();
        System.out.print("Số 3: ");
        int c = scanner.nextInt();
        System.out.printf("3 số nguyên vừa nhập: %d, %d, %d%n%n", a, b, c);
    }

    public static void question2() {
        System.out.println("--- Question 2 ---");
        System.out.println("Mời bạn nhập vào 2 số thực:");
        System.out.print("Số 1: ");
        float f1 = scanner.nextFloat();
        System.out.print("Số 2: ");
        float f2 = scanner.nextFloat();
        System.out.printf("2 số thực vừa nhập: %.2f, %.2f%n%n", f1, f2);
    }

    public static void question3() {
        System.out.println("--- Question 3 ---");
        scanner.nextLine();
        System.out.print("Mời bạn nhập họ và tên: ");
        String fullName = scanner.nextLine();
        System.out.println("Họ và tên của bạn là: " + fullName + "\n");
    }


    public static void question4() {
        System.out.println("--- Question 4 ---");
        System.out.print("Mời bạn nhập ngày sinh (định dạng dd/MM/yyyy): ");
        String dateString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(dateString, formatter);
        System.out.println("Ngày sinh của bạn là: " + birthDate + "\n");
    }

    public static Account question5() {
        System.out.println("--- Question 5 (Tạo Account) ---");
        Account acc = new Account();

        System.out.print("Nhập ID: ");
        acc.setId(scanner.nextInt());

        System.out.print("Nhập Email: ");
        acc.setEmail(scanner.next());

        System.out.print("Nhập Username: ");
        acc.setUsername(scanner.next());

        scanner.nextLine();
        System.out.print("Nhập Full Name: ");
        acc.setFullName(scanner.nextLine());

        System.out.println("Mời bạn chọn Position (1: Dev, 2: Test, 3: Scrum_Master, 4: PM): ");
        int posNum = scanner.nextInt();
        Position position = new Position();
        switch (posNum) {
            case 1:
                position.setName(PositionName.DEV);
                break;
            case 2:
                position.setName(PositionName.TEST);
                break;
            case 3:
                position.setName(PositionName.SCRUM_MASTER);
                break;
            case 4:
                position.setName(PositionName.PM);
                break;
            default:
                position.setName(PositionName.DEV);
                break;
        }
        acc.setPosition(position);
        acc.setCreateDate(LocalDate.now());

        System.out.println("Tạo thành công Account: " + acc.getUsername() + "\n");
        return acc;
    }

    public static Department question6() {
        System.out.println("--- Question 6 (Tạo Department) ---");
        Department dept = new Department();

        System.out.print("Nhập ID Department: ");
        dept.setId(scanner.nextInt());

        scanner.nextLine();
        System.out.print("Nhập tên Department: ");
        dept.setName(scanner.nextLine());

        System.out.println("Tạo thành công Department: " + dept.getName() + "\n");
        return dept;
    }

    public static void question7() {
        System.out.println("--- Question 7 ---");
        while (true) {
            System.out.print("Mời bạn nhập vào 1 số chẵn: ");
            int number = scanner.nextInt();
            if (number % 2 == 0) {
                System.out.println("Số chẵn bạn vừa nhập là: " + number + "\n");
                break;
            } else {
                System.out.println("Số bạn nhập không phải số chẵn. Mời nhập lại!");
            }
        }
    }

    public static void question8() {
        while (true) {
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            if (choice == 1) {
                question5();
                break;
            } else if (choice == 2) {
                question6();
                break;
            } else {
                System.out.println("Mời bạn nhập lại!\n");
            }
        }
    }

    public static void question9(Account[] accounts, Group[] groups) {
        System.out.println("--- Question 9 (Thêm Account vào Group) ---");

        System.out.println("Danh sách Username hiện có:");
        for (Account acc : accounts) {
            System.out.println("- " + acc.getUsername());
        }

        System.out.print("Mời bạn nhập vào username của account: ");
        String username = scanner.next();

        Account selectedAcc = null;
        for (Account acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(username)) {
                selectedAcc = acc;
                break;
            }
        }

        System.out.println("\nDanh sách Group hiện có:");
        for (Group group : groups) {
            System.out.println("- " + group.getName());
        }

        scanner.nextLine();
        System.out.print("Mời bạn nhập vào tên của group: ");
        String groupName = scanner.nextLine();

        Group selectedGroup = null;
        for (Group group : groups) {
            if (group.getName().equalsIgnoreCase(groupName)) {
                selectedGroup = group;
                break;
            }
        }

        if (selectedAcc != null && selectedGroup != null) {
            GroupAccount ga = new GroupAccount(selectedGroup, selectedAcc, LocalDate.now());
            System.out.printf("Đã thêm account '%s' vào group '%s' thành công!%n%n",
                    selectedAcc.getUsername(), selectedGroup.getName());
        } else {
            System.out.println("Thông tin username hoặc tên group không chính xác!\n");
        }
    }

    public static void question10(Account[] accounts, Group[] groups) {
        while (true) {
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("3. Thêm Group vào Account");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    question5();
                    break;
                case 2:
                    question6();
                    break;
                case 3:
                    question9(accounts, groups);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại!\n");
                    continue;
            }

            System.out.print("Bạn có muốn thực hiện chức năng khác không? (Có/Không): ");
            String confirm = scanner.next();
            if (confirm.equalsIgnoreCase("Không") || confirm.equalsIgnoreCase("K")) {
                System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                return;
            }
        }
    }

    public static void question11(Account[] accounts, Group[] groups) {
        while (true) {
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo Account");
            System.out.println("2. Tạo Department");
            System.out.println("3. Thêm Group vào Account");
            System.out.println("4. Thêm Account vào 1 nhóm ngẫu nhiên");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    question5();
                    break;
                case 2:
                    question6();
                    break;
                case 3:
                    question9(accounts, groups);
                    break;
                case 4:
                    // Thêm ngẫu nhiên
                    System.out.println("Danh sách Username hiện có:");
                    for (Account acc : accounts) {
                        System.out.println("- " + acc.getUsername());
                    }

                    System.out.print("Mời bạn nhập vào username của account: ");
                    String username = scanner.next();

                    Account selectedAcc = null;
                    for (Account acc : accounts) {
                        if (acc.getUsername().equalsIgnoreCase(username)) {
                            selectedAcc = acc;
                            break;
                        }
                    }

                    if (selectedAcc != null) {
                        Random random = new Random();
                        int randomGroupIndex = random.nextInt(groups.length);
                        Group randomGroup = groups[randomGroupIndex];

                        GroupAccount ga = new GroupAccount(randomGroup, selectedAcc, LocalDate.now());
                        System.out.printf("Đã thêm account '%s' vào group ngẫu nhiên '%s' thành công!%n%n",
                                selectedAcc.getUsername(), randomGroup.getName());
                    } else {
                        System.out.println("Username không tồn tại!\n");
                    }
                    break;
                default:
                    System.out.println("Mời bạn nhập lại!\n");
                    continue;
            }

            System.out.print("Bạn có muốn thực hiện chức năng khác không? (Có/Không): ");
            String confirm = scanner.next();
            if (confirm.equalsIgnoreCase("Không") || confirm.equalsIgnoreCase("K")) {
                System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                return;
            }
        }
    }
}