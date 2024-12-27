package code;

public class User {

    String name;
    ExpenseBoard expenseBoard;

    public User(String name) {
        this.name = name;
        this.expenseBoard = new ExpenseBoard();
    }

    public void addExpenseForFriend(User user, Double amount){
        this.expenseBoard.addAmountToUser(user, amount);
    }

    public void printExpenseBoard(){
        System.out.println(this.name + " expenses: ");
        this.expenseBoard.toString();
        System.out.println();
    }

    public String getName() {
        return name;
    }
}
