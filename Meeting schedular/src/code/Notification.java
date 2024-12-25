package code;

import java.time.LocalDate;

public class Notification {
    private int notificationId;
    private String content;
    private LocalDate creationDate;

    public Notification(int notificationId, String content) {
        this.notificationId = notificationId;
        this.content = content;
        this.creationDate = LocalDate.now();
    }

    public boolean sendInvitation(User user) {
        user.update(this);
        return true;
    }

    public String getContent() {
        return content;
    }
}
