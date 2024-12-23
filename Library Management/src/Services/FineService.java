package Services;

import Model.Reservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineService {

    double finePerDay = 50;

    public FineService(double finePerDay) {
        this.finePerDay = finePerDay;
    }

    public Double calculateFine(Reservation reservation){

        if(LocalDate.now().isAfter(reservation.getDueDate())){
            int days = (int) ChronoUnit.DAYS.between(reservation.getDueDate(), LocalDate.now());
            return days*finePerDay;
        }

        return 0.0;
    }
}
