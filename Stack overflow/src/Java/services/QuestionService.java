package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.Answer;
import Java.models.Question;
import Java.models.Topic;
import Java.models.User;
import Java.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;

public class QuestionService {
    private static QuestionService questionService = null;
    private QuestionRepository questionRepository;
    private AnswerService answerService;

    public QuestionService(AnswerService answerService){
        questionRepository = new QuestionRepository();
        this.answerService = answerService;
    }

    public static QuestionService getInstance(AnswerService answerService){
        if( questionService == null){
            questionService = new QuestionService(answerService);
        }
        return questionService;
    }

    public Question createQuestion(User user, String summary, Topic topic){
        Question question = new Question(null, user, summary, topic);
        questionRepository.save(question);
        return question;
    }

    public Question findQuestion(Integer Id){
        Question question = questionRepository.findById(Id);
        if (question == null) throw new ResourceNotFoundException("List not found with id: " + Id);
        return question;
    }

    public ArrayList<Question> getQuestionsWithTopic(Topic topic){

        Collection<Question> questions = questionRepository.findAll();
        ArrayList<Question> topicQuestions = new ArrayList<>();

        for(Question question: questions){
            if( question.isAddedToTopic(topic)){
                topicQuestions.add(question);
            }
        }
        return topicQuestions;
    }

    public void filterFeedWithtopic(Topic topic){
        ArrayList<Question> questions = getQuestionsWithTopic(topic);
        for(Question question: questions)
            question.toString();
    }

    public boolean isUserCanAnswerQuestion(Integer questionID, User user){
        Question question = findQuestion(questionID);
        ArrayList<Topic> topics = question.getTopics();
        Boolean isSubscribed = false;

        for(Topic topic: topics){
            if(topic.isUserSubscribed(user)) {
                return true;
            }
        }
        return false;
    }

    public void addAnswer(Integer questionID, String summary){
        Question question = findQuestion(questionID);
        Answer answer = answerService.createAnswer(summary);
        question.addAnswers(answer);
    }

}
