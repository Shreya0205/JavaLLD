package Code.Processor;

import Code.ATM;

public abstract class CashProcessor {

    CashProcessor nextCashProcessor;

    public CashProcessor(CashProcessor cashProcessor) {
        this.nextCashProcessor = cashProcessor;
    }

    public void process(ATM atm, Integer amount){
        this.nextCashProcessor.process(atm, amount);
    }

    public boolean canProcess(ATM atm, Integer amount) {
        return this.nextCashProcessor.canProcess(atm, amount);
    }
}
