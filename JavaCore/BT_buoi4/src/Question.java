import java.time.LocalDate;

public class Question {
    private int id;
    private String content;
    private CategoryQuestion category; // Foreign Key -> Object
    private TypeQuestion type;         // Foreign Key -> Object
    private Account creator;           // Foreign Key -> Object
    private LocalDate createDate;

    public Question() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public CategoryQuestion getCategory() { return category; }
    public void setCategory(CategoryQuestion category) { this.category = category; }
    public TypeQuestion getType() { return type; }
    public void setType(TypeQuestion type) { this.type = type; }
    public Account getCreator() { return creator; }
    public void setCreator(Account creator) { this.creator = creator; }
    public LocalDate getCreateDate() { return createDate; }
    public void setCreateDate(LocalDate createDate) { this.createDate = createDate; }
}