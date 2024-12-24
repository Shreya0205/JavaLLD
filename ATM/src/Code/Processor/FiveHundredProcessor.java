package Code.Processor;

import Code.ATM;

public class FiveHundredProcessor extends CashProcessor{

    public FiveHundredProcessor(CashProcessor cashProcessor) {
        super(cashProcessor);
    }

    public void process(ATM atm, Integer amount){

        Integer requiredDenominations = amount/500;
        Integer balance = amount%500;

        if(requiredDenominations <= atm.getFiveHundredNotes()){
            System.out.println("Number of 500 rupees: " + requiredDenominations);
            atm.setTotalAmount(atm.getTotalAmount() - requiredDenominations*500);
            atm.setFiveHundredNotes(atm.getFiveHundredNotes() - requiredDenominations);
        }
        else {
            System.out.println("Number of 500 rupees: " + atm.getFiveHundredNotes());
            atm.setTotalAmount(atm.getTotalAmount() - atm.getFiveHundredNotes()*500);
            atm.setFiveHundredNotes(0);
            balance += (requiredDenominations - atm.getFiveHundredNotes())*500;
        }

        if (balance > 0){
            super.process(atm, balance);
        }

    }

    public boolean canProcess(ATM atm, Integer amount) {
        Integer requiredDenominations = amount / 500;
        Integer balance = amount % 500;

        if (requiredDenominations > atm.getFiveHundredNotes()) {
            balance += (requiredDenominations - atm.getFiveHundredNotes()) * 500;
        }

        return (balance == 0) || (this.nextCashProcessor != null && super.canProcess(atm, balance));
    }
}
