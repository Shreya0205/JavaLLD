package Java.Models;

import Java.Models.Status.IStatus;

public class SubTrack {
    Integer id;
    String title;
    IStatus status;

    public SubTrack(String title, IStatus status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public IStatus getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SubTrack{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
