package Java.repository;

import Java.models.Slot;
import Java.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlotRepository {

    private final HashMap<Integer, Slot> slots = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Slot save(Slot slot) {
        if (slot.getId() == null) {
            slot.setId(idCounter.getAndIncrement());
        }
        slots.put(slot.getId(), slot);
        return slot;
    }

    public Slot findById(Integer id) {
        return slots.get(id);
    }

    public Collection<Slot> findAll() {
        return slots.values();
    }

    public void deleteById(Integer id) {
        slots.remove(id);
    }

    public boolean existsById(Integer id) {
        return slots.containsKey(id);
    }

}
