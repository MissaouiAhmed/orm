package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LigneCommande")
public class LigneCommande implements Serializable {

    private LigneCommandeId pk = new LigneCommandeId();
    private int quantité;

    public LigneCommande() {
    }

    public LigneCommande(LigneCommandeId pk, int quantité) {
        this.quantité = quantité;
        this.pk = pk;
    }

    @Id
    public LigneCommandeId getPk() {
        return pk;
    }

    public void setPk(LigneCommandeId pk) {
        this.pk = pk;
    }

    @Transient
    public Item getItem() {
        return getPk().getItem();
    }

    public void setItem(Item item) {
        getPk().setItem(item);
    }

    public void setCommande(BonDeCommande commande) {
        getPk().setCommande(commande);
    }

    @Transient
    public BonDeCommande getCommande() {
        return getPk().getCommande();
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

}
