import java.time.LocalDate;

public class Group {
    private int id;
    private String name;
    private Account creator; // Foreign Key -> Object
    private LocalDate createDate;

    public Group() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Account getCreator() { return creator; }
    public void setCreator(Account creator) { this.creator = creator; }
    public LocalDate getCreateDate() { return createDate; }
    public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }
}