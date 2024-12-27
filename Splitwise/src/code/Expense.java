package code;

import code.split.Split;

import java.util.List;

public class Expense {
    User creator;
    Double totalAmount;
    List<Split> splitList;
    SplitType splitType;

    public Expense(User creator, Double totalAmount, List<Split> splitList, SplitType splitType) {
        this.creator = creator;
        this.totalAmount = totalAmount;
        this.splitList = splitList;
        this.splitType = splitType;
    }

    public User getCreator() {
        return creator;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public Boolean isSplitOfCreator(Split split){
        return this.creator.equals(split.getUser());
    }
}
