package code.split;

import code.User;

public abstract class Split {
    User user;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
