import java.util.HashMap;

public class Inventory {
    HashMap<Product, Integer> products;

    public Inventory(){
        this.products = new HashMap<>();
    }

    void addProduct(Product product, Integer quantity){
        this.products.put(product, quantity);
    }

    public Integer getQuantity(Product product){
        return this.products.get(product);
    }

    void restockProduct(Product product, Integer Quantity){
        this.products.compute(product, (k, quantity) -> quantity + Quantity);
    }

    void sellProduct(Product product, Integer Quantity){
        this.products.compute(product, (k, quantity) -> quantity - Quantity);
    }

}
