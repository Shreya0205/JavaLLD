package Java.Repository;

import Java.Models.SubTrack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SubTrackRepository {
    private final HashMap<Integer, SubTrack> subtracks = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public SubTrack save(SubTrack subtrack) {
        if (subtrack.getId() == null) {
            subtrack.setId(idCounter.getAndIncrement());
        }
        subtracks.put(subtrack.getId(), subtrack);
        return subtrack;
    }

    public SubTrack findById(Integer id) {
        return subtracks.get(id);
    }

    public Collection<SubTrack> findAll() {
        return subtracks.values();
    }

    public void deleteById(Integer id) {
        subtracks.remove(id);
    }

    public boolean existsById(Integer id) {
        return subtracks.containsKey(id);
    }
}
