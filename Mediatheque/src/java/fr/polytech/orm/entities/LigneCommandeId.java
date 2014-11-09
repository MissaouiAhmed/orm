
package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Molka
 */

@Embeddable
public class LigneCommandeId implements Serializable{
    private static final long serialVersionUID = 1L;
    private Item item;
    private BonDeCommande commande;

    public LigneCommandeId() {
    }

    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numeroCommande")
    public BonDeCommande getCommande() {
	return commande;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference")
    public Item getItem() {
	return item;
    }

    public void setCommande(BonDeCommande commande) {
	this.commande = commande;
    }

    public void setItem(Item item) {
	this.item = item;
    }

   
    
    
    
    
    
    
}
