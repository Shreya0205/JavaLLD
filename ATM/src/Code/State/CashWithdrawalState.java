package Code.State;

import Code.ATM;
import Code.Card;
import Code.Processor.CashProcessor;
import Code.Processor.FiveHundredProcessor;
import Code.Processor.HundredProcessor;
import Code.Processor.TwoThousandProcessor;

public class CashWithdrawalState extends AtmState {

    private final ATM atm;

    public CashWithdrawalState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void withdrawCash(Integer amount){

        if(amount > this.atm.getTotalAmount()){
            System.out.println("Atm doesn't have enough cash");
            cancel();
            return;
        }

        CashProcessor cashProcessor = new TwoThousandProcessor(new FiveHundredProcessor(new HundredProcessor(null)));
        if (cashProcessor.canProcess(this.atm, amount)) {
            cashProcessor.process(this.atm, amount);
            this.atm.getCard().getBankAccount().withdrawBalance(amount);
        } else {
            System.out.println("ATM cannot dispense the requested amount with available denominations.");
        }

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
