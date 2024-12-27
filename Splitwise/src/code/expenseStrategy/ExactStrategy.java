package code.expenseStrategy;

import code.Expense;
import code.split.ExactSplit;
import code.split.Split;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExactStrategy implements ExpenseInterface {

    private static ExactStrategy exactStrategy;

    private ExactStrategy() {
    }

    public static ExactStrategy getInstance(){
        if(exactStrategy == null)
            exactStrategy = new ExactStrategy();
        return exactStrategy;
    }

    @Override
    public void addExpense(Expense expense) {

        List<Split> splitList = expense.getSplitList();
        List<ExactSplit> exactSplits = new ArrayList<>();

        for (Split split : splitList) {
            exactSplits.add((ExactSplit) split);
        }

        for(ExactSplit split : exactSplits){
            if(!split.getUser().getName().equals(expense.getCreator().getName())){
                split.getUser().addExpenseForFriend(expense.getCreator(), split.getAmount());
            }
        }
    }

    @Override
    public boolean validateExpense(Expense expense) {

        Double total = 0.0;

        List<Split> splitList = expense.getSplitList();
        List<ExactSplit> exactSplits = new ArrayList<>();

        for (Split split : splitList) {
            if (split instanceof ExactSplit) {
                exactSplits.add((ExactSplit) split);
            } else {
                throw new IllegalArgumentException("Found a split that is not an ExactSplit");
            }
        }

        for(ExactSplit split : exactSplits){
            total += split.getAmount();
        }

        return total.equals(expense.getTotalAmount());
    }
}
