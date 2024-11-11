package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.*;
import Java.repository.UserRepository;

import java.time.LocalDateTime;

public class DoctorService {
    private static DoctorService doctorService = null;
    private UserService userService;
    private Doctor currentUser;
    private SlotService slotService;
    private AppointmentService appointmentService;

    public DoctorService(UserService userService, SlotService slotService, AppointmentService appointmentService){
        this.currentUser = null;
        this.userService = userService;
        this.slotService = slotService;
        this.appointmentService = appointmentService;
    }

    public static DoctorService getInstance(UserService userService, SlotService slotService, AppointmentService appointmentService){
        if( doctorService == null){
            doctorService = new DoctorService(userService, slotService, appointmentService);
        }
        return doctorService;
    }

    public void login(Integer Id){
        Doctor doctor = (Doctor) userService.findUser(Id);
        if (doctor == null) throw new ResourceNotFoundException("Doctor with this id does not exist");
        this.currentUser = doctor;
        System.out.println("logged in");
    }

    public Integer register(String name, Speciality speciality){
        Doctor doctor = (Doctor) userService.createUser(name, UserType.doctor);
        doctor.setSpeciality(speciality);
        return doctor.getId();
    }

    public void addSlot(LocalDateTime start, LocalDateTime end){
        Slot slot = slotService.createSlot(start, currentUser);
    }

    public void viewAppointments(){
        appointmentService.viewAppointments(currentUser.getId());
    }


}
