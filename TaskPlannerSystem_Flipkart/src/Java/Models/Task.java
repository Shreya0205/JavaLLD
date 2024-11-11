package Java.Models;

import Java.Models.Status.IStatus;
import Java.Models.Status.Status;

import java.time.LocalDate;

public class Task {
    Integer Id;
    String title;
    User creator;
    User asignee;
    IStatus status;
    TaskType type;
    LocalDate dueDate;

    public Task(Integer id, String title, User creator, User asignee, IStatus status, TaskType type, LocalDate dueDate) {
        Id = id;
        this.title = title;
        this.creator = creator;
        this.asignee = asignee;
        this.status = status;
        this.type = type;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public User getCreator() {
        return creator;
    }

    public User getAsignee() {
        return asignee;
    }

    public IStatus getStatus() {
        return status;
    }

    public TaskType getType() {
        return type;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isTaskOnTrack(){
        if (this.status.getCurrentStatus() != this.status.getFinalStatus() && this.dueDate.isBefore(LocalDate.now()))
            return false;
        return true;
    }

}
