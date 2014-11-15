package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Souhait;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SouhaitManagementImpl implements SouhaitManagement {

    @PersistenceContext
    private EntityManager em;

    public List<Souhait> getAllSouhaits() {
        return em.createQuery("select a from Souhait a").getResultList();
    }
    
    public void addSouhait(Souhait souhait) {
        DaoFactory.SouhaitDAO.create(souhait, em);
    }

    public void updateSouhait(Souhait souhait) {
        DaoFactory.SouhaitDAO.update(souhait, em);
    }

    public void deleteSouhait(Souhait souhait) {
        DaoFactory.SouhaitDAO.delete(souhait, em);
    }

}
