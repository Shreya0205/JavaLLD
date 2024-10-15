import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Doctor extends User{

    Speciality speciality;
    ArrayList<Slot> slots;
    HashMap<Slot, Patient> bookings;
    Integer rating;
    Integer Nratings;

    public Doctor(String name, Speciality speciality){
        this.Name =  name;
        this.slots = new ArrayList<>();
        this.bookings = new HashMap<>();
        this.rating = 0;
        this.Nratings = 0;
        this.speciality = speciality;
    }

    public void addSlot(Slot slot){
        this.slots.add(slot);
    }

    public void reserveSlot(Patient patient, Slot slot){
        if(this.bookings.containsKey(slot))
            System.out.println("this slow is already reserved");

        this.bookings.put(slot, patient);
    }

    public boolean areSlotsAvailable(){
        return this.slots.isEmpty() == false;
    }

    public void displayBookings() {
        if (this.slots.isEmpty()) {
            System.out.println("No available slots");
        }
        else {
            for (Slot slot : this.slots) {
                if(this.bookings.containsKey(slot))
                    System.out.println("Slot " + slot.localDateTime + "is booked with patient " + this.bookings.get(slot).Name);
                else
                    System.out.println("Slot " + slot.localDateTime + " is available");
            }
        }


    }

    public void displaySlots() {
        if (this.slots.isEmpty()){
            System.out.println("No slots");
            return;
        }

        for (Slot slot : this.slots){
            if(!this.bookings.containsKey(slot))
                System.out.println("Slot " + slot.localDateTime + " is available for doctor " +  this.Name + " with rating: " + this.rating);
        }

    }

    public void cancelBooking(LocalDateTime localDateTime) {
        this.bookings.remove(localDateTime);
    }

    public void addRating(Integer star){
        this.rating = this.rating*this.Nratings + star;
        this.Nratings++;
        this.rating /= this.Nratings;
    }
}
