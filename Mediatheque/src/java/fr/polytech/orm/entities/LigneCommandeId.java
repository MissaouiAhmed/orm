package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneCommandeId implements Serializable {

    private static final long serialVersionUID = 1L;
    private Item item;
    private BonDeCommande commande;

    public LigneCommandeId() {
    }

    public LigneCommandeId(Item item, BonDeCommande commande) {
        this.item = item;
        this.commande = commande;
    }
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "numeroCommande")
    public BonDeCommande getCommande() {
        return commande;
    }

    @ManyToOne(fetch = FetchType.EAGER)
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
