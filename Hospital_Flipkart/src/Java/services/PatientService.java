package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.*;

public class PatientService {
    private static PatientService patientService = null;
    private UserService userService;
    private Patient currentUser;
    private SlotService slotService;
    AppointmentService appointmentService;

    public PatientService(UserService userService, SlotService slotService, AppointmentService appointmentService){
        this.currentUser = null;
        this.userService = userService;
        this.slotService = slotService;
        this.appointmentService = appointmentService;
    }

    public static PatientService getInstance(UserService userService, SlotService slotService, AppointmentService appointmentService){
        if( patientService == null){
            patientService = new PatientService(userService, slotService, appointmentService);
        }
        return patientService;
    }

    public void login(Integer Id){
        Patient patient = (Patient) userService.findUser(Id);
        if (patient == null) throw new ResourceNotFoundException("Doctor with this id does not exist");
        this.currentUser = patient;
        System.out.println("logged in");
    }

    public Integer register(String name){
        Patient patient = (Patient) userService.createUser(name, UserType.patient);
        return patient.getId();
    }

    public void findSlot(Speciality speciality, DisplayStrategyEnum displayStrategyEnum){
        slotService.getSlotOfSpeciality(speciality, displayStrategyEnum);
    }

    public Integer bookAppointment(Integer slotID){
        Slot slot = slotService.findSlot(slotID);
        Appointment appointment = appointmentService.createAppointment(slot.getDoctor(), currentUser, slotID);
        return appointment.getId();
    }

    public void cancelAppointment(Integer appointmentID){
        appointmentService.cancelAppointment(appointmentID);
    }

    public void viewAppointments(){
        appointmentService.viewAppointments(currentUser.getId());
    }


}
