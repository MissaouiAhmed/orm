package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Missaoui
 */
@Entity
@Table(name="ADHERENT")
@NamedQueries({
    @NamedQuery(
    name="getAllAdherents",
    query="SELECT l FROM Adherent l " ),
//    @NamedQuery(
//    name="getAllCompteByIDAdherent",
//    query="SELECT compte FROM Adherent l where l.reference = :reference " )
})
public class Adherent extends User implements Serializable{

   private static final long serialVersionUID = 3L;
 
    @Column(name = "DATE_ADHESION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAhesion;
    
    @OneToOne(mappedBy = "adherent",cascade = CascadeType.ALL)
    private Compte compte;
    
    @OneToMany(cascade=ALL, mappedBy="adherent")
    private List<Souhait> souhaits;

    
    @Column(name = "NUMEROCARTE")
    private String numeroCarte ;

    
    @OneToMany(cascade=ALL, mappedBy="adherent")
    private List<Emprunt> emprunts;

    public List<Emprunt> getEmprunts() {
	return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
	this.emprunts = emprunts;
    }
    
    
     @OneToMany(cascade=ALL, mappedBy="adherent")
    private List<Reservation> reservations;

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

    public Adherent() {
    }

    
    public Adherent(Date dateAhesion, Compte compte, List<Souhait> souhaits, String numeroCarte) {
        this.dateAhesion = dateAhesion;
        this.compte = compte;
        this.souhaits = souhaits;
        this.numeroCarte = numeroCarte;
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
