package frontend;

import backend.IQLTL;
import backend.QLTLIplm;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        IQLTL quanLyTaiLieu = new QLTLIplm();
        while (true) {
            System.out.println("===== Quản lý tài liệu =====");
            System.out.println("1. Thêm tài liệu");
            System.out.println("2. Xóa tài liệu");
            System.out.println("3. Hiển thị tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo tên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    quanLyTaiLieu.themTaiLieu();
                    break;
                case "2":
                    quanLyTaiLieu.xoaTaiLieu();
                    break;
                case "3":
                    quanLyTaiLieu.hienThiTaiLieu();
                    break;
                case "4":
                    quanLyTaiLieu.timKiemTaiLieuTheoTen();
                    break;
                case "5":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }


    }
}
