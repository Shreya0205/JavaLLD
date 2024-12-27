import code.*;
import code.split.EqualSplit;
import code.split.ExactSplit;
import code.split.PercentSplit;
import code.split.Split;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Splitwise splitwise = new Splitwise();

        User shreya = splitwise.createUser("Shreya");
        User sonal = splitwise.createUser("Sonal");
        User asha = splitwise.createUser("Asha");

        Group trip = splitwise.createGroup("trip", Arrays.asList(shreya, sonal, asha));

        Split split1 = new ExactSplit(shreya, 100.0);
        Split split2 = new ExactSplit(sonal, 200.0);
        Split split3 = new ExactSplit(asha, 300.0);
        splitwise.addExpenseInGroup(trip, new Expense(shreya, 600.0, Arrays.asList(split1, split2, split3), SplitType.exact));

        Split split4 = new EqualSplit(shreya);
        Split split5 = new EqualSplit(sonal);
        Split split6 = new EqualSplit(asha);
        splitwise.addExpenseInGroup(trip, new Expense(sonal, 900.0, Arrays.asList(split4, split5, split6), SplitType.equal));

        Split split7 = new PercentSplit(shreya, 10.0);
        Split split8 = new PercentSplit(sonal, 50.0);
        Split split9 = new PercentSplit(asha, 40.0);
        splitwise.addExpenseInGroup(trip, new Expense(asha, 900.0, Arrays.asList(split7, split8, split9), SplitType.percentage));

        splitwise.showExpenseBoard(shreya);
        splitwise.showExpenseBoard(asha);
        splitwise.showExpenseBoard(sonal);

        splitwise.settleWithFriend(shreya, sonal, 300.0);
        splitwise.showExpenseBoard(shreya);

    }
}