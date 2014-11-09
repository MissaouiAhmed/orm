package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.*;
import java.util.List;

/**
 *
 * @author Missaoui
 */
public interface ReservationManagement {

    public void addReservation(Reservation reservation);

    public List<Reservation> getAllReservations();

}
