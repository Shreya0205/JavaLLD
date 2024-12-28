package Code;

public abstract class User {

    Integer id;
    String name;
    String password;
    UserType userType;

    public User(Integer id, String name, String password, UserType userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
