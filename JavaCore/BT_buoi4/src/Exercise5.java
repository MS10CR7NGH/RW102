import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Exercise5 {


        public static void question5(Department[] departments) {
            System.out.println("--- Question 5 ---");
            Scanner scanner = new Scanner(System.in);

            if (departments == null || departments.length < 2) {
                System.out.println("Mảng phải có ít nhất 2 phòng ban để thực hiện so sánh!");
                return;
            }

            System.out.println("Danh sách các phòng ban:");
            for (int i = 0; i < departments.length; i++) {
                System.out.println((i + 1) + ". " + departments[i].getName());
            }

            int pos1;
            while (true) {
                System.out.print("\nNhập vị trí phòng ban thứ nhất (1 - " + departments.length + "): ");
                pos1 = scanner.nextInt();
                if (pos1 >= 1 && pos1 <= departments.length) {
                    break;
                }
                System.out.println("Vị trí không hợp lệ! Vui lòng nhập lại.");
            }

            int pos2;
            while (true) {
                System.out.print("Nhập vị trí phòng ban thứ hai (1 - " + departments.length + "): ");
                pos2 = scanner.nextInt();
                if (pos2 >= 1 && pos2 <= departments.length) {
                    break;
                }
                System.out.println("Vị trí không hợp lệ! Vui lòng nhập lại.");
            }

            Department dept1 = departments[pos1 - 1];
            Department dept2 = departments[pos2 - 1];

            System.out.println("\nĐang so sánh: '" + dept1.getName() + "' và '" + dept2.getName() + "'");

            if (dept1.getName() != null && dept1.getName().equals(dept2.getName())) {
                System.out.println("-> Kết quả: Hai phòng ban này BẰNG NHAU.");
            } else {
                System.out.println("-> Kết quả: Hai phòng ban này KHÔNG BẰNG NHAU.");
            }
        }

    public static void question6() {
        System.out.println("\n--- Question 6 ---");
        Department[] departments = new Department[5];
        departments[0] = new Department(1, "Marketing");
        departments[1] = new Department(2, "Boss of director");
        departments[2] = new Department(3, "Waiting room");
        departments[3] = new Department(4, "Accounting");
        departments[4] = new Department(5, "Sale");

        Arrays.sort(departments);

        System.out.println("Danh sách phòng ban sau khi sắp xếp (A-Z):");
        for (Department dept : departments) {
            System.out.println(dept.getName());
        }
    }

}