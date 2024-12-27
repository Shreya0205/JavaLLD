package code;

import code.expenseStrategy.ExpenseFactory;

import java.util.HashMap;
import java.util.List;

public class Splitwise {

    HashMap<String, User> users;
    HashMap<String, Group> groups;

    public Splitwise() {
        this.groups = new HashMap<>();
        this.users = new HashMap<>();
    }

    public User createUser(String name){
        User user = new User(name);
        this.users.put(name, user);
        return user;
    }

    public Group createGroup(String name, List<User> users){
        Group group = new Group(name, users);
        this.groups.put(name, group);
        return group;
    }

    public void addExpenseInGroup(Group group, Expense expense){

        if ( !validate(expense) ){
            System.out.println("Expense not valid");
            return;
        }

        this.groups.get(group.getName()).addExpense(expense);

    }

    private Boolean validate(Expense expense){
        return ExpenseFactory.getExpenseStrategy(expense).validateExpense(expense);
    }

    public void addExpenseToFriend(Expense expense){
        if ( !validate(expense) )
            throw new IllegalArgumentException("Expense not valid");

        ExpenseFactory.getExpenseStrategy(expense).addExpense(expense);
    }

    public void settleWithFriend(User creator, User friend, Double amount){
        System.out.println(creator.getName() + " settling with " + friend.getName() + " for amount: " + amount);
        creator.addExpenseForFriend(friend, -amount);
    }

    public void showExpenseBoard(User user){
        user.printExpenseBoard();
    }

}
