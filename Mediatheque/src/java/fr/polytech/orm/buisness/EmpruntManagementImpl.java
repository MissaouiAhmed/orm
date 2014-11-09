package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Emprunt;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Missaoui
 */
@Stateful
public class EmpruntManagementImpl implements EmpruntManagement {

    @PersistenceContext
    private EntityManager em;

    public void addEmprunt(Emprunt emprunt) {
        DaoFactory.empruntDAO.create(emprunt, em);
    }

    public List<Emprunt> getAllEmprunt() {
        return em.createQuery("select a from Emprunt a").getResultList();

    }

}
