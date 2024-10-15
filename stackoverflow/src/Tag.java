import java.util.ArrayList;

public class Tag {
    String title;
    ArrayList<Question> questions;

    public Tag(String title){
        this.title = title;
        ArrayList<Question> questions = new ArrayList<Question>();
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }
}
