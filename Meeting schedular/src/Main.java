import code.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice", "alice@example.com");
        User bob = new User("Bob", "bob@example.com");
        User carl = new User("Carl", "carl@example.com");

        MeetingRoom room1 = new MeetingRoom(1, 10);
        MeetingRoom room2 = new MeetingRoom(2, 5);

        MeetingScheduler scheduler = MeetingScheduler.getInstance();
        scheduler.addMeetingRoom(room1);
        scheduler.addMeetingRoom(room2);

        Interval interval = new Interval(LocalDateTime.of(2025, 01, 01, 13, 30),
                LocalDateTime.of(2025, 01, 01, 14, 30)); // 1 hour meeting
        List<User> participants = Arrays.asList(bob, carl);
        Meeting meeting = scheduler.scheduleMeeting(alice, "Team Sync", participants, interval, 5);

        carl.respondToInvitation(meeting, Response.ACCEPTED);
        bob.respondToInvitation(meeting, Response.REJECTED);

        // Check responses
        scheduler.checkMeetingResponses(meeting);

        // Verify that Alice's calendar contains the meeting
        System.out.println(alice.getName() + "'s calendar: " + alice.getCalendar().getMeetings());
        System.out.println(bob.getName() + "'s calendar: " + bob.getCalendar().getMeetings());
        System.out.println(carl.getName() + "'s calendar: " + carl.getCalendar().getMeetings());

    }
}