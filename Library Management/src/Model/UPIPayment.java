package Model;

public class UPIPayment extends Payment {

    public UPIPayment(Reservation reservation, PaymentType paymentType) {
        super(reservation, paymentType);
    }

    @Override
    public void pay(Double amount) {
        this.amount = amount;
        System.out.println("Paying amount: " +  amount);
    }

}
