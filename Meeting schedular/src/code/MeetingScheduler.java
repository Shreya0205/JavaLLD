package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MeetingScheduler {
    private static MeetingScheduler scheduler = null;
    private List<MeetingRoom> rooms;

    private MeetingScheduler() {
        this.rooms = new ArrayList<>();
    }

    public static MeetingScheduler getInstance() {
        if (scheduler == null) {
            scheduler = new MeetingScheduler();
        }
        return scheduler;
    }

    public Meeting scheduleMeeting(User organizer, String subject, List<User> participants, Interval interval, int roomCapacity) {
        MeetingRoom room = checkRoomsAvailability(roomCapacity, interval);
        if (room == null) {
            System.out.println("No room available for the meeting.");
            return null;
        }

        Meeting meeting = new Meeting(new Random().nextInt(1000), subject, interval, room);
        meeting.addParticipants(participants);

        room.bookRoom(interval);
        organizer.getCalendar().addMeeting(meeting);

        return meeting;
    }

    public boolean cancelMeeting(Meeting meeting) {
        meeting.getRoom().releaseRoom(meeting.getInterval());
        for (User participant : meeting.getResponses().keySet()) {
            participant.getCalendar().removeMeeting(meeting);
        }
        System.out.println("Meeting canceled: " + meeting.getSubject());
        return true;
    }

    public MeetingRoom checkRoomsAvailability(int capacity, Interval interval) {
        for (MeetingRoom room : rooms) {
            if (room.getCapacity() >= capacity && room.isAvailable(interval)) {
                return room;
            }
        }
        return null;
    }

    public void addMeetingRoom(MeetingRoom room) {
        rooms.add(room);
    }

    public void checkMeetingResponses(Meeting meeting) {
        Map<User, Response> responses = meeting.getResponses();
        for (Map.Entry<User, Response> entry : responses.entrySet()) {
            System.out.println(entry.getKey().getName() + " responded with: " + entry.getValue());
        }
    }
}
