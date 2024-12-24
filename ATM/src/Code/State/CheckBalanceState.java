package Code.State;

import Code.ATM;

public class CheckBalanceState extends AtmState {

    private final ATM atm;

    public CheckBalanceState(ATM atm){
        this.atm = atm;
    }

    public void checkBalance(){
        System.out.println("Your balance is: " + this.atm.getCard().getBankAccount().getBalance());
    }

    @Override
    public void ejectCard(){
        this.atm.setCard(null);
        System.out.println("take your card");
    }

    @Override
    public void cancel(){
        ejectCard();
        this.atm.setAtmState(new IdleState(this.atm));
    }

}
