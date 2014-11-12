package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Missaoui
 */
@Stateful
public class ProductManagementImpl implements ProductManagement {

    @PersistenceContext
    private EntityManager em;

    public void addItem(Item item) {
        DaoFactory.itemDAO.create(item, em);
    }

    public void addExemplaire(Exemplaire exemplaire) {
        DaoFactory.exemplaireDAO.create(exemplaire, em);
    }

    public List<Item> getAllItems() {
        return em.createQuery("select a from Item a").getResultList();
    
    }

    public List<Exemplaire> getAllExemplaires() {
        return em.createQuery("select a from Exemplaire a").getResultList();

    }
    
    public Exemplaire getDispExemplaire(List<Exemplaire> pExemplaires){
        for(Exemplaire ex : pExemplaires){
            if(ex.getEtat() != null && ex.getEtat().equals("Disponible")){
                return ex;
            }
        }
        return null;
    }

    public Item getItem(String reference) {

        return (Item) em.createNamedQuery("getItembyId").setParameter("reference", reference).
                getSingleResult();
    }

    public Exemplaire getExemplaire(String reference) {

        return (Exemplaire) em.createNamedQuery("getExemplairebyId").setParameter("reference", reference).
              getSingleResult();
    }
    public void deleteItem(Item item) {
     DaoFactory.itemDAO.delete(item, em);
    }
    
     public void deleteExemplaire(Exemplaire exemplaire) {
     DaoFactory.exemplaireDAO.delete(exemplaire, em);
    }

}
