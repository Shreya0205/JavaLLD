import java.util.HashMap;

public class VendingMachine {
    State state;
    Integer collectedCash;
    Inventory inventory;
    static VendingMachine vendingMachine=null;
    HashMap<String, Product> products;
    Product selectedProduct;
    Integer selectedCollectedCash;
    Integer selectedQuantity;

    private VendingMachine(){
        this.inventory = new Inventory();
        this.products = new HashMap<>();
        this.collectedCash = 0;
        this.state = new ReadyState(this);
        this.selectedCollectedCash = 0;
        this.selectedQuantity = 0;
        this.selectedProduct = null;
    }

    public synchronized static VendingMachine getInstance(){
        if(vendingMachine==null){
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    public void addProduct(String name, Integer quantity, Integer price){
        Product product = new Product(name, price);
        this.products.put(name, product);
        inventory.addProduct(product, quantity);
    }

    public Integer getProductPrice(String name){
        Product product = this.products.get(name);
        return product.getPrice();
    }

    public void restockProduct(String name, Integer Quantity){
        Product product = this.products.get(name);
        this.inventory.restockProduct(product, Quantity);
    }

    public Integer takeOutCash(){
        Integer totalCash = this.collectedCash;
        this.collectedCash = 0;
        return this.collectedCash;
    }

    void selectProduct(String product, Integer quantity){
        this.selectedProduct = this.products.get(product);

        if ( quantity > this.inventory.getQuantity(this.selectedProduct))
            System.out.println("Insufficient Product");

        this.selectedQuantity = quantity;
    }

    void addTxnCash(Integer cash){
        this.selectedCollectedCash += cash;
    }

    void addCash(Integer cash){
        this.collectedCash += cash;
    }

    void changeState(State state){
        this.state = state;
    }

    void collectCash(Integer cash){
        if(this.selectedProduct == null)
            System.out.println("Please select product");
        this.state.collectCash(cash);
    }

    public void dispenseChange(){
        if(this.selectedProduct == null)
            System.out.println("Please select product");
        this.state.dispenseChange();
    }

    public void dispenseItem(){
        if(this.selectedProduct == null)
            System.out.println("Please select product");
        this.state.dispenseItem();
    }

    public void cancelTxn(){
        if(this.selectedProduct == null)
            System.out.println("Please select product");
        this.state.cancelTxn();
    }
}
