package Java.models;

public class User {
    Integer Id;
    String name;
    String profession;

    public User(Integer ID, String name, String profession) {
        this.Id = Id;
        this.name = name;
        this.profession = profession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
