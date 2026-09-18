import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Exercise3 {

    public static void question1(Exam exam) {
        System.out.println("--- Question 1 ---");
        System.out.println("ID: " + exam.getId());
        System.out.println("Code: " + exam.getCode());
        System.out.println("Title: " + exam.getTitle());
        System.out.println("Duration: " + exam.getDuration() + " phút");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Ngày' dd 'tháng' MM 'năm' yyyy", new Locale("vi", "VN"));
        String formattedDate = exam.getCreateDate().format(formatter);
        System.out.println("Create Date (Vietnamese): " + formattedDate + "\n");
    }

    public static void question2(Exam exam) {
        System.out.println("--- Question 2 ---");
        LocalDateTime createDateTime = exam.getCreateDate().atStartOfDay();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy – MM – dd – HH – mm – ss");

        System.out.println("Exam ID: " + exam.getId() + " | Title: " + exam.getTitle());
        System.out.println("Thời gian tạo: " + createDateTime.format(formatter) + "\n");
    }

    public static void question3(Exam exam) {
        System.out.println("--- Question 3 ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        System.out.println("Năm tạo Exam: " + exam.getCreateDate().format(formatter) + "\n");
    }

    public static void question4(Exam exam) {
        System.out.println("--- Question 4 ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        System.out.println("Tháng và Năm tạo Exam: " + exam.getCreateDate().format(formatter) + "\n");
    }

    public static void question5(Exam exam) {
        System.out.println("--- Question 5 ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        System.out.println("MM-DD tạo Exam: " + exam.getCreateDate().format(formatter) + "\n");
    }
}