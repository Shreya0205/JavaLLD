import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class CarRentalSytem {

    HashMap<String, Car> cars;
    HashMap<Integer, Reservation> reservations;
    HashMap<Integer, Customer> customers;
    private static CarRentalSytem carRentalSytem = null;

    private CarRentalSytem(){
        this.cars = new HashMap<>();
        this.reservations = new HashMap<>();
        this.customers =  new HashMap<>();
    }

    public static CarRentalSytem getInstance(){
        if(carRentalSytem ==null){
            carRentalSytem = new CarRentalSytem();
        }
        return carRentalSytem;
    }

    public void addCar(String plateNumber, Type type, Integer price){
        Car car = new Car(plateNumber, type, price);
        this.cars.put(car.plateNumber, car);
    }

    public void searchCarsOfType(Type type){
        for (Car car:this.cars.values()){
            if(car.type == type){
                System.out.println("Car details: " + car.toString());
            }
        }
    }

    public boolean isCarAvailableFromDates(String carNumber, LocalDate fromDate, LocalDate toDate){
        Car car = this.cars.get(carNumber);
        for (Reservation reservation:this.reservations.values()){
            if(reservation.car == car){
                if( !(reservation.toDate.isBefore(fromDate) || reservation.fromDate.isAfter(toDate)) ){
                    System.out.println("Sorry, Car is not available");
                    return false;
                }
            }
        }
        System.out.println("Yes, Car is available");
        return true;
    }

    public Integer reserveCar(String name, String phoneNumber, Integer licenseNumber, String carNumber, LocalDate fromDate, LocalDate toDate, Integer days){
        Customer customer = new Customer(name, phoneNumber, licenseNumber);
        this.customers.put(licenseNumber, customer);

        Car car = this.cars.get(carNumber);
        Reservation reservation = new Reservation(car, customer, fromDate, toDate, days);
        this.reservations.put(reservation.reservationID, reservation);
        System.out.println("A reservation has been made by " + name + " for Car "
                + car.plateNumber + " from " + fromDate + " to " + toDate + " under reservation id: "
                + reservation.reservationID);

        return reservation.reservationID;
    }

    public void cancelReservation(Integer reservationID){
        this.reservations.remove(reservationID);
        System.out.println("Cancelled reservation with ID " + reservationID);
    }

    public void modifyReservation(Integer reservationID, LocalDate fromDate, LocalDate toDate, Integer days){
        Reservation reservation = this.reservations.get(reservationID);
        reservation.modifyReservation(fromDate, toDate, days);
    }


}
