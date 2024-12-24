package Code.State;

import Code.Coin;
import Code.Item;
import Code.VendingMachine;

import java.util.List;


public class SelectionState implements VendingMachineState {

    VendingMachine vendingMachine;

    public SelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void pressInsertCoinButton() {
        throw new IllegalArgumentException("Machine is in selection state, Refund or select product");
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new IllegalArgumentException("Machine is in selection state, Refund or select product");
    }


    @Override
    public List<Coin> refund() {
        List<Coin> coins = this.vendingMachine.getCollectedCoins();
        this.vendingMachine.setCollectedCoins();
        return coins;
    }

    @Override
    public void pressSelectProductButton() {
        throw new IllegalArgumentException("Machine is in selection state, Refund or select product");
    }

    @Override
    public void selectProduct(Integer rackId) {

        Integer value=0;

        for (Coin coin: this.vendingMachine.getCollectedCoins()){
            value += coin.value;
        }

        if( value < this.vendingMachine.getInventory().getItem(rackId).getPrice()) {
            throw new IllegalArgumentException("Not enough coin inserted");
        }

        this.vendingMachine.setSelectedRack(rackId);
        this.vendingMachine.setVendingMachineState(new DispensingProductState(this.vendingMachine));
    }

    @Override
    public List<Coin> returnChange() {
        return null;
    }

    @Override
    public Item getProduct() {
        throw new IllegalArgumentException("Machine is in selection state, Refund or select product");
    }
}
