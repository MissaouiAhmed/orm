package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Exemplaire")
@NamedQueries({
    @NamedQuery(
            name = "getExemplairebyId",
            query = "SELECT e FROM Exemplaire e WHERE e.reference = :reference "
    ),
    @NamedQuery(
            name = "getEmpruntsOfExemplaire",
            query = "SELECT e.emprunts FROM Exemplaire e WHERE e.reference ="
                    + " :reference "),
    @NamedQuery(
            name = "getALLExemplaires",
            query = "SELECT e FROM Exemplaire e"),
    @NamedQuery(
            name = "getALLExemplairesByStatus",
            query = "SELECT e FROM Exemplaire e WHERE e.etat = :etat")
})

public class Exemplaire implements Serializable {

    @Id
    @Column(name = "REFERENCE_EXEMPLAIRE", nullable = false)
    private String reference;

    @Column(name = "NOMBRE_EMPRUNT")
    private int nb_emprunt;

    @Column(name = "ETAT_EXEMPLAIRE")
    private String etat;

    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;

    @OneToMany(mappedBy = "exemplaire", fetch = FetchType.LAZY)
    private List<Emprunt> emprunts;

    public Exemplaire() {
    }

    public Exemplaire(String reference, int nb_emprunt, String etat) {
        this.reference = reference;
        this.nb_emprunt = nb_emprunt;
        this.etat = etat;
    }

    public Exemplaire(String reference, int nb_emprunt, String etat,
            Item item, List<Emprunt> emprunts) {
        this.reference = reference;
        this.nb_emprunt = nb_emprunt;
        this.etat = etat;
        this.item = item;
        this.emprunts = emprunts;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
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
