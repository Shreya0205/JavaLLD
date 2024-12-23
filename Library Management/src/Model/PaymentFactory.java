package Model;

public class PaymentFactory {

    public static Payment getPaymentObject(PaymentType type, Reservation reservation){
        return new UPIPayment(reservation, type);
    }
}
