package Code;

import Code.State.IdleState;
import Code.State.VendingMachineState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VendingMachine implements VendingMachineState {

    Inventory inventory;
    VendingMachineState vendingMachineState;
    List<Coin> totalCoins;
    List<Coin> collectedCoins;
    Integer selectedRack;

    public VendingMachine() {
        this.inventory = new Inventory();
        this.vendingMachineState = new IdleState(this);
        this.collectedCoins = new ArrayList<>();
        this.totalCoins = new ArrayList<>();
        this.selectedRack = null;
    }

    public void addRack(Integer rackId){
        this.inventory.addRack(new Rack(rackId));
    }

    public void addItemInRack(Integer rackId, Item item){
        this.inventory.addItem(rackId, item);
    }

    @Override
    public void pressInsertCoinButton() {
        this.vendingMachineState.pressInsertCoinButton();
    }

    @Override
    public void insertCoin(Coin coin) {
        this.vendingMachineState.insertCoin(coin);
    }

    @Override
    public List<Coin> refund() {
        return this.vendingMachineState.refund();
    }

    @Override
    public void pressSelectProductButton() {
        this.vendingMachineState.pressSelectProductButton();
    }

    @Override
    public void selectProduct(Integer rackId) {
        this.vendingMachineState.selectProduct(rackId);
    }

    @Override
    public List<Coin> returnChange() {
        return this.vendingMachineState.returnChange();
    }

    @Override
    public Item getProduct() {
        return this.vendingMachineState.getProduct();
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public List<Coin> getCollectedCoins() {
        return collectedCoins;
    }

    public void setCollectedCoins() {
        this.collectedCoins = new ArrayList<>();
    }

    public void setSelectedRack(Integer selectedRack) {
        this.selectedRack = selectedRack;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Integer getSelectedRack() {
        return selectedRack;
    }
}
