package Code;

import java.util.LinkedList;
import java.util.List;

public class Rack {
    Integer code;
    List<Item> items;

    public Rack(Integer code) {
        this.code = code;
        this.items = new LinkedList<>();
    }

    public Integer getCode() {
        return code;
    }

    public Item removeItem() {
        return this.items.removeFirst();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Item getItem() {
        return this.items.getFirst();
    }
}

