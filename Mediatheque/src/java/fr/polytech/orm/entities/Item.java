package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Item")
@NamedQueries({
    @NamedQuery(
            name = "getItembyId",
            query = "SELECT i FROM Item i WHERE i.reference = :reference "),
    @NamedQuery(
            name = "getAllItems",
            query = "SELECT i FROM Item i"),
    @NamedQuery(
            name = "getItemExemplaires",
            query = "SELECT i.exemplaires FROM Item i "
            + " WHERE i.reference = :reference")
})
public class Item implements Serializable {

    @Id
    @Column(name = "REFERENCE", nullable = false)
    private String reference;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "DATE_DISPOSION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDispostion;

    @Column(name = "dateEdition")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEdition;

    @ManyToOne(fetch = FetchType.EAGER)
    private TypeItem type;

    @OneToMany(mappedBy = "pk.item", fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE
            })
    private List<LigneCommande> lignesCommandes = new ArrayList<LigneCommande>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "item",
            fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public Item() {
    }

    public Item(String reference, String titre, String auteur,
            Date dateDispostion, Date dateEdition, TypeItem type,
            List<Exemplaire> exemplaires, List<LigneCommande> lignesCommandes,
            List<Reservation> reservations) {
        this.reference = reference;
        this.titre = titre;
        this.auteur = auteur;
        this.dateDispostion = dateDispostion;
        this.dateEdition = dateEdition;
        this.type = type;
        this.exemplaires = exemplaires;
        this.lignesCommandes = lignesCommandes;
        this.reservations = reservations;
    }

    public Item(String reference, String titre, String auteur,
            Date dateDispostion, Date dateEdition, TypeItem type) {
        this.reference = reference;
        this.titre = titre;
        this.auteur = auteur;
        this.dateDispostion = dateDispostion;
        this.dateEdition = dateEdition;
        this.type = type;
    }

    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }

    public List<LigneCommande> getLignesCommandes() {
        return lignesCommandes;
    }

    public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
        this.lignesCommandes = lignesCommandes;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public TypeItem getType() {
        return type;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(TypeItem type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public Date getDateDispostion() {
        return dateDispostion;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setDateDispostion(Date dateDispostion) {
        this.dateDispostion = dateDispostion;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

}
