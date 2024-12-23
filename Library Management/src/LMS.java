import Model.*;
import Services.FineService;
import Services.NotificationService;
import Services.PaymentService;
import Services.ReservationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LMS {

    CatalogService catalogService;
    HashMap<Book, Rack> racks;
    NotificationService notificationService;
    ReservationService reservationService;
    PaymentService paymentService;
    FineService fineService;

    public LMS(CatalogService catalogService, NotificationService notificationService, ReservationService reservationService,
               PaymentService paymentService, FineService fineService) {
        this.catalogService = new CatalogService();
        this.racks = new HashMap<>();
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.reservationService = reservationService;
        this.fineService = fineService;
    }

    public void addBook(Book book, Rack rack){
        this.racks.put(book, rack);
        this.catalogService.addBook(book);
    }

    public List<Book> searchByTitle(String title){
        return this.catalogService.searchByTitle(title);
    }

    public List<Book> searchByAuthor(Author author){
        return this.catalogService.searchByAuthor(author);
    }

    public List<Book> searchBySubject(Subject subject){
        return this.catalogService.searchBySubject(subject);
    }

    public Reservation issueBook(Book book, LocalDate startDate, Member member, Librarian librarian){
        return reservationService.createReservation(book, startDate, member, librarian);
    }

    public void renewBook(Reservation reservation){
        reservationService.renewReservation(reservation);
    }

    public Double returnBookAndFine(Reservation reservation){
        Double fine = fineService.calculateFine(reservation);
        reservation.markAsCompleted();
        return fine;
    }

    public void makePayment(double amount, PaymentType type, Reservation reservation){
       paymentService.makePayment(amount, type, reservation);
    }

    public void sendNotificationForLateBooks(){
        List<Reservation> reservations = reservationService.getLateReservation();

        for(Reservation reservation: reservations){
            notificationService.notifyUserOfLateFine(reservation.getMember(), " You are late for " + reservation.getBook().getTitle());
        }
    }

}
