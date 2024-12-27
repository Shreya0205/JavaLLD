package code.expenseStrategy;

import code.Expense;
import code.split.EqualSplit;
import code.split.Split;
import java.util.ArrayList;

import java.util.List;

public class EqualStrategy implements ExpenseInterface {

    private static EqualStrategy equalStrategy;

    private EqualStrategy() {
    }

    public static EqualStrategy getInstance(){

        if(equalStrategy == null)
            equalStrategy = new EqualStrategy();
        return equalStrategy;
    }

    @Override
    public void addExpense(Expense expense) {

        List<Split> splitList = expense.getSplitList();
        List<EqualSplit> equalSplits = new ArrayList<>();

        for (Split split : splitList) {
            if (split instanceof EqualSplit) {
                equalSplits.add((EqualSplit) split);
            } else {
                throw new IllegalArgumentException("Found a split that is not an ExactSplit");
            }
        }

        for(EqualSplit split : equalSplits){
            if( ! split.getUser().equals(expense.getCreator()) ){
                split.getUser().addExpenseForFriend(expense.getCreator(),
                        expense.getTotalAmount()/equalSplits.size());
            }
        }
    }

    @Override
    public boolean validateExpense(Expense expense) {
        List<Split> splitList = expense.getSplitList();
        List<EqualSplit> equalSplits = new ArrayList<>();

        for (Split split : splitList) {
            if (split instanceof EqualSplit) {
                equalSplits.add((EqualSplit) split);
            } else {
                throw new IllegalArgumentException("Found a split that is not an ExactSplit");
            }
        }
        return true;
    }
}
