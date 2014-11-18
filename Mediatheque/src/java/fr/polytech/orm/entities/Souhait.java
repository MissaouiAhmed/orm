package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Souhait")
@NamedQueries({
    @NamedQuery(
            name = "getSouhaitOfAdhrent",
            query = "SELECT s FROM Souhait s WHERE s.adherent.id = :id "),
    @NamedQuery(
            name = "getAllSouhaits",
            query = "SELECT s FROM Souhait s"),
    @NamedQuery(
            name = "getSouhaitById",
            query = "SELECT s FROM Souhait s WHERE s.numero = :numero")
})
public class Souhait implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
   private String numero;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_TYPE")
    private String itemType;

    @ManyToOne(fetch = FetchType.EAGER)
    private Adherent adherent;

    public Souhait(String numero, String description, Adherent adherent) {
        this.numero = numero;
        this.description = description;
        this.adherent = adherent;
    }

    public Souhait() {
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
