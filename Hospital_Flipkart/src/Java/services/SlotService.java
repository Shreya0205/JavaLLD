package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.*;
import Java.repository.SlotRepository;
import Java.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class SlotService {
    private static SlotService slotService = null;
    private SlotRepository slotRepository;

    public SlotService(){
        slotRepository = new SlotRepository();
    }

    public static SlotService getInstance(){
        if( slotService == null){
            slotService = new SlotService();
        }
        return slotService;
    }

    public Slot createSlot(LocalDateTime time, Doctor doctor){
        Slot slot = new Slot(null, time, doctor);
        slotRepository.save(slot);
        return slot;
    }

    public Slot findSlot(Integer Id){
        Slot slot = slotRepository.findById(Id);
        if (slot == null) throw new ResourceNotFoundException("List not found with id: " + Id);
        return slot;
    }

    public void getSlotOfSpeciality(Speciality speciality, DisplayStrategyEnum displayStrategyEnum){
        Collection<Slot> slots = this.slotRepository.findAll();
        ArrayList<Slot> foundSlots = new ArrayList<>();

        for (Slot slot: slots){
            if(slot.getDoctor().getSpeciality() == speciality && slot.getStatus() == Status.available)
                foundSlots.add(slot);
        }

        if(foundSlots.size() == 0){
            System.out.println("No slots");
            return;
        }

        DisplayStrategy displayStrategy = DisplayStrategyFactory.getDisplayStartegy(displayStrategyEnum);
        displayStrategy.displaySlots(foundSlots);
    }

    public void bookSlot(Integer id){
        Slot slot = this.findSlot(id);
        slot.setStatus(Status.booked);
    }

}
