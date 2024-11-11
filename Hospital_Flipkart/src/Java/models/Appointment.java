package Java.models;

public class Appointment {

    Integer id;
    User doctor;
    User patient;
    Slot slot;

    public Appointment(Integer id, User doctor, User patient, Slot slot) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", slot=" + slot.getTime() +
                '}';
    }
}
