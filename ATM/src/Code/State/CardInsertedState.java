package Code.State;

import Code.ATM;
import Code.Card;

import java.util.Objects;

public class CardInsertedState extends AtmState {

    private final ATM atm;

    public CardInsertedState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void authenticateCard(Integer pin){

        if(this.atm.getCard().isCorrectPin(pin)){
            this.atm.setAtmState(new SelectOperationState(this.atm));
            return;
        }

        System.out.println("wrong pin entered");
        cancel();
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
