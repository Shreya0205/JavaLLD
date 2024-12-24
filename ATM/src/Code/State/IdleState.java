package Code.State;

import Code.ATM;
import Code.Card;

public class IdleState extends AtmState {

    private ATM atm;

    public IdleState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card){
        this.atm.setCard(card);
        this.atm.setAtmState(new CardInsertedState(this.atm));
    }

    @Override
    public void ejectCard(){
    }

    @Override
    public void cancel(){

    }

}
