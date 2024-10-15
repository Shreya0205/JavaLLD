import java.util.ArrayList;
import java.util.Map;

public class StackOverflowSystem {
    static Integer TotalQID, TotalAID;
    static Map<Integer, Question> Questions;
    static Map<Integer, Answer> Answers;
    static Map<Integer, User> Users;
    static Map<String, Tag> Tags;

    public void createUser(Integer UserID, String UserName){
        User user = new User(UserID, UserName);
        Users.put(UserID, user);
    }

    public void PostQuestion(User user, String content, ArrayList<String> TagsList){
        Question question = new Question(user, content);

        for(Integer i =0;i<TagsList.size();i++){
            String tag = TagsList.get(i);
            if(!Tags.containsKey(tag)){
                Tags.put(tag, new Tag(tag));
            }
            Tags.get(tag).addQuestion(question);
        }

        Questions.put(TotalQID, question);
    }

    public void PostAnswer(User user, Question question, String content){
        Answer answer = new Answer(user, question, content);
        Answers.put(TotalAID, answer);
    }

    public void UpvoteQuestion(Integer QID){
        Question question = this.Questions.get(QID);
        question.votes = question.votes + 1;
        question.User.addAchievementScore();
    }

    public void UpvoteAnswer(Answer AID){
        Answer answer = this.Answers.get(AID);
        answer.votes = answer.votes + 1;
        answer.User.addAchievementScore();
    }

    public Question getQuestion(Integer QID){
        return Questions.get(QID);
    }

    public Answer getAnswer(Integer AID){
        return Answers.get(AID);
    }

    public void getQuestionByTags(String Tag){
        if ( !Tags.containsKey(Tag) ){
            System.out.println("No Questions for this tag");
        }

    }
}
