package code.expenseStrategy;

import code.Expense;
import code.split.ExactSplit;
import code.split.PercentSplit;
import code.split.Split;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PercentStrategy implements ExpenseInterface {

    private static PercentStrategy percentStrategy;

    private PercentStrategy() {
    }

    public static PercentStrategy getInstance(){
        if(percentStrategy == null)
            percentStrategy = new PercentStrategy();
        return percentStrategy;
    }

    @Override
    public void addExpense(Expense expense) {
        List<Split> splitList = expense.getSplitList();
        List<PercentSplit> percentSplits = new ArrayList<>();

        for (Split split : splitList) {
            percentSplits.add((PercentSplit) split);
        }

        for(PercentSplit split : percentSplits){
            if( ! split.getUser().equals(expense.getCreator()) )
                split.getUser().addExpenseForFriend(expense.getCreator(),
                        split.getPercent()*expense.getTotalAmount()*.01);
        }

    }

    @Override
    public boolean validateExpense(Expense expense) {
        Double total = (double) 0.0;
        List<Split> splitList = expense.getSplitList();
        List<PercentSplit> percentSplits = new ArrayList<>();

        for (Split split : splitList) {
            if (split instanceof PercentSplit) {
                percentSplits.add((PercentSplit) split);
            } else {
                throw new IllegalArgumentException("Found a split that is not an ExactSplit");
            }
        }

        for(PercentSplit split : percentSplits){
            total += split.getPercent();
        }

        return total.equals(100.0);
    }
}
