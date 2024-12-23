package Model;

public abstract class User {
    Integer id;
    String name;
    UserType userType;
    LibraryCard libraryCard;

    public User(Integer id, String name, UserType userType, LibraryCard libraryCard) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.libraryCard = libraryCard;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }
}
