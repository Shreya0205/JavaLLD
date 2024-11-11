package Java.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Slot {

    Integer id;
    LocalDateTime time;
    Doctor doctor;
    Status status;

    public Slot(Integer id, LocalDateTime time, Doctor doctor) {
        this.id = id;
        this.time = time;
        this.doctor = doctor;
        this.status = Status.available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", time=" + time.toString() +
                ", doctor=" + doctor.getName() +
                '}';
    }
}
