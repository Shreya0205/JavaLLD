package Java.repository;

import Java.models.Answer;
import Java.models.Question;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AnswerRepository {
    private final HashMap<Integer, Answer> answers = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Answer save(Answer answer) {
        if (answer.getId() == null) {
            answer.setId(idCounter.getAndIncrement());
        }
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Answer findById(Integer id) {
        return answers.get(id);
    }

    public Collection<Answer> findAll() {
        return answers.values();
    }

    public void deleteById(Integer id) {
        answers.remove(id);
    }

    public boolean existsById(Integer id) {
        return answers.containsKey(id);
    }
}
