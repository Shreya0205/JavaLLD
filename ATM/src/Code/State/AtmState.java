package Code.State;

import Code.ATM;
import Code.Card;

public abstract class AtmState {

    public void insertCard(Card card){
        System.out.println("something went wrong");
    }

    public void authenticateCard(Integer pin){
        System.out.println("something went wrong");
    }

    public void selectOperation(TransactionType transactionType){
        System.out.println("something went wrong");
    }

    public void withdrawCash(Integer amount){
        System.out.println("something went wrong");
    }

    public void checkBalance(){
        System.out.println("something went wrong");
    }

    public void ejectCard(){
        System.out.println("something went wrong");
    }

    public void cancel(){
        System.out.println("something went wrong");
    }

}
