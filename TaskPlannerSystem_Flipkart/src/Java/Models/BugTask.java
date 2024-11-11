package Java.Models;

import Java.Models.Status.IStatus;
import Java.Models.Status.Status;

import java.time.LocalDate;

public class BugTask extends Task {

    BugSeverity severity;

    public BugTask(Integer id, String title, User creator, User asignee, IStatus status, TaskType type, LocalDate dueDate, BugSeverity severity) {
        super(id, title, creator, asignee, status, type, dueDate);
        this.severity = severity;
    }

    public BugSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(BugSeverity severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "BugTask{" +
                "severity=" + severity +
                ", Id=" + Id +
                ", title='" + title + '\'' +
                ", creator=" + creator.getName() +
                ", asignee=" + asignee.getName() +
                ", status=" + status.getCurrentStatus() +
                ", type=" + type +
                ", dueDate=" + dueDate +
                '}';
    }

}
