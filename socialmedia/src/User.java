import java.util.ArrayList;

public class User {
    String emailID;
    ArrayList<User> followers;
    ArrayList<User> followings;
    ArrayList<Item> items;

    public User(String emailID){
        this.emailID = emailID;
        this.followers = new ArrayList<>();
        this.followings = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    void addItem(Item item){
        this.items.add(item);
    }

    void followUser(User user){
        this.followings.add(user);
    }

    ArrayList<User> getFollowings(){
        return this.followings;
    }

    ArrayList<Item> getItems(){
        return this.items;
    }
}

