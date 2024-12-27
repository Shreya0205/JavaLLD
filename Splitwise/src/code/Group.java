package code;

import code.expenseStrategy.ExpenseFactory;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    List<User> participants;
    List<Expense> expenseList;

    public Group(String name, List<User> participants) {
        this.name = name;
        this.expenseList = new ArrayList<>();
        this.participants = participants;
    }

    public void addExpense(Expense expense){
        this.expenseList.add(expense);
        ExpenseFactory.getExpenseStrategy(expense).addExpense(expense);
    }

    public String getName() {
        return name;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }
}
