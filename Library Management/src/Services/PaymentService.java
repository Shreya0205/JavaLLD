package Services;

import Model.Payment;
import Model.PaymentFactory;
import Model.PaymentType;
import Model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PaymentService {
    List<Payment> payments;
    AtomicInteger id;

    public PaymentService() {
        this.payments = new ArrayList<>();
        this.id = new AtomicInteger();
    }

    public void makePayment(double amount, PaymentType type, Reservation reservation){
        Payment payment = PaymentFactory.getPaymentObject(type, reservation);
        payment.setId(this.id.getAndIncrement());
        payment.pay(amount);
        this.payments.add(payment);
    }

}
