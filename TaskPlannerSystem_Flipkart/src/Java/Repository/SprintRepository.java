package Java.Repository;

import Java.Models.Sprint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SprintRepository {
    private final HashMap<Integer, Sprint> sprints = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Sprint save(Sprint sprint) {
        if (sprint.getId() == null) {
            sprint.setId(idCounter.getAndIncrement());
        }
        sprints.put(sprint.getId(), sprint);
        return sprint;
    }

    public Sprint findById(Integer id) {
        return sprints.get(id);
    }

    public Collection<Sprint> findAll() {
        return sprints.values();
    }

    public void deleteById(Integer id) {
        sprints.remove(id);
    }

    public boolean existsById(Integer id) {
        return sprints.containsKey(id);
    }
}
