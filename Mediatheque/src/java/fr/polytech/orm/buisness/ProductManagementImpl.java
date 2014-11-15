package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
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
        return em.createNamedQuery("getAllItems").getResultList();

    }

    public List<Exemplaire> getAllExemplaires() {
        return em.createNamedQuery("getALLExemplaires").getResultList();

    }

    public Exemplaire getDispExemplaire(List<Exemplaire> pExemplaires) {
        for (Exemplaire ex : pExemplaires) {
            if (ex.getEtat() != null && ex.getEtat().equals("Disponible")) {
                return ex;
            }
        }
        return null;
    }

    public Item getItem(String reference) {

        return (Item) em.createNamedQuery("getItembyId")
                .setParameter("reference", reference).getSingleResult();
    }

    public Exemplaire getExemplaire(String reference) {

        return (Exemplaire) em.createNamedQuery("getExemplairebyId")
                .setParameter("reference", reference).getSingleResult();
    }

    public void deleteItem(Item item) {
        DaoFactory.itemDAO.delete(item, em);
    }

    public void deleteExemplaire(Exemplaire exemplaire) {
        DaoFactory.exemplaireDAO.delete(exemplaire, em);
    }
    
     public void updateExemplaire(Exemplaire exemplaire) {
        DaoFactory.exemplaireDAO.update(exemplaire, em);
    }

    public List<Item> getItemsbyAuteur(String auteur) {
        return em.createNamedQuery("getItemsbyAuteur").setParameter("auteur", "%" + auteur + "%").getResultList();
    }

    public List<Item> getItemsbyTitre(String titre) {
        return (List<Item>) em.createNamedQuery("getItemsbyTitre").setParameter("titre", "%" + titre + "%").getResultList();
    }

    public List<Item> getItemsbyTitreAndAuteur(String titre, String auteur) {
        return em.createNamedQuery("getItemsbyTitreAndAuteur").setParameter("titre", "%" + titre + "%").setParameter("auteur", "%" + auteur + "%").getResultList();
    }

}
