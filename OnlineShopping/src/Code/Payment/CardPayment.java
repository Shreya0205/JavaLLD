package Code.Payment;

import Code.Order;

public class CardPayment extends Payment {

    public CardPayment(Integer id, Order order) {
        super(id, order, PaymentType.card, PaymentStatus.initiated);
    }

    @Override
    void pay(Double amount) {
        this.amount = amount;
    }

}
