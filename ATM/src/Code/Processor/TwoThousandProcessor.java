package Code.Processor;

import Code.ATM;

public class TwoThousandProcessor extends CashProcessor{

    public TwoThousandProcessor(CashProcessor cashProcessor) {
        super(cashProcessor);
    }

    public void process(ATM atm, Integer amount){

        Integer requiredDenominations = amount/2000;
        Integer balance = amount%2000;

        if(requiredDenominations <= atm.getTwoThousandNotes()){
            System.out.println("Number of 2000 rupees: " + requiredDenominations);
            atm.setTotalAmount(atm.getTotalAmount() - requiredDenominations*2000);
            atm.setTwoThousandNotes(atm.getTwoThousandNotes() - requiredDenominations);
        }
        else {
            System.out.println("Number of 2000 rupees: " + atm.getTwoThousandNotes());
            atm.setTotalAmount(atm.getTotalAmount() - atm.getTwoThousandNotes()*2000);
            atm.setTwoThousandNotes(0);
            balance += (requiredDenominations - atm.getTwoThousandNotes())*2000;
        }

        if (balance > 0){
            super.process(atm, balance);
        }

    }

    public boolean canProcess(ATM atm, Integer amount) {
        Integer requiredDenominations = amount / 2000;
        Integer balance = amount % 2000;

        if (requiredDenominations > atm.getFiveHundredNotes()) {
            balance += (requiredDenominations - atm.getFiveHundredNotes()) * 2000;
        }

        return (balance == 0) || (this.nextCashProcessor != null && super.canProcess(atm, balance));
    }

}
