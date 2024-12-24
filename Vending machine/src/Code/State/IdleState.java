package Code.State;

import Code.Coin;
import Code.Item;
import Code.VendingMachine;

import java.util.List;


public class IdleState implements VendingMachineState {

    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pressInsertCoinButton() {
        this.vendingMachine.setVendingMachineState(new HasMoneyState(this.vendingMachine));
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new IllegalArgumentException("Press insert coin button");
    }

    @Override
    public List<Coin> refund() {
        throw new IllegalArgumentException("Insert cash first");
    }

    @Override
    public void pressSelectProductButton() {
        throw new IllegalArgumentException("Insert cash first");
    }

    @Override
    public void selectProduct(Integer rackId) {
        throw new IllegalArgumentException("Insert cash first");
    }

    @Override
    public List<Coin> returnChange() {
        throw new IllegalArgumentException("Insert cash first");
    }

    @Override
    public Item getProduct(){
        throw new IllegalArgumentException("Insert cash first");
    }
}
