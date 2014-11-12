package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.*;
import java.util.List;


public interface ReservationManagement {

    public void addReservation(Reservation reservation);

    public List<Reservation> getAllReservations();
    
    public Reservation getReservation(String reference);
    public void updateReservation (Reservation reservation);
    public void deleteReservation (Reservation reservation);
}
