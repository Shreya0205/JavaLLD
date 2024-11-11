import Java.exceptions.AccessDeniedException;
import Java.models.Question;
import Java.models.User;
import Java.services.AnswerService;
import Java.services.QuestionService;
import Java.services.TopicService;
import Java.services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // https://leetcode.com/discuss/interview-question/5434614/Flipkart-or-SDE-2-or-Machine-Coding-Round

        TopicService topicService = TopicService.getInstance();
        AnswerService answerService = AnswerService.getInstance();

        QuestionService questionService = QuestionService.getInstance(answerService);
        UserService userService = UserService.getInstance(topicService, questionService);

        User user = userService.createUser("shreya", "engineer");
        userService.login(user);

        Question question = userService.askQuestion("where is machine coding", "lld");
        Question question1 = userService.askQuestion("where is machine coding round for flipkart", "lld");

        try {
            userService.addAnswer(question1.getId(), "google meet");
        }
        catch(AccessDeniedException e){
            System.out.println(e.getMessage());
        }

        userService.subscribeTopic("lld");

        userService.addAnswer(question1.getId(), "google meet");
        userService.filterFeed("lld");


    }
}