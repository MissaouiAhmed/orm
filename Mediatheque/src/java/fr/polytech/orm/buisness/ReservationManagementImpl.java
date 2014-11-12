package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.Reservation;
import fr.polytech.orm.entities.ReservationStatus;
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
    public Reservation getReservation(String reference) {

        return (Reservation) em.createNamedQuery("getReservationbyId").setParameter("reference", reference).
                getSingleResult();
    }

    

    public void updateReservation(Reservation reservation) {
         DaoFactory.reservationDAO.update(reservation, em);
           }

      public void deleteReservation(Reservation reservation) {
         DaoFactory.reservationDAO.delete(reservation, em);
           }

    
}