import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Exercise2 {


    public static void question1() {
        System.out.println("--- Question 1 ---");
        int number = 5;
        System.out.printf("Số nguyên: %d%n%n", number);
    }

    public static void question2() {
        System.out.println("--- Question 2 ---");
        int number = 100000000;
        System.out.printf(Locale.US, "Số nguyên định dạng: %,d%n%n", number);
    }

    public static void question3() {
        System.out.println("--- Question 3 ---");
        float number = 5.567098f;
        System.out.printf(Locale.US, "Số thực (4 chữ số thập phân): %.4f%n%n", number);
    }

    public static void question4() {
        System.out.println("--- Question 4 ---");
        String fullName = "Nguyễn Văn A";
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.%n%n", fullName);
    }

    public static void question5() {
        System.out.println("--- Question 5 ---");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");
        System.out.printf("Thời gian hiện tại: %s%n%n", now.format(formatter));
    }

    public static void question6(Account acc1, Account acc2, Account acc3) {
        System.out.println("--- Question 6 ---");
        System.out.printf("%-25s | %-20s | %-15s%n", "Email", "Full Name", "Department Name");
        System.out.println("------------------------------------------------------------------");

        String dept1 = (acc1.getDepartment() != null) ? acc1.getDepartment().getName() : "N/A";
        System.out.printf("%-25s | %-20s | %-15s%n", acc1.getEmail(), acc1.getFullName(), dept1);

        String dept2 = (acc2.getDepartment() != null) ? acc2.getDepartment().getName() : "N/A";
        System.out.printf("%-25s | %-20s | %-15s%n", acc2.getEmail(), acc2.getFullName(), dept2);

        String dept3 = (acc3.getDepartment() != null) ? acc3.getDepartment().getName() : "N/A";
        System.out.printf("%-25s | %-20s | %-15s%n", acc3.getEmail(), acc3.getFullName(), dept3);

        System.out.println();
    }
}