import java.util.HashMap;

public class Following {
    HashMap<User, User> followings;

    public Following(){
        this.followings =  new HashMap<>();
    }

    void addFollowing(User user, User following){
        this.followings.put(user, following);
    }
}
