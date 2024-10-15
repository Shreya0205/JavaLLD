import java.util.ArrayList;

public class NewsFeedStartegyContext {
    NewsFeedStartegy newsFeedStartegy;

    public NewsFeedStartegyContext(NewsFeedStartegy newsFeedStartegy){
        this.newsFeedStartegy = newsFeedStartegy;
    }

    void showNewsFeed(ArrayList<User> users, ArrayList<Item> items){
        this.newsFeedStartegy.showNewsFeed(users, items);
    }
}
