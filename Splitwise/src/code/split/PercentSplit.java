package code.split;

import code.User;

public class PercentSplit extends Split {

    Double percent;

    public PercentSplit(User user, Double percent) {
        super(user);
        this.percent = percent;
    }

    public Double getPercent() {
        return percent;
    }
}
