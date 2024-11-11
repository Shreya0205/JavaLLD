package Java.Models;

public class User {
    String name;
    Integer Id;

    public User(String name, Integer ID) {
        this.name = name;
        this.Id = Id;
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
}
