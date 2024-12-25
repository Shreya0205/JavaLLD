package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meeting {
    private int id;
    private String subject;
    private List<User> participants;
    private Interval interval;
    private MeetingRoom room;
    private Map<User, Response> responses;

    public Meeting(int id, String subject, Interval interval, MeetingRoom room) {
        this.id = id;
        this.subject = subject;
        this.interval = interval;
        this.room = room;
        this.participants = new ArrayList<>();
        this.responses = new HashMap<>();
    }

    public void addParticipants(List<User> participants) {
        this.participants.addAll(participants);
        for (User participant : participants) {
            participant.update(new Notification(id, "Meeting invitation: " + subject));
        }
    }

    public void removeParticipants(List<User> participants) {
        this.participants.removeAll(participants);
        for (User participant : participants) {
            participant.update(new Notification(id, "Meeting canceled: " + subject));
        }
    }

    public void setResponse(User user, Response response) {
        responses.put(user, response);
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Interval getInterval() {
        return interval;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public Map<User, Response> getResponses() {
        return responses;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", interval=" + interval +
                ", room=" + room.getId() +
                '}';
    }
}
