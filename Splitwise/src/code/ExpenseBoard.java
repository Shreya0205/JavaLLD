package code;

import java.util.HashMap;
import java.util.Map;

public class ExpenseBoard {

    HashMap<User, Double> amounts;

    public ExpenseBoard() {
        this.amounts = new HashMap<>();
    }

    public void addAmountToUser(User user, Double amount) {
        this.amounts.put(user, this.amounts.getOrDefault(user, 0.0) + amount);
        if ( this.amounts.get(user).equals(0.0) ){
            this.amounts.remove(user);
        }
    }

    @Override
    public String toString() {

        for ( Map.Entry<User, Double> entrySet: this.amounts.entrySet() ) {
            System.out.println("You owe " + entrySet.getKey().getName() + " : " +  entrySet.getValue());
        }

        return "";
    }
}
