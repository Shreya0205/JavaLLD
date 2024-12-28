package Code;

public class Review {
    Integer id;
    User user;
    Integer rating;
    String comment;

    public Review(Integer id, User user, String comment, Integer rating) {
        this.id = id;
        this.user = user;
        this.comment = comment;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
