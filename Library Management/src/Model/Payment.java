package Model;

public abstract class Payment {

    Integer id;
    Reservation reservation;
    PaymentType paymentType;
    Double amount;

    public Payment(Reservation reservation, PaymentType paymentType) {
        this.reservation = reservation;
        this.paymentType = paymentType;
    }

    public abstract void pay(Double amount);

    public void setId(Integer id) {
        this.id = id;
    }
}
