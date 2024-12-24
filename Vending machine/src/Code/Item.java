package Code;

public class Item {
    ItemType itemType;
    Double price;

    public Item(Double price, ItemType itemType) {
        this.price = price;
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Double getPrice() {
        return price;
    }
}
