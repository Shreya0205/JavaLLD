package code;

public class User implements Observer {
    private String name;
    private String email;
    private Calendar calendar;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.calendar = new Calendar();
    }

    public void respondToInvitation(Meeting meeting, Response response) {
        System.out.println(name + " responded to the invitation for " + meeting.getSubject() + ": " + response);

        if (response == Response.ACCEPTED) {
            this.calendar.addMeeting(meeting);
            System.out.println(name + " has accepted the meeting: " + meeting.getSubject());
        }
    }

    @Override
    public void update(Notification notification) {
        System.out.println(name + " received notification: " + notification.getContent());
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
