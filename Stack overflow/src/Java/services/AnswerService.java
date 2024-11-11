package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.Answer;
import Java.models.Question;
import Java.models.User;
import Java.repository.AnswerRepository;
import Java.repository.QuestionRepository;

public class AnswerService {
    private static AnswerService answerService = null;
    private final AnswerRepository answerRepository;

    public AnswerService(){
        answerRepository = new AnswerRepository();
    }

    public static AnswerService getInstance(){
        if( answerService == null){
            answerService = new AnswerService();
        }
        return answerService;
    }

    public Answer createAnswer(String summary){
        Answer answer = new Answer(null, summary);
        answerRepository.save(answer);
        return answer;
    }

    public Answer findAnswer(Integer Id){
        Answer answer = answerRepository.findById(Id);
        if (answer == null) throw new ResourceNotFoundException("List not found with id: " + Id);
        return answer;
    }
}
