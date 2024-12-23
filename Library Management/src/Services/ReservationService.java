package Services;

import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationService {

    Map<Book, List<Reservation>> reservations;
    AtomicInteger id;
    Integer issueDays = 15;

    public ReservationService(Integer issueDays) {
        this.reservations = new ConcurrentHashMap<>();
        this.id = new AtomicInteger(1);
        this.issueDays = issueDays;
    }

    public Reservation createReservation(Book book, LocalDate startDate, Member member, Librarian librarian){

        Objects.requireNonNull(book, "Book cannot be null");
        Objects.requireNonNull(member, "Member cannot be null");
        Objects.requireNonNull(librarian, "Librarian cannot be null");

        if(isBookAvailable(book, startDate)){
            Reservation reservation = new Reservation(this.id.getAndIncrement(), member, librarian, startDate, book);
            this.reservations.computeIfAbsent(book, k-> new ArrayList<>()).add(reservation);
            return reservation;
        }
        else{
            throw new IllegalStateException("Book is not available.");
        }
    }

    private boolean isBookAvailable(Book book, LocalDate startDate){
        for ( Reservation reservation: this.reservations.get(book) ){
            if( reservation.getReservationStatus() == ReservationStatus.active
                    && reservation.getDueDate().isBefore(startDate.plusDays(15)) )
                return false;
        }
        return true;
    }

    public void completeReservation(Reservation reservation){
        reservation.markAsCompleted();
    }

    public List<Reservation> getLateReservation(){

        List<Reservation> reservationList = new ArrayList<>();
        for( Book book : this.reservations.keySet() ){
            for( Reservation reservation: this.reservations.get(book) ){
                if ( reservation.isLate() )
                    reservationList.add(reservation);
            }
        }

        return reservationList;

    }

    public void renewReservation(Reservation reservation) {
        if (reservation.getReservationStatus() != ReservationStatus.active) {
            throw new IllegalStateException("Cannot renew a completed reservation.");
        }
        reservation.setDueDate(LocalDate.now().plusDays(issueDays));
    }

}
