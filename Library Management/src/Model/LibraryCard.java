package Model;

import java.time.LocalDate;

public class LibraryCard {
    Integer id;
    LocalDate issueDate;

    public LibraryCard(LocalDate issueDate, Integer id) {
        this.issueDate = issueDate;
        this.id = id;
    }

}
