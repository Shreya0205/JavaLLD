package Code.Services;

import Code.Address;
import Code.Customer;
import Code.Item;
import Code.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public Order placeOrder(Customer customer, List<Item> items, Address address, double total) {
        Order order = new Order(new Random().nextInt(1000), customer, items, total, address);
        orders.add(order);
        order.markAsConfirmed();
        return order;
    }

}