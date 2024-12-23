package Model;

import java.time.LocalDate;

public class Book {
    Integer  ID;
    String title;
    Author author;
    Subject subject;
    LocalDate publicationDate;

    public Book(Integer ID, String title, Author author, Subject subject, LocalDate publicationDate) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publicationDate = publicationDate;
    }

    public Integer getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
