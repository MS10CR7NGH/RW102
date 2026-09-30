package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Bao extends TaiLieu {
    private LocalDate ngayPhatHanh;

    public Bao(int id, String tenNXB, int soBanPhatHanh, LocalDate ngayPhatHanh) {
        super(id, tenNXB, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }
}
