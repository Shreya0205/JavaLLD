import java.awt.*;
import java.time.LocalDate;
import java.util.Random;

public class Reservation {
    public Integer reservationID;
    public Car car;
    Customer customer;
    public LocalDate fromDate;
    public LocalDate toDate;
    Integer totalPrice;

    public Reservation(Car car, Customer customer, LocalDate fromDate, LocalDate toDate, Integer days){
        Random random = new Random();
        this.reservationID = random.nextInt();
        this.car = car;
        this.customer = customer;
        this.fromDate = fromDate;
        this.toDate =  toDate;
        this.totalPrice = car.pricePerDay * days;
    }

    public void modifyReservation(LocalDate fromDate, LocalDate toDate, Integer days){
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalPrice = this.car.pricePerDay * days;
    }


}
