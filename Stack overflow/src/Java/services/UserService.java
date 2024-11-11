package Java.services;

import Java.exceptions.AccessDeniedException;
import Java.exceptions.ResourceNotFoundException;
import Java.models.*;
import Java.repository.UserRepository;

import java.util.ArrayList;

public class UserService {
    private static UserService userService = null;
    private UserRepository userRepository;
    private User loggedInUser;
    private TopicService topicService;
    private QuestionService questionService;

    public UserService(TopicService topicService, QuestionService questionService){
        userRepository = new UserRepository();
        this.topicService = topicService;
        this.questionService = questionService;
        this.loggedInUser = null;
    }

    public static UserService getInstance(TopicService topicService, QuestionService questionService){
        if( userService == null){
            userService = new UserService(topicService, questionService);
        }
        return userService;
    }

    public User createUser(String name, String profession){
        User user = new User(null, name, profession);
        userRepository.save(user);
        return user;
    }

    public User findUser(Integer Id){
        User user = userRepository.findById(Id);
        if (user == null) throw new ResourceNotFoundException("List not found with id: " + Id);
        return user;
    }

    public void login(User user){

        if(this.loggedInUser!=null)
            System.out.println("user is logged in");

        this.loggedInUser = user;
    }

    public void logout(){

        if(this.loggedInUser == null)
            System.out.println("No user is logged in");

        this.loggedInUser = null;
    }

    public void subscribeTopic(String name){

        if(this.loggedInUser == null)
            System.out.println("No user is logged in");

        Topic topic = topicService.findTopic(name);
        if(topic==null){
            topic = topicService.createTopic(name);
        }

        topic.addSubscriber(this.loggedInUser);
    }

    public void unSubscribeTopic(String name){

        if(this.loggedInUser == null)
            System.out.println("No user is logged in");

        Topic topic = topicService.findTopic(name);
        if(topic==null){
            throw new ResourceNotFoundException("topic does not exist");
        }

        if(!topic.isUserSubscribed(this.loggedInUser))
            throw new IllegalArgumentException("User not subscribed");

        topic.removeSubscriber(this.loggedInUser);
    }

    public void filterFeed(String name){

        if(this.loggedInUser == null)
            System.out.println("No user is logged in");

        Topic topic = topicService.findTopic(name);
        if(topic==null){
            throw new ResourceNotFoundException("topic does not exist");
        }

//        if(!topic.isUserSubscribed(this.loggedInUser))
//            throw new IllegalArgumentException("User not subscribed");

        questionService.filterFeedWithtopic(topic);
    }

    public void viewQuestion(Integer id){
        Question question = questionService.findQuestion(id);
        if(question == null){
            throw new ResourceNotFoundException("question not exist");
        }
        question.toString();
    }

    public Question askQuestion(String summary, String topicName){

        if(this.loggedInUser == null)
            System.out.println("No user is logged in");

        Topic topic = topicService.findTopic(topicName);
        if(topic==null){
            topic = topicService.createTopic(topicName);
        }

        Question question = questionService.createQuestion(this.loggedInUser, summary, topic);
        return question;
    }

    public void addAnswer(Integer questionID, String answerSummary){
        if(this.loggedInUser == null)
            System.out.println("No user is logged in");

        Question question = questionService.findQuestion(questionID);
        if(question == null){
            throw new ResourceNotFoundException("question not exist");
        }

        if(! questionService.isUserCanAnswerQuestion(questionID, this.loggedInUser))
            throw new AccessDeniedException("Not subscribed to topic");

        questionService.addAnswer(questionID, answerSummary);
    }


}
