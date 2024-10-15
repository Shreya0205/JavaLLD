public class DispenseChange implements State{
    private VendingMachine vendingMachine;

    public DispenseChange(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void collectCash(Integer cash){
        System.out.println("Cannot collect cash in cancel state");
    }

    public void dispenseChange(){
        Integer change = this.vendingMachine.selectedCollectedCash - this.vendingMachine.selectedQuantity * this.vendingMachine.selectedProduct.getPrice();
        System.out.println("Dispensing Change: " +  change);
        this.vendingMachine.addCash(this.vendingMachine.selectedProduct.getPrice());
    }

    public void dispenseItem(){
        this.vendingMachine.changeState(new DispenseItemState(this.vendingMachine));
        this.vendingMachine.dispenseItem();
    }

    public void cancelTxn(){
        System.out.println("Cannot cancel txn when cash is collected");
    }
}
