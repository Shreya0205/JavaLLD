public class ReadyState implements State{

    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void collectCash(Integer cash){
        System.out.println("Collected cash: " + cash);
        this.vendingMachine.addTxnCash(cash);
    }

    public void dispenseChange(){
        this.vendingMachine.changeState(new DispenseChange(this.vendingMachine));
        this.vendingMachine.state.dispenseChange();
    }

    public void dispenseItem(){
        System.out.println("Cannot dispense item until change is dispensed");
    }

    public void cancelTxn(){
        this.vendingMachine.changeState(new CancelTxnState(this.vendingMachine));
        this.vendingMachine.state.cancelTxn();
    }

}
