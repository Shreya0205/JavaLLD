package Code;

import java.util.HashMap;

public class Inventory {

    HashMap<Integer, Rack> racks;

    public Inventory() {
        this.racks = new HashMap<>();
    }

    public void addRack(Rack rack){
        this.racks.put(rack.getCode(), rack);
    }

    public void addItem(Integer rackId, Item item){
        this.racks.get(rackId).addItem(item);
    }

    public Item getItem(Integer rackId){
        return this.racks.get(rackId).getItem();
    }

    public Item removeItem(Integer rackId){
        return this.racks.get(rackId).removeItem();
    }

}
