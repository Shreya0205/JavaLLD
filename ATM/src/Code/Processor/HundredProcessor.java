package Code.Processor;

import Code.ATM;

public class HundredProcessor extends CashProcessor{

    public HundredProcessor(CashProcessor cashProcessor) {
        super(cashProcessor);
    }

    public void process(ATM atm, Integer amount){

        Integer requiredDenominations = amount/100;
        Integer balance = amount%100;

        if(requiredDenominations <= atm.getHundredNotes()){
            System.out.println("Number of 100 rupees: " + requiredDenominations);
            atm.setTotalAmount(atm.getTotalAmount() - requiredDenominations*100);
            atm.setHundredNotes(atm.getHundredNotes() - requiredDenominations);
        }
        else {
            System.out.println("Number of 100 rupees: " + atm.getHundredNotes());
            atm.setTotalAmount(atm.getTotalAmount() - atm.getHundredNotes()*500);
            atm.setHundredNotes(0);
            balance += (requiredDenominations - atm.getHundredNotes())*100;
        }

        if (balance > 0){
            super.process(atm, balance);
        }

    }

    public boolean canProcess(ATM atm, Integer amount) {
        Integer requiredDenominations = amount / 100;
        Integer balance = amount % 100;

        if (requiredDenominations > atm.getFiveHundredNotes()) {
            balance += (requiredDenominations - atm.getFiveHundredNotes()) * 100;
        }

        return (balance == 0) || (this.nextCashProcessor != null && super.canProcess(atm, balance));
    }


}
