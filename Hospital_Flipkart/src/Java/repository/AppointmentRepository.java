package Java.repository;

import Java.models.Appointment;
import Java.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppointmentRepository {
    private final HashMap<Integer, Appointment> appointments = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Appointment save(Appointment appointment) {
        if (appointment.getId() == null) {
            appointment.setId(idCounter.getAndIncrement());
        }
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    public Appointment findById(Integer id) {
        return appointments.get(id);
    }

    public Collection<Appointment> findAll() {
        return appointments.values();
    }

    public void deleteById(Integer id) {
        appointments.remove(id);
    }

    public boolean existsById(Integer id) {
        return appointments.containsKey(id);
    }
}
