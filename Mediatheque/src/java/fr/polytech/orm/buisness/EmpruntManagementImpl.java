package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Emprunt;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmpruntManagementImpl implements EmpruntManagement {

    @PersistenceContext
    private EntityManager em;

    public void addEmprunt(Emprunt emprunt) {
        DaoFactory.empruntDAO.create(emprunt, em);
    }

    public List<Emprunt> getAllEmprunt() {
        return em.createNamedQuery("getAllEmprunts").getResultList();
    }

    public Emprunt getEmprunt(String reference) {

        return (Emprunt) em.createNamedQuery("getEmpruntbyId")
                .setParameter("numero", reference).getSingleResult();
    }

    public void updateEmprunt(Emprunt emprunt) {
        DaoFactory.empruntDAO.update(emprunt, em);
    }

    public void deleteEmprunt(Emprunt emprunt) {
        DaoFactory.empruntDAO.delete(emprunt, em);
    }

    public Emprunt getEmpruntbyItemAndAdherent(String itemReference, String adherentId) {
         List<Emprunt> emprunts= em.createNamedQuery("getEmpruntbyItemAndAdherent").setParameter("reference", itemReference).setParameter("id", adherentId).
                getResultList();
         if(emprunts.size() > 0){
             return emprunts.get(0);
         }
         return null;
    }
}
