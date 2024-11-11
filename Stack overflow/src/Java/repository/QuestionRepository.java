package Java.repository;

import Java.models.Question;
import Java.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class QuestionRepository {
    private final HashMap<Integer, Question> questions = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Question save(Question question) {
        if (question.getId() == null) {
            question.setId(idCounter.getAndIncrement());
        }
        questions.put(question.getId(), question);
        return question;
    }

    public Question findById(Integer id) {
        return questions.get(id);
    }

    public Collection<Question> findAll() {
        return questions.values();
    }

    public void deleteById(Integer id) {
        questions.remove(id);
    }

    public boolean existsById(Integer id) {
        return questions.containsKey(id);
    }
}
