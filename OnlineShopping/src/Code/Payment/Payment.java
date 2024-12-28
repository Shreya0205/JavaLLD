package Code.Payment;

import Code.Order;

public abstract class Payment {

    Integer id;
    Order order;
    PaymentType paymentType;
    PaymentStatus paymentStatus;
    Double amount;

    abstract void pay(Double amount);

    public Payment(Integer id, Order order, PaymentType paymentType, PaymentStatus paymentStatus) {
        this.id = id;
        this.order = order;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
    }

}
