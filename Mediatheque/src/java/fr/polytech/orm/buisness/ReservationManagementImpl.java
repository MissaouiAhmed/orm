package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Reservation;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Missaoui
 */
@Stateful
public class ReservationManagementImpl implements ReservationManagement {

    @PersistenceContext
    private EntityManager em;

    public void addReservation(Reservation reservation) {
        DaoFactory.reservationDAO.create(reservation, em);
    }

    public List<Reservation> getAllReservations() {
        return em.createQuery("select a FROM Reservation a").getResultList();

    }

}
