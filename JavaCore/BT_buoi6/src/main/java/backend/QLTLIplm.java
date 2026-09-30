package backend;

import entity.Sach;
import entity.TaiLieu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        System.out.println("Nhập số loai tai lieu: 1=Sách, 2=Tạp chí, 3=Báo");
        int loaiTaiLieuInt = sc.nextInt();
        sc.nextLine();
        switch (loaiTaiLieuInt) {
            case 1:
                System.out.print("Nhập tên tác giả: ");
                String tenTacGia = sc.nextLine();
                System.out.print("Nhập số trang: ");
                int soTrang = sc.nextInt();
                sc.nextLine();
                TaiLieu sach = new Sach(taiLieuList.size() + 1, tenNXB, soBanPhatHanh, tenTacGia, soTrang);
                taiLieuList.add(sach);
                System.out.println("Thêm sách thành công.");
                break;
            case 2:
                System.out.println("Nhập số phát hành: ");
                int soPhatHanh = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập tháng phát hành: ");
                int thangPhatHanh = sc.nextInt();
                sc.nextLine();
                TaiLieu tapChi = new entity.TapChi(taiLieuList.size() +1, tenNXB, soBanPhatHanh, soPhatHanh, thangPhatHanh);
                taiLieuList.add(tapChi);
                break;
            case 3:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ngayPhatHanh = null;
                while (ngayPhatHanh == null) {
                    System.out.print("Nhập ngày phát hành (dd/MM/yyyy): ");
                    String ngayPhatHanhStr = sc.nextLine().trim();
                    try {
                        ngayPhatHanh = LocalDate.parse(ngayPhatHanhStr, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("⚠️️ Định dạng ngày không hợp lệ! Vui lòng nhập lại (ví dụ: 30/09/2026).");
                    }
                }
                TaiLieu bao = new entity.Bao(taiLieuList.size() +1, tenNXB, soBanPhatHanh, ngayPhatHanh);
                taiLieuList.add(bao);
                System.out.println("Thêm báo thành công.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Thêm tài liệu thất bại.");
                return;
        }

    }

    @Override
    public void xoaTaiLieu() {
        System.out.print("Nhập tên tài liệu cần xóa: ");
        String ten = sc.nextLine();
        List<TaiLieu> toRemoves = new ArrayList<>();
        for (TaiLieu tl : taiLieuList) {
            if (tl.getTenNXB().toLowerCase().equals(ten.toLowerCase())) {
                toRemoves.add(tl);
            }
        }
        if (toRemoves.isEmpty()) {
            System.out.println("Không tìm thấy tài liệu cần xóa.");
        } else {
            taiLieuList.removeAll(toRemoves);
            System.out.println("Xóa tài liệu thành công.");
        }
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
