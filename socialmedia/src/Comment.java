import java.time.LocalDateTime;

public class Comment {
    Integer commentID;
    Item item;
    String content;
    LocalDateTime timestamp;

    public Comment(String content, Item item, Integer commentID){
        this.commentID = commentID;
        this.timestamp = LocalDateTime.now();
        this.item = item;
        this.content = content;
    }

}
