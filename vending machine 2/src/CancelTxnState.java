public class CancelTxnState implements State{
    private VendingMachine vendingMachine;

    public CancelTxnState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void collectCash(Integer cash){
        System.out.println("Cannot collect cash in cancel state");
    }

    public void dispenseChange(){
        System.out.println("Cannot dispense change in cancel state");
    }

    public void dispenseItem(){
        System.out.println("Cannot dispense item in cancel state");
    }

    public void cancelTxn(){
        System.out.println("Cancellling txn for product " +  this.vendingMachine.selectedProduct.name);
        this.vendingMachine.selectedCollectedCash = 0;
        this.vendingMachine.changeState(new ReadyState(this.vendingMachine));
    }
}
