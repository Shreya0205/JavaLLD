package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatalogService {

    HashMap<String, List<Book>> titles;
    HashMap<Author, List<Book>> authors;
    HashMap<Subject, List<Book>> subjects;

    public CatalogService() {
        this.authors = new HashMap<>();
        this.subjects = new HashMap<>();
        this.titles = new HashMap<>();
    }

    public void addBook(Book book){
        this.authors.computeIfAbsent(book.getAuthor(), k-> new ArrayList<>()).add(book);
        this.titles.computeIfAbsent(book.getTitle(), k-> new ArrayList<>()).add(book);
        this.subjects.computeIfAbsent(book.getSubject(), k-> new ArrayList<>()).add(book);
    }

    public void removeBook(Book book){
        this.authors.remove(book.getAuthor());
        this.titles.remove(book.getTitle());
        this.subjects.remove(book.getSubject());
    }

    public List<Book> searchByTitle(String title){
        return this.titles.get(title);
    }

    public List<Book> searchByAuthor(Author author){
        return this.authors.get(author);
    }

    public List<Book> searchBySubject(Subject subject){
        return this.subjects.get(subject);
    }

}
