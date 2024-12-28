package Code.Services;

import Code.Customer;
import Code.Item;
import Code.Product;
import Code.ShoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartService {

    private Map<Customer, ShoppingCart> customerCarts;

    public ShoppingCartService() {
        this.customerCarts = new HashMap<>();
    }

    public void addToCart(Customer customer, Product product) {
        ShoppingCart cart = customerCarts.computeIfAbsent(customer, k -> new ShoppingCart());
        cart.addToCart(product);
    }

    public void removeFromCart(Customer customer, Product product) {
        ShoppingCart cart = customerCarts.get(customer);
        if (cart != null) {
            cart.removeFromCart(product);
        }
    }

    public ShoppingCart getCart(Customer customer) {
        return customerCarts.getOrDefault(customer, new ShoppingCart());
    }

    public void emptyCart(Customer customer){
        customerCarts.getOrDefault(customer, new ShoppingCart()).removeAllItems();
    }

}
