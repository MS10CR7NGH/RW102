public class ExamQuestion {
    private Exam exam;         // Foreign Key (ExamID) -> Object Exam
    private Question question; // Foreign Key (QuestionID) -> Object Question

    public ExamQuestion() {}

    public ExamQuestion(Exam exam, Question question) {
        this.exam = exam;
        this.question = question;
    }

    public Exam getExam() { return exam; }
    public void setExam(Exam exam) { this.exam = exam; }
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}