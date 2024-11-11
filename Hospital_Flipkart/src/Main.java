import Java.models.DisplayStrategyEnum;
import Java.models.Speciality;
import Java.services.*;

import java.awt.*;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        https://leetcode.com/discuss/interview-question/5377854/Flipkart-or-SDE2-or-Machine-Coding-Round
        
        UserService userService = UserService.getInstance();
        SlotService slotService = SlotService.getInstance();
        AppointmentService appointmentService = AppointmentService.getInstance(slotService);
        DoctorService doctorService = DoctorService.getInstance(userService, slotService, appointmentService);
        PatientService patientService = PatientService.getInstance(userService, slotService, appointmentService);

        Integer patientid = patientService.register("shreya");
        patientService.login(patientid);

        Integer doctorid = doctorService.register("sonal", Speciality.Cardiologist);
        doctorService.login(doctorid);

        doctorService.addSlot(LocalDateTime.now(), LocalDateTime.now());
        patientService.findSlot(Speciality.Cardiologist, DisplayStrategyEnum.ranking);
        patientService.bookAppointment(1);

        patientService.findSlot(Speciality.Cardiologist, DisplayStrategyEnum.ranking);
        patientService.viewAppointments();
        doctorService.viewAppointments();
    }
}