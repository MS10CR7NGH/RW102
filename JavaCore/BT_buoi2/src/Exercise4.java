import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {


    public static void question1() {
        System.out.println("--- Question 1 ---");
        Random random = new Random();
        int randomNumber = random.nextInt();
        System.out.println("Số nguyên ngẫu nhiên: " + randomNumber + "\n");
    }


    public static void question2() {
        System.out.println("--- Question 2 ---");
        Random random = new Random();
        float randomFloat = random.nextFloat();
        System.out.println("Số thực ngẫu nhiên (0.0 đến 1.0): " + randomFloat + "\n");
    }


    public static void question3() {
        System.out.println("--- Question 3 ---");
        String[] names = { "Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C", "Nguyễn Văn D", "Nguyễn Văn E" };
        Random random = new Random();
        int index = random.nextInt(names.length);
        System.out.println("Tên bạn học ngẫu nhiên: " + names[index] + "\n");
    }


    public static void question4() {
        System.out.println("--- Question 4 ---");
        int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
        int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();

        Random random = new Random();
        long randomDay = minDay + random.nextInt(maxDay - minDay + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        System.out.println("Ngày ngẫu nhiên (24/07/1995 - 20/12/1995): " + randomDate + "\n");
    }


    public static void question5() {
        System.out.println("--- Question 5 ---");
        LocalDate now = LocalDate.now();
        int nowDay = (int) now.toEpochDay();
        int minDay = nowDay - 365;

        Random random = new Random();
        long randomDay = minDay + random.nextInt(nowDay - minDay + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        System.out.println("Ngày ngẫu nhiên trong 1 năm trở lại đây: " + randomDate + "\n");
    }


    public static void question6() {
        System.out.println("--- Question 6 ---");
        LocalDate now = LocalDate.now();
        int maxDay = (int) now.toEpochDay();

        Random random = new Random();
        long randomDay = random.nextInt(maxDay + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        System.out.println("Ngày ngẫu nhiên trong quá khứ: " + randomDate + "\n");
    }

    public static void question7() {
        System.out.println("--- Question 7 ---");
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100; // 100 + [0..899]
        System.out.println("Số ngẫu nhiên có 3 chữ số: " + randomNumber + "\n");
    }
}