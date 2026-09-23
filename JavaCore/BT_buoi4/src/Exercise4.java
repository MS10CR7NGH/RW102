import java.util.Scanner;

public class Exercise4 {

    private static Scanner scanner = new Scanner(System.in);


    public static void question1() {
        System.out.println("--- Question 1 ---");
        System.out.print("Nhập vào một chuỗi: ");
        String s = scanner.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Số lượng từ: 0");
            return;
        }

        // Tách chuỗi theo một hoặc nhiều khoảng trắng liên tiếp
        String[] words = s.split("\\s+");
        System.out.println("Số lượng từ trong xâu: " + words.length);
    }

    public static void question2() {
        System.out.println("--- Question 2 ---");
        System.out.print("Nhập xâu s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Nhập xâu s2: ");
        String s2 = scanner.nextLine();

        String result = s1.concat(s2);
        System.out.println("Xâu sau khi nối: " + result);
    }

    public static void question3() {
        System.out.println("--- Question 3 ---");
        System.out.print("Nhập vào tên: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Tên rỗng!");
            return;
        }

        String[] words = name.split("\\s+");
        String formattedName = "";
        for(String word : words){
            String firstLetter = word.substring(0, 1).toUpperCase();
            String otherLetters = word.substring(1).toLowerCase();
            formattedName += firstLetter + otherLetters + " ";
        }
        formattedName = formattedName.trim();

        System.out.println("Tên sau khi chuẩn hóa chữ cái đầu: " + formattedName);
    }


    public static void question4() {
        System.out.println("--- Question 4 ---");
        System.out.print("Nhập vào tên: ");
        String name = scanner.nextLine();

        for (int i = 0; i < name.length(); i++) {
            char c = Character.toUpperCase(name.charAt(i));
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + c);
        }
    }


    public static void question5() {
        System.out.println("--- Question 5 ---");
        System.out.print("Nhập vào họ: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Nhập vào tên: ");
        String lastName = scanner.nextLine().trim();

        String fullName = firstName + " " + lastName;
        System.out.println("Họ và tên đầy đủ: " + fullName);
    }

    public static void question6() {
        System.out.println("--- Question 6 ---");
        System.out.print("Nhập vào họ và tên đầy đủ: ");
        String fullName = scanner.nextLine().trim();

        String[] words = fullName.split("\\s+");

        if (words.length == 1) {
            System.out.println("Tên là: " + words[0]);
        } else if (words.length == 2) {
            System.out.println("Họ là: " + words[0]);
            System.out.println("Tên là: " + words[1]);
        } else if (words.length >= 3) {
            System.out.println("Họ là: " + words[0]);

            StringBuilder middleName = new StringBuilder();
            for (int i = 1; i < words.length - 1; i++) {
                middleName.append(words[i]).append(" ");
            }
            System.out.println("Tên đệm là: " + middleName.toString().trim());
            System.out.println("Tên là: " + words[words.length - 1]);
        }
    }

    public static void question7() {
        System.out.println("--- Question 7 ---");
        System.out.print("Nhập vào họ và tên: ");
        String input = scanner.nextLine();

        String trimmed = input.trim().replaceAll("\\s+", " ");
        System.out.println("a) Sau khi xóa khoảng trắng thừa: " + trimmed);

        String[] words = trimmed.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstChar = word.substring(0, 1).toUpperCase();
                String restChars = word.substring(1).toLowerCase();
                sb.append(firstChar).append(restChars).append(" ");
            }
        }

        String result = sb.toString().trim();
        System.out.println("b) Sau khi viết hoa từng từ: " + result);
    }


    public static void question8( Group[] groups) {
        System.out.println("--- Question 8 ---");

        if (groups == null) {
            System.out.println("Danh sách group trống!");
            return;
        }

        System.out.println("Các group có chứa chữ 'Java':");
        for (Group name : groups) {
            if (name.getName().toLowerCase().contains("java")) {
                System.out.println("- " + name.getName());
            }
        }
    }


    public static void question9(Group[] groups) {
        System.out.println("--- Question 8 ---");

        if (groups == null) {
            System.out.println("Danh sách group trống!");
            return;
        }

        System.out.println("Các group có chứa chữ 'Java':");
        for (Group name : groups) {
            if (name.getName().equals("java")) {
                System.out.println("- " + name.getName());
            }
        }
    }

    public static void question10() {
        System.out.println("--- Question 10 ---");
        System.out.print("Nhập chuỗi thứ 1: ");
        String s1 = scanner.nextLine();
        System.out.print("Nhập chuỗi thứ 2: ");
        String s2 = scanner.nextLine();

        // Đảo ngược s1 để so sánh với s2
        String reversedS1 = new StringBuilder(s1).reverse().toString();

        if (reversedS1.equals(s2)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }
    }


    public static void question11() {
        System.out.println("--- Question 11 ---");
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();

        if (str == null || str.isEmpty()) {
            System.out.println("Chuỗi rỗng hoặc không hợp lệ!");
            return;
        }
        int count = str.length() - str.replace("a", "").length();

        System.out.println("Số lần xuất hiện ký tự 'a': " + count);
    }


    public static void question12() {
        System.out.println("--- Question 12 ---");
        System.out.print("Nhập vào chuỗi cần đảo ngược: ");
        String str = scanner.nextLine();

        if (str == null || str.isEmpty()) {
            System.out.println("Chuỗi rỗng hoặc không hợp lệ!");
            return;
        }
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("Chuỗi sau khi đảo ngược: " + reversed);
    }


    public static void question13() {
        System.out.println("--- Question 13 ---");
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();
        System.out.println(isNotContainDigit(str));
    }

    private static boolean isNotContainDigit(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void question14() {
        System.out.println("--- Question 14 ---");
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();
        System.out.println("Chuỗi gốc: " + str);

        String result = str.replace('e', '*');
        System.out.println("Chuỗi sau khi thay 'e' bằng '*': " + result);
    }

    public static void question15() {
        System.out.println("--- Question 15 ---");
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();

        if (str == null || str.trim().isEmpty()) {
            System.out.println("Kết quả: \"\"");
            return;
        }
        System.out.println("Chuỗi ban đầu: \"" + str + "\"");

        String[] words = str.trim().split("\\s+");

        StringBuilder reversedStr = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedStr.append(words[i]);
            if (i > 0) {
                reversedStr.append(" ");
            }
        }

        System.out.println("Kết quả: \"" + reversedStr.toString() + "\"");
    }

    public static void question16() {
        System.out.println("--- Question 16 ---");
        System.out.print("Nhập chuỗi str: ");
        String str = scanner.nextLine();
        System.out.print("Nhập n: ");
        int n = scanner.nextInt();

        if (n <= 0 || str.length() % n != 0) {
            System.out.println("KO");
        } else {
            System.out.println("Các phần bằng nhau có độ dài " + n + ":");
            for (int i = 0; i < str.length(); i += n) {
                System.out.println(str.substring(i, i + n));
            }
        }
    }
}