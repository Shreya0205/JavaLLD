package code.expenseStrategy;

import code.Expense;
import code.SplitType;

public class ExpenseFactory {

    public static ExpenseInterface getExpenseStrategy(Expense expense){

        if(SplitType.exact == expense.getSplitType())
            return ExactStrategy.getInstance();
        else if(SplitType.equal == expense.getSplitType())
            return EqualStrategy.getInstance();
        else
            return PercentStrategy.getInstance();

    }
}
