package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LigneCommande")
@AssociationOverrides({
    @AssociationOverride(name = "pk.commandeitem", 
            joinColumns = @JoinColumn(name = "reference")),
    @AssociationOverride(name = "pk.Commandebondecommde",
            joinColumns = @JoinColumn(name = "numero_commande"))
})
public class LigneCommande implements Serializable {

    private LigneCommandeId pk = new LigneCommandeId();
    private int quantité;

    @EmbeddedId
    public LigneCommandeId getPk() {
        return pk;
    }

    public void setPk(LigneCommandeId pk) {
        this.pk = pk;
    }

    @Transient
    public Item getCommandeitem() {
        return getPk().getCommandeitem();
    }

    public void setCommandeitem(Item commandeitem) {
        getPk().setCommandeitem(commandeitem);
    }

    @Transient
    public BonDeCommande getCommandebondecommde() {
        return getPk().getCommandebondecommde();
    }

    public void setCommandebondecommde(BonDeCommande Commandebondecommde) {
        getPk().setCommandebondecommde(Commandebondecommde);
    }

    @Column(name = "QUANTITE")
    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

}
