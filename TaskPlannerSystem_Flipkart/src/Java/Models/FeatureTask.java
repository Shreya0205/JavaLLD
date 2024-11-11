package Java.Models;

import Java.Models.Status.IStatus;
import Java.Models.Status.Status;

import java.time.LocalDate;

public class FeatureTask extends Task {
    String summary;
    FeatureImpact impact;

    public FeatureTask(Integer id, String title, User creator, User asignee, IStatus status, TaskType type, LocalDate dueDate, String summary, FeatureImpact impact) {
        super(id, title, creator, asignee, status, type, dueDate);
        this.summary = summary;
        this.impact = FeatureImpact.low;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setImpact(FeatureImpact impact) {
        this.impact = impact;
    }

    public String getSummary() {
        return summary;
    }

    public FeatureImpact getImpact() {
        return impact;
    }

    public boolean isTaskOnTrack(){
        if (this.status.getCurrentStatus() != this.status.getFinalStatus() && this.dueDate.isBefore(LocalDate.now()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "FeatureTask{" +
                "summary='" + summary + '\'' +
                ", impact=" + impact +
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
