package Java.Repository;

import Java.Models.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRepository {
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(idCounter.getAndIncrement());
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public Task findById(Integer id) {
        return tasks.get(id);
    }

    public Collection<Task> findAll() {
        return tasks.values();
    }

    public void deleteById(Integer id) {
        tasks.remove(id);
    }

    public boolean existsById(Integer id) {
        return tasks.containsKey(id);
    }
}
