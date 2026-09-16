public class Answer {
    private int id;
    private String content;
    private Question question; // Foreign Key -> Object
    private boolean isCorrect;

    public Answer() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
    public boolean isCorrect() { return isCorrect; }
    public void setCorrect(boolean isCorrect) { this.isCorrect = isCorrect; }
}