package fr.polytech.orm.entities;

import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Adherent extends User {


    @Column(name = "DATE_ADHESION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAhesion;
    
    @OneToOne(mappedBy = "adherent")
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
    
    
    
}
