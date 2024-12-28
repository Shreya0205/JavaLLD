package Code;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements Notification{

    List<Order> orders;

    public Customer(Integer id, String name, String password, UserType userType) {
        super(id, name, password, userType);
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void receiveNotification(String message){
        System.out.println(message);
    }
}
