package Code;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items;
    Double totalPrice;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addToCart(Product product){

        for(Item item: items){
            if(item.getProduct() == product){
                item.increaseQuantity();
                totalPrice += product.getPrice();
                return;
            }
        }

        items.add(new Item(product, 1));
    }

    public void removeFromCart(Product product){
        for(Item item: items){
            if(item.getProduct() == product){
                totalPrice -= product.getPrice()* item.getQuantity();
                items.remove(item);
                return;
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void removeAllItems(){
        this.items.clear();
        totalPrice = 0.0;
    }

}
