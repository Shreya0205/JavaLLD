package Model;

import java.time.LocalDate;

public class Reservation {
    Integer id;
    Member member;
    Librarian librarian;
    LocalDate startDate;
    LocalDate dueDate;
    LocalDate returnDate;
    Book book;
    ReservationStatus reservationStatus;

    public Reservation(Integer id, Member member, Librarian librarian, LocalDate startDate, Book book) {
        this.id = id;
        this.member = member;
        this.librarian = librarian;
        this.startDate = startDate;
        this.dueDate = this.startDate.plusDays(15);
        this.returnDate = null;
        this.book = book;
        this.reservationStatus = ReservationStatus.active;
    }

    public Member getMember() {
        return member;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void markAsLate(){
        this.reservationStatus = ReservationStatus.late;
    }

    public void markAsCompleted(){
        this.reservationStatus = ReservationStatus.completed;
        this.setReturnDate(LocalDate.now());
    }

    private void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isLate(){
        return this.reservationStatus == ReservationStatus.active && LocalDate.now().isAfter(this.dueDate);
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
