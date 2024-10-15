import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FollowingFeedStrategy implements NewsFeedStartegy{

    ArrayList<Item> SortItems(ArrayList<Item> items){
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.score != o2.score) {
                    return Integer.compare(o2.score, o1.score);  // Reverse order for descending
                }

                // Compare by number of comments in descending order (higher ncomments first)
                if (o1.ncomments != o2.ncomments) {
                    return Integer.compare(o2.ncomments, o1.ncomments);  // Reverse order for descending
                }

                // Compare by timestamp in descending order (more recent first)
                return o2.timestamp.compareTo(o1.timestamp);
            }
        });

        return items;
    }

    void display(ArrayList<Item> items){
        for(int i=0;i<items.size();i++){
            System.out.println("ID: " + items.get(i).ItemID );
            System.out.println(items.get(i).upvote + " upvotes, " + items.get(i).downvote + " downvotes");
            System.out.println("Posted by: " + items.get(i).user.emailID);
            System.out.println("Content: " + items.get(i).content);
            System.out.println("Timestamp: " + items.get(i).timestamp);
            System.out.println();
            ArrayList<Comment> comments = items.get(i).comments;

            for ( int j=0; j<comments.size() ; j++){
                System.out.println("Comment ID: " + comments.get(j).commentID );
                System.out.println("Content: " + comments.get(j).content);
                System.out.println("Timestamp: " + comments.get(j).timestamp);
                System.out.println();
            }

        }
    }

    public void showNewsFeed(ArrayList<User> users, ArrayList<Item> items){
        ArrayList<Item> followedItems = new ArrayList<>();
        ArrayList<Item> notFollowedItems = new ArrayList<>();

        for(int i=0;i<items.size();i++){
            int present = 0;

            for(int j = 0; j<users.size(); j++){
                if( items.get(i).user == users.get(j)) {
                    followedItems.add(items.get(i));
                    present = 1;
                    break;
                }
            }

            if(present==0){
                notFollowedItems.add(items.get(i));
            }

        }

        ArrayList<Item> ditems = SortItems(followedItems);
        display(ditems);

        ditems = SortItems(notFollowedItems);
        display(ditems);

    };
}
