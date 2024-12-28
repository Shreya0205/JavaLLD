package Code;

public class Item {

    Product product;
    Integer quantity;

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

    public void decreaseQuantity(){
        quantity--;
    }

    public boolean isQuantityZero(){
        return quantity.equals(0);
    }


}
