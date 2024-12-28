package Code;

import Code.Services.CustomerService;
import Code.Services.InventoryService;
import Code.Services.OrderService;
import Code.Services.ShoppingCartService;

import java.util.List;

public class ShoppingSystem {

    private InventoryService inventoryService;
    private ShoppingCartService shoppingCartService;
    private OrderService orderService;
    private CustomerService customerService;

    public ShoppingSystem(InventoryService inventoryService, ShoppingCartService shoppingCartService,
                          OrderService orderService, CustomerService customerService) {
        this.inventoryService = inventoryService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.customerService = customerService;
    }

    public void addCategory(Admin admin, CategoryType category) {
        inventoryService.addCategory(category);
    }

    public void removeCategory(Admin admin, CategoryType category) {
        inventoryService.removeCategory(category);
    }

    public void addProduct(Admin admin, Product product) {
        inventoryService.addProduct(product);
    }

    public void removeProduct(Admin admin, Product product) {
        inventoryService.removeProduct(product);
    }

    public List<Product> searchByCategory(CategoryType category) {
        return inventoryService.searchByCategory(category);
    }

    public List<Product> searchByName(String name) {
        return inventoryService.searchByProductName(name);
    }

    public void addToCart(Customer customer, Product product) {
        if (!customerService.isBlocked(customer)) {
            shoppingCartService.addToCart(customer, product);
        }
    }

    public void customerRemoveFromCart(Customer customer, Product product) {
        if (!customerService.isBlocked(customer)) {
            shoppingCartService.removeFromCart(customer, product);
        }
    }

    public void customerPlaceOrder(Customer customer, Address address) {
        ShoppingCart cart = shoppingCartService.getCart(customer);
        double total = cart.getTotalPrice();
        Order order = orderService.placeOrder(customer, cart.getItems(), address, total);
        System.out.println("Order placed: " + order.getOrderId());
        cart.removeAllItems();
    }
}
