import java.time.LocalDateTime;
import java.util.ArrayList;

public class Item {
    Integer ItemID;
    Integer upvote;
    Integer downvote;
    Integer score;
    Integer ncomments;
    String content;
    LocalDateTime timestamp;
    ArrayList<Comment> comments;
    User user;

    public Item(String content, Integer itemID, User user){
        this.user = user;
        this.content = content;
        this.ItemID = itemID;
        this.downvote = 0;
        this.upvote = 0;
        this.score = 0;
        this.ncomments = 0;
        this.timestamp = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
        this.ncomments++;
    }

    public void upvote(){
        this.upvote++;
        this.score = this.upvote - this.downvote;
    }

    public void downvote(){
        this.downvote++;
        this.score = this.upvote - this.downvote;
    }
}
