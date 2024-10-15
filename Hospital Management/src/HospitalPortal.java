import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class HospitalPortal {

    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;
    HashMap<Speciality, ArrayList<Doctor>> specialities;
    HashMap<LocalDateTime, Slot> slots;
    HashMap<Slot, ArrayList<Doctor>> appointments;

    public HospitalPortal(){
        this.doctors = new ArrayList<>();
        this.patients =  new ArrayList<>();
        this.specialities = new HashMap<>();
        this.slots = new HashMap<>();
        this.appointments = new HashMap<>();
        for(Speciality speciality : Speciality.values()){
            this.specialities.put(speciality, new ArrayList<>());
        }
    }

    public Doctor registerAsDoctor(String name, Speciality speciality){
        Doctor doctor = (Doctor) UserBuilderFactory.register(name, UserType.Doctor, speciality);
        ArrayList<Doctor> specialisedDoctors = this.specialities.get(speciality);
        specialisedDoctors.add(doctor);

        return doctor;

    }

    public Patient registerAsPatient(String name){
        return (Patient) UserBuilderFactory.register(name, UserType.Patient, Speciality.None);
    }

    public void searchSlots(Speciality speciality, DisplayStrategy displayStrategy){
        DisplayStrategyContext displayStrategyContext = new DisplayStrategyContext(displayStrategy);
        displayStrategyContext.displaySlots(this.specialities.get(speciality));
    }

    public void addSlot(Doctor doctor, LocalDateTime localDateTime){

        Slot slot = null;

        if(this.slots.containsKey(localDateTime)){
            slot = this.slots.get(localDateTime);
            ArrayList<Doctor> doctors  = this.appointments.get(slot);
            doctors.add(doctor);
        }
        else{
            slot = new Slot(localDateTime);
            this.slots.put(localDateTime, slot);
            ArrayList<Doctor> doctors = new ArrayList<>();
            doctors.add(doctor);
            this.appointments.put(slot, doctors);
        }
        doctor.addSlot(slot);

    }

    public Slot getSlot(LocalDateTime localDateTime){
        if(this.slots.containsKey(localDateTime)){
            return this.slots.get(localDateTime);
        }
        System.out.println("No slot for this time");
        return null;
    }

}
