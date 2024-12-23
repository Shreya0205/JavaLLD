package Model;

public class Rack {

    Integer id;
    Book book;

    public Rack(Integer id) {
        this.id = id;
    }

    public void assignBook(Book book){
        this.book = book;
    }

    public Book removeBook(Book book){
        Book returnedBook = this.book;
        this.book = null;
        return returnedBook;
    }

}
