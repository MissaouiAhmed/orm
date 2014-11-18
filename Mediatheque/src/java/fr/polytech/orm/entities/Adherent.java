package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "ADHERENT")
@NamedQueries({
    @NamedQuery(
            name = "getAllAdherents",
            query = "SELECT l FROM Adherent l"),
    @NamedQuery(
            name = "getAdherentbyId",
            query = "SELECT l FROM Adherent l WHERE l.id = :id "),
    @NamedQuery(
            name = "getEmpruntsOfAdhrent",
            query = "SELECT l.emprunts FROM Adherent l WHERE l.id = :id "),
    @NamedQuery(
            name = "getReservationsOfAdhrent",
            query = "SELECT l.reservations FROM Adherent l WHERE l.id = :id "),
    @NamedQuery(
            name = "getSouhaitssOfAdhrent",
            query = "SELECT l.souhaits FROM Adherent l WHERE l.id = :id "),
    @NamedQuery(
            name = "getCompteOfAdhrent",
            query = "SELECT l.compte FROM Adherent l WHERE l.id = :id ")
})
public class Adherent extends User implements Serializable {

    private static final long serialVersionUID = 3L;

    @Column(name = "DATE_ADHESION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAhesion;

    @Column(name = "NUMEROCARTE")
    private String numeroCarte;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adherent",
            fetch = FetchType.EAGER)
    private Compte compte;

    @OneToMany(cascade = ALL, mappedBy = "adherent", fetch = FetchType.EAGER)
    private List<Souhait> souhaits = new ArrayList<Souhait>();

    @OneToMany(cascade = ALL, mappedBy = "adherent", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<Reservation>();

    @OneToMany(cascade = ALL, mappedBy = "adherent", fetch = FetchType.LAZY)
    private List<Emprunt> emprunts = new ArrayList<Emprunt>();

    public Adherent() {
    }

    public Adherent(Date dateAhesion, Compte compte, List<Souhait> souhaits,
            String numeroCarte) {
        this.dateAhesion = dateAhesion;
        this.compte = compte;
        this.souhaits = souhaits;
        this.numeroCarte = numeroCarte;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Date getDateAhesion() {
        return dateAhesion;
    }

    public void setDateAhesion(Date dateAhesion) {
        this.dateAhesion = dateAhesion;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public List<Souhait> getSouhaits() {
        return souhaits;
    }

    public void setSouhaits(List<Souhait> souhaits) {
        this.souhaits = souhaits;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    @Override
    public String getId() {
        return super.getId();
    }

}
