public class Answer {
    public User User;
    Integer votes;
    Question question;
    String content;

    public Answer(User user, Question question, String content){
        this.User = user;
        this.question = question;
        this.content = content;
        this.votes = 0;
    }
}
