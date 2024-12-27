package code.expenseStrategy;

import code.Expense;

public interface ExpenseInterface {
    public void addExpense(Expense expense);
    public boolean validateExpense(Expense expense);
}
