package frontend;

import backend.QuanLyUserIplm;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        QuanLyUserIplm quanLyUser = new QuanLyUserIplm();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== Mời bạn chọn chức năng ====");
            System.out.println("1. Hiển thị danh sách user.");
            System.out.println("2. Tìm kiếm user theo username.");
            System.out.println("3. Hiển thị danh sách Department.");
            System.out.println("4. Tìm kiếm Department theo tên.");
            System.out.println("5. Thoát khỏi chương trình.");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    quanLyUser.hienThiDanhSachUser();
                    break;
                case "2":
                    quanLyUser.timKiemUserTheoUsername();
                    break;
                case "3":
                    quanLyUser.hienThiDepartment();
                    break;
                case "4":
                    quanLyUser.timKiemDepartmentTheoTen();
                    break;
                case "5":
                    System.out.println("Thoát.");
                    System.exit(0);
                default:
                    System.out.println("Chọn sai, Chọn lại!");
            }
        }
    }
}
