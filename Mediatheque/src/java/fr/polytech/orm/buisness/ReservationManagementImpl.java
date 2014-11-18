package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.Reservation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
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

        return (Reservation) em.createNamedQuery("getReservationbyId").setParameter("numero", reference).
                getSingleResult();
    }

    public void updateReservation(Reservation reservation) {
        DaoFactory.reservationDAO.update(reservation, em);
    }

    public void deleteReservation(Reservation reservation) {
        DaoFactory.reservationDAO.delete(reservation, em);
    }

    public Reservation getReservationByItemAndAdherent(String itemReference, String adherentId) {
          List<Reservation> reservations=  em.createNamedQuery("getReservationbyItemAndAdherent").setParameter("reference", itemReference).setParameter("id", adherentId).
                getResultList();
          if(reservations.size() > 0){
             return reservations.get(0);
         }
         return null;
          
    }

}
