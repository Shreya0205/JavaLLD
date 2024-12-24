package Code.State;

import Code.Coin;
import Code.Item;
import Code.VendingMachine;

import java.util.List;


public class DispensingProductState implements VendingMachineState {

    VendingMachine vendingMachine;

    public DispensingProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void pressInsertCoinButton() {
        throw new IllegalArgumentException("Machine is in dispensing state, please wait");
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new IllegalArgumentException("Machine is in dispensing state, please wait");
    }

    @Override
    public List<Coin> refund() {
        throw new IllegalArgumentException("Machine is in dispensing state, please wait");
    }

    @Override
    public void pressSelectProductButton() {
        throw new IllegalArgumentException("Machine is in dispensing state, please wait");
    }

    @Override
    public void selectProduct(Integer rackId) {
        throw new IllegalArgumentException("Machine is in dispensing state, please wait");
    }

    @Override
    public List<Coin> returnChange() {
        throw new IllegalArgumentException("Machine is in dispensing state, please wait");
    }

    @Override
    public Item getProduct() {
        Item item = this.vendingMachine.getInventory().getItem(this.vendingMachine.getSelectedRack());
        this.vendingMachine.setSelectedRack(null);
        this.vendingMachine.setVendingMachineState(new IdleState(this.vendingMachine));
        return item;
    }
}
