package code.split;

import code.User;

public class ExactSplit extends Split {

    Double amount;

    public ExactSplit(User user, Double amount) {
        super(user);
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
