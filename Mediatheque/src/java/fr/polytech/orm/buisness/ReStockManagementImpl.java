package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Fournisseur;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Missaoui
 */
@Stateful
public class ReStockManagementImpl implements ReStockManagement {

    @PersistenceContext
    private EntityManager em;

    public void addFournisseur(Fournisseur fournisseur) {
        DaoFactory.fournisseurDAO.create(fournisseur, em);
    }

    public List<Fournisseur> getAllFournisseurs() {
        return em.createQuery("select a From Fournisseur a").getResultList();
    }

    public void addCommmande(BonDeCommande commande) {
        DaoFactory.bonDeCommandeDAO.create(commande, em);

    }

    public List<BonDeCommande> getAllCommandes() {
        return em.createQuery("select a From BonDeCommande a").getResultList();
    }

}
