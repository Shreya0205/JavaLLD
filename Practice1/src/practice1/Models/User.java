package practice1.Models;

public class User {
    private static Integer counter = 0;
    private Integer userID;
    private String name;
    private String emailID;

    public User(String emailID, String name) {
        this.userID = counter;
        counter++;
        this.emailID = emailID;
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

}
