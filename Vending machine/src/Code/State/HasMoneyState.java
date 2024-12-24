package Code.State;

import Code.Coin;
import Code.Inventory;
import Code.Item;
import Code.VendingMachine;

import java.util.List;


public class HasMoneyState implements VendingMachineState {

    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pressInsertCoinButton() {
        throw new IllegalArgumentException("Button is already pressed, insert cash now");
    }

    @Override
    public void insertCoin(Coin coin) {
        this.vendingMachine.getCollectedCoins().add(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> coins = this.vendingMachine.getCollectedCoins();
        this.vendingMachine.setCollectedCoins();
        return coins;
    }

    @Override
    public void pressSelectProductButton() {
        this.vendingMachine.setVendingMachineState(new SelectionState(this.vendingMachine));
    }

    @Override
    public void selectProduct(Integer rackId) {
        throw new IllegalArgumentException("Press product selection button");
    }

    @Override
    public List<Coin> returnChange() {
        throw new IllegalArgumentException("Select product first");
    }

    @Override
    public Item getProduct(){
        throw new IllegalArgumentException("Insert cash first");
    }
}
