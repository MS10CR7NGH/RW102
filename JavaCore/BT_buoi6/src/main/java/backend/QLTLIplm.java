package backend;

import entity.TaiLieu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLTLIplm implements IQLTL {
    private List<TaiLieu> taiLieuList;
    private Scanner sc = new Scanner(System.in);

    public QLTLIplm() {
        taiLieuList = new ArrayList<>();
        taiLieuList.add(new TaiLieu(1, "NXB A", 100));
        taiLieuList.add(new TaiLieu(2, "NXB B", 200));
        taiLieuList.add(new TaiLieu(3, "NXB C", 300));
        taiLieuList.add(new TaiLieu(4, "NXB D", 400));
        taiLieuList.add(new TaiLieu(5, "NXB E", 500));
        taiLieuList.add(new TaiLieu(6, "NXB F", 600));
        taiLieuList.add(new TaiLieu(7, "NXB G", 700));
    }

    @Override
    public void themTaiLieu() {
        System.out.print("Nhập tên NXB: ");
        String tenNXB = sc.nextLine();
        System.out.print("Nhập số bản phát hành: ");
        int soBanPhatHanh = Integer.parseInt(sc.nextLine());
        if (tenNXB.isBlank() || soBanPhatHanh <= 0) {
            System.out.println("Dữ liệu không hợp lệ.");
            return;
        }
        taiLieuList.add(new TaiLieu(taiLieuList.size() + 1, tenNXB, soBanPhatHanh));
        System.out.println("Thêm tài liệu thành công.");
    }

    @Override
    public void xoaTaiLieu() {
        System.out.print("Nhập ID tài liệu cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        taiLieuList.removeIf(tl -> tl.getId() == id);
        System.out.println("Xóa tài liệu thành công.");
    }

    @Override
    public void hienThiTaiLieu() {
        System.out.println("===== Danh sách tài liệu =====");
        System.out.println("+-----+-------------------------+-------------------------+");
        System.out.printf("| %-5s | %-25s | %-25s |\n",  "ID", "Tên NXB", "Số bản phát hành");
        System.out.println("+-----+-------------------------+-------------------------+");
        for (TaiLieu tl : taiLieuList) {
            System.out.printf("| %-5s | %-25s | %-25s |\n", tl.getId(), tl.getTenNXB(), tl.getSoBanPhatHanh());
        }
        System.out.println("+-----+-------------------------+-------------------------+");
    }

    @Override
    public void timKiemTaiLieuTheoTen() {
        System.out.print("Nhập tên tài liệu cần tìm: ");
        String ten = sc.nextLine();
        System.out.println("+-----+-------------------------+-------------------------+");
        System.out.printf("| %-5s | %-25s | %-25s |\n",  "ID", "Tên NXB", "Số bản phát hành");
        System.out.println("+-----+-------------------------+-------------------------+");
        for (TaiLieu tl : taiLieuList) {
            if (tl.getTenNXB().toLowerCase().contains(ten.toLowerCase())) {
                System.out.printf("| %-5s | %-25s | %-25s |\n", tl.getId(), tl.getTenNXB(), tl.getSoBanPhatHanh());
            }
        }
        System.out.println("+-----+-------------------------+-------------------------+");
    }
}
