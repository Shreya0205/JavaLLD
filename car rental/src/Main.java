import java.time.LocalDate;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarRentalSytem carRentalSytem = CarRentalSytem.getInstance();

        carRentalSytem.addCar("1231", Type.SUV, 500);
        carRentalSytem.addCar("1232", Type.SUV, 600);

        carRentalSytem.addCar("1233", Type.mini, 100);
        carRentalSytem.addCar("1234", Type.SUV, 150);

        carRentalSytem.addCar("1235", Type.sedan, 300);
        carRentalSytem.addCar("1236", Type.sedan, 400);

        carRentalSytem.searchCarsOfType(Type.sedan);
        carRentalSytem.searchCarsOfType(Type.SUV);
        carRentalSytem.searchCarsOfType(Type.mini);

        LocalDate fromDate = LocalDate.of(2024, 10, 12);
        LocalDate toDate = LocalDate.of(2024, 10, 14);

        carRentalSytem.isCarAvailableFromDates("1235", fromDate, toDate);
        carRentalSytem.reserveCar("Shreya", "9887821180", 1234567, "1235", fromDate, toDate, 3);

        LocalDate fromDate1 = LocalDate.of(2024, 10, 13);
        LocalDate toDate1 = LocalDate.of(2024, 10, 15);
        carRentalSytem.isCarAvailableFromDates("1235", fromDate1, toDate1);

    }
}