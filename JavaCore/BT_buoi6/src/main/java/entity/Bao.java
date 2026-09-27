package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao(int id, String tenNXB, int soBanPhatHanh, String ngayPhatHanh) {
        super(id, tenNXB, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }
}
