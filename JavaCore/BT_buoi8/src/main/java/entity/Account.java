package entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private int id;
    private String email;
    private String username;
    private String fullName;
    private Department department; // Foreign Key -> Object
    private Position position;     // Foreign Key -> Object
    private LocalDate createDate;
}
