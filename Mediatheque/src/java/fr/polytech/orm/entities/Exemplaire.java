package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Missaoui
 */
@Entity
@Table(name = "Exemplaire")
//@NamedQueries({
//    @NamedQuery(
//    name="getAllExemplairesOfItem",
//    query="SELECT l FROM Exemplaire l"+
//          "WHERE l.item.reference = :reference " )
//})
public class Exemplaire implements Serializable {

    @Id
    @Column(name = "REFERENCE_EXEMPLAIRE", nullable = false)
    private String reference;

    @Column(name = "NOMBRE_EMPRUNT")
    private int nb_emprunt;

    @Column(name = "ETAT_EXEMPLAIRE")
    private String etat;

    @ManyToOne
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    @OneToMany(cascade=ALL, mappedBy="exemplaire")
    private List<Emprunt> emprunts;

    public List<Emprunt> getEmprunts() {
	return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
	this.emprunts = emprunts;
    }
    public Exemplaire() {
    }

    public Exemplaire(String reference, int nb_emprunt, String etat) {
	this.reference = reference;
	this.nb_emprunt = nb_emprunt;
	this.etat = etat;
    }

    public String getEtat() {
	return etat;
    }

    public int getNb_emprunt() {
	return nb_emprunt;
    }

    public String getReference() {
	return reference;
    }

    public void setEtat(String etat) {
	this.etat = etat;
    }

    public void setNb_emprunt(int nb_emprunt) {
	this.nb_emprunt = nb_emprunt;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

}
