import java.time.LocalDate;

public class Exam {
    private int id;
    private String code;
    private String title;
    private CategoryQuestion category; // Foreign Key -> Object
    private int duration;
    private Account creator;           // Foreign Key -> Object
    private LocalDate createDate;

    public Exam() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public CategoryQuestion getCategory() { return category; }
    public void setCategory(CategoryQuestion category) { this.category = category; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public Account getCreator() { return creator; }
    public void setCreator(Account creator) { this.creator = creator; }
    public LocalDate getCreateDate() { return createDate; }
    public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }
}