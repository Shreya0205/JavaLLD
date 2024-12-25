package code;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private int id;
    private int capacity;
    private List<Interval> bookedIntervals;

    public MeetingRoom(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.bookedIntervals = new ArrayList<>();
    }

    public boolean isAvailable(Interval interval) {
        for (Interval booked : bookedIntervals) {
            if (booked.overlaps(interval)) {
                return false;
            }
        }
        return true;
    }

    public boolean bookRoom(Interval interval) {
        if (isAvailable(interval)) {
            bookedIntervals.add(interval);
            return true;
        }
        return false;
    }

    public void releaseRoom(Interval interval) {
        bookedIntervals.remove(interval);
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
}
