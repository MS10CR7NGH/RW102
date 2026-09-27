package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sach extends TaiLieu{
    private String tenTacGia;
    private int soTrang;

    public Sach(int id, String tenNXB, int soBanPhatHanh, String tenTacGia, int soTrang) {
        super(id, tenNXB, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }
}
