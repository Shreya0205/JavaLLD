public class DispenseItemState implements State{

    private VendingMachine vendingMachine;

    public DispenseItemState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void collectCash(Integer cash){
        System.out.println("Cannot collect cash in dispensing state");
    }

    public void dispenseChange(){
        System.out.println("Cannot change cash in dispensing state");
    }

    public void dispenseItem(){
        this.vendingMachine.inventory.sellProduct(this.vendingMachine.selectedProduct, this.vendingMachine.selectedQuantity);
        System.out.println("Dispensed " + this.vendingMachine.selectedQuantity + " items of " + this.vendingMachine.selectedProduct.name);
        this.vendingMachine.selectedQuantity = 0;
        this.vendingMachine.selectedCollectedCash = 0;
        this.vendingMachine.selectedProduct = null;
        this.vendingMachine.changeState(new ReadyState(this.vendingMachine));
    }

    public void cancelTxn(){
        System.out.println("Cannot collect cash in cancel state");
    }

}
