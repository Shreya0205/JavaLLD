import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Portal {

    HashMap<String, User> users;
    HashMap<Integer, Item> items;
    ArrayList<Item> postedItems;
    User loggedInUser;
    Integer nItems;
    Integer nComments;
    Following following;

    public Portal(){
        this.users = new HashMap<>();
        this.items = new HashMap<>();
        this.loggedInUser = null;
        this.nItems = 0;
        this.nComments = 0;
        this.following = new Following();
        this.postedItems = new ArrayList<>();
    }

    void register(String emailID){
        User user = new User(emailID);
        this.users.put(emailID, user);
    }

    void login(String emailID){
        User user = this.users.get(emailID);
        if(user == null){
            System.out.println("User does not exist");
            return;
        }
        this.loggedInUser = user;
        showNewsFeed();
    }

    void logout(){
        this.loggedInUser = null;
    }

    void postItem(String content){
        this.nItems++;
        Item item =  new Item(content, this.nItems, this.loggedInUser);
        this.items.put(nItems, item);
        this.loggedInUser.addItem(item);
        this.postedItems.add(item);
    }

    void addComment(Integer itemID, String content){
        Item item = this.items.get(itemID);
        this.nComments ++;

        Comment comment = new Comment(content, item, this.nComments);
        item.addComment(comment);
    }

    void follow(String emailID){
        User user = this.users.get(emailID);
        user.followUser(user);
        this.following.addFollowing(this.loggedInUser, user);
    }

    void upvote(Integer itemID){
        Item item = this.items.get(itemID);
        item.upvote();
    }

    void downvote(Integer itemID){
        Item item = this.items.get(itemID);
        item.downvote();
    }

    void showNewsFeed(){
        ArrayList<User> users = this.loggedInUser.getFollowings();
        NewsFeedStartegyContext newsFeedStartegyContext =  new NewsFeedStartegyContext(new FollowingFeedStrategy());
        newsFeedStartegyContext.showNewsFeed(users, this.postedItems);
    }
}
