package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Fournisseur;
import java.util.List;

/**
 *
 * @author Missaoui
 */
public interface ReStockManagement {

    public void addFournisseur(Fournisseur fournisseur);

    public List<Fournisseur> getAllFournisseurs();

    public void addCommmande(BonDeCommande commande);

    public List<BonDeCommande> getAllCommandes();

}
