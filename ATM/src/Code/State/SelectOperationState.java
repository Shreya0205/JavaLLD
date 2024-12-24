package Code.State;

import Code.ATM;

public class SelectOperationState extends AtmState{

    private ATM atm;

    public SelectOperationState(ATM atm){
        this.atm = atm;
    }

    public void selectOperation(TransactionType transactionType){
        if (transactionType == TransactionType.withdrawal)
            this.atm.setAtmState(new CashWithdrawalState(this.atm));
        else
            this.atm.setAtmState(new CheckBalanceState(this.atm));
    }

    @Override
    public void ejectCard(){
        System.out.println("take your card");

    }

    @Override
    public void cancel(){
        ejectCard();
        this.atm.setAtmState(new IdleState(this.atm));
    }


}
