import Code.*;
import Code.Services.CustomerService;
import Code.Services.InventoryService;
import Code.Services.OrderService;
import Code.Services.ShoppingCartService;

public class Main {
    public static void main(String[] args) {

        ShoppingSystem shoppingSystem = new ShoppingSystem(new InventoryService(), new ShoppingCartService(),
                new OrderService(), new CustomerService());

        Admin admin = new Admin(1, "Admin", "admin123", UserType.admin);
        shoppingSystem.addCategory(admin, CategoryType.electronic);
        shoppingSystem.addCategory(admin, CategoryType.cosmetics);

        Product laptop = new Product(1, "Laptop", CategoryType.electronic, 50000.0);
        Product lipstick = new Product(2, "Lipstick", CategoryType.cosmetics, 500.0);

        shoppingSystem.addProduct(admin, laptop);
        shoppingSystem.addProduct(admin, lipstick);

        Customer customer = new Customer(2, "Alice", "alice123", UserType.customer);
        shoppingSystem.addToCart(customer, laptop);
        shoppingSystem.addToCart(customer, lipstick);

        Address address = new Address(1, "123 Main St", "City", "State", 123456);
        shoppingSystem.customerPlaceOrder(customer, address);

    }
}