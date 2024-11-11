package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.*;
import Java.repository.AppointmentRepository;

import java.util.Collection;

public class AppointmentService {
    private static AppointmentService appointmentService = null;
    private AppointmentRepository appointmentRepository;
    private SlotService slotService;

    public AppointmentService(SlotService slotService){
        appointmentRepository = new AppointmentRepository();
        this.slotService = slotService;
    }

    public static AppointmentService getInstance(SlotService slotService){
        if( appointmentService == null){
            appointmentService = new AppointmentService(slotService);
        }
        return appointmentService;
    }

    public Appointment createAppointment(User doctor, User patient, Integer slotID){
        slotService.bookSlot(slotID);
        Slot slot = slotService.findSlot(slotID);
        Appointment appointment = new Appointment(null, doctor, patient, slot);
        appointmentRepository.save(appointment);
        return appointment;
    }

    public Appointment findAppointment(Integer Id){
        Appointment appointment = appointmentRepository.findById(Id);
        if (appointment == null) throw new ResourceNotFoundException("appointment not found with id: " + Id);
        return appointment;
    }

    public void cancelAppointment(Integer id){
        Slot slot = slotService.findSlot(id);
        slot.setStatus(Status.available);
        this.appointmentRepository.deleteById(id);
    }

    public void viewAppointments(Integer id){
        Collection<Appointment>  appointments = appointmentRepository.findAll();
        for(Appointment appointment: appointments){
            if(appointment.getDoctor().getId() == id || appointment.getPatient().getId() == id){
                System.out.println(appointment.toString());
            }
        }
    }

}
