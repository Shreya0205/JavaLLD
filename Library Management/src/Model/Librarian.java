package Model;

public class Librarian extends User {

    public Librarian(Integer id, String name, LibraryCard libraryCard) {
        super(id, name, UserType.librarian, libraryCard);
    }

}
