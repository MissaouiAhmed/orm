package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.User;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Missaoui
 */
@Stateful
public class UserManagementImpl implements UserManagement {

    @PersistenceContext
    private EntityManager em;

    public void addAdhrent(Adherent adherent) {
        DaoFactory.AdherentDAO.create(adherent, em);
    }

    public void addEmployee(Employee adherent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Adherent> getAllAdherent() {
        return em.createQuery("select a from Adherent a").getResultList();

    }

    public Adherent getAdherent(String id) {
        return (Adherent) em.createNamedQuery("getAdherentbyId").setParameter("id", id).
              getSingleResult();    }

    public String CheckType(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean CheckExist(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
