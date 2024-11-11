package Java.Models;

import Java.Models.Status.IStatus;

import java.time.LocalDate;
import java.util.ArrayList;

public class StoryTask extends Task {
    String summary;
    ArrayList<SubTrack> subtracks;

    public StoryTask(Integer id, String title, User creator, User asignee, IStatus status, TaskType type, LocalDate dueDate, String summary) {
        super(id, title, creator, asignee, status, type, dueDate);
        this.summary = summary;
        this.subtracks = new ArrayList<>();
    }

    public ArrayList<SubTrack> getSubtracks() {
        return subtracks;
    }

    public void setSubtracks(SubTrack subtrack) {
        this.subtracks.add(subtrack);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "StoryTask{" +
                "summary='" + summary + '\'' +
                ", subtracks=" + subtracks +
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
