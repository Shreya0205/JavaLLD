package Java.models;

public class User {
    String name;
    Integer Id;
    UserType type;

    public User(String name, Integer ID, UserType type) {
        this.name = name;
        this.Id = Id;
        this.type = type;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", type=" + type.toString() +
                '}';
    }
}
