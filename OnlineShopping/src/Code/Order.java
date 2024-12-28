package Code;

import Code.Payment.Payment;

import java.util.List;

public class Order{

    Integer orderId;
    Customer customer;
    List<Item> itemList;
    Double amount;
    Address shippingAddress;
    OrderStatus orderStatus;

    public Order(Integer orderId, Customer customer, List<Item> itemList, Double amount, Address shippingAddress) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemList = itemList;
        this.amount = amount;
        this.shippingAddress = shippingAddress;
        orderStatus = OrderStatus.initiated;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void markAsDelivered(){
        orderStatus = OrderStatus.delivered;
        notifyCustomer("Your " + orderId +  " is marked as delivered");
    }

    public void markAsShipped(){
        orderStatus = OrderStatus.shipped;
        notifyCustomer("Your " + orderId +  " is shipped to given address");
    }

    public void markAsConfirmed(){
        orderStatus = OrderStatus.confirmed;
        notifyCustomer("Your " + orderId +  " is confirmed");
    }

    public void notifyCustomer(String message) {
        customer.receiveNotification(message);
    }



}
