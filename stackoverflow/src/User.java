import java.util.Map;

public class User {

    Integer UserID;
    String UserName;
    Integer Score;

    public User(Integer UserID, String UserName){
        this.UserID = UserID;
        this.UserName = UserName;
    }

    public void addAchievementScore(){
        this.Score = this.Score + 1;
    }

}
