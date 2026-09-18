public class Exercise6 {

    public static void question1() {
        System.out.println("--- Question 1 ---");
        System.out.print("Các số chẵn nguyên dương nhỏ hơn 10 là: ");
        for (int i = 2; i < 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public static void question2(Account[] accounts) {
        System.out.println("--- Question 2 ---");
        System.out.println("Danh sách thông tin Account:");
        for (Account acc : accounts) {
            String deptName = (acc.getDepartment() != null) ? acc.getDepartment().getName() : "N/A";
            String posName = (acc.getPosition() != null) ? acc.getPosition().getName().getValue() : "N/A";

            System.out.printf("ID: %d | Email: %s | FullName: %s | Dept: %s | Pos: %s%n",
                    acc.getId(), acc.getEmail(), acc.getFullName(), deptName, posName);
        }
        System.out.println();
    }

    public static void question3() {
        System.out.println("--- Question 3 ---");
        System.out.print("Các số nguyên dương nhỏ hơn 10 là: ");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}