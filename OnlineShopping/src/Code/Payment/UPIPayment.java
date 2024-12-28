package Code.Payment;

import Code.Order;

public class UPIPayment extends Payment {

    public UPIPayment(Integer id, Order order) {
        super(id, order, PaymentType.upi, PaymentStatus.initiated);
    }

    @Override
    void pay(Double amount) {
        this.amount = amount;
    }

}
