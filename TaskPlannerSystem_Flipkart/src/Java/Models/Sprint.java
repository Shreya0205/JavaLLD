package Java.Models;

import java.util.ArrayList;

public class Sprint {
    Integer id;
    ArrayList<Task> tasks;

    public Sprint(Integer id) {
        this.id = id;
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTasks(Task task) {
        this.tasks.add(task);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void removeTask(Task task) {
        this.tasks.add(task);
    }
}

