package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Missaoui
 */
@Entity
@Table(name = "Emprunt")

@NamedQueries({
    @NamedQuery(
    name="getAllEmprunts",
    query="SELECT l FROM Emprunt l" )
})
public class Emprunt implements Serializable {

    @Id
    @Column(name = "NUMERO", nullable = false)
    private String numero;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADHERENT", nullable = false)
    private Adherent adherent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXEMPLAIRE", nullable = false)
    private Exemplaire exemplaire;
    @Column(name = "DATE_EMPRUNT", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEprunt;

    @Column(name = "STATUS")
    private EmpruntStatus status;
    @Column(name = "DATERETOUR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRetour;
    @Column(name = "DUREE")
    private int duree;

    public Adherent getAdherent() {
	return adherent;
    }

    public Date getDateEprunt() {
	return dateEprunt;
    }

    public Exemplaire getExemplaire() {
	return exemplaire;
    }

    public String getNumero() {
	return numero;
    }

    public Date getDateRetour() {
	return dateRetour;
    }

    public int getDuree() {
	return duree;
    }

    public EmpruntStatus getStatus() {
	return status;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public void setDateEprunt(Date dateEprunt) {
        this.dateEprunt = dateEprunt;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setStatus(EmpruntStatus status) {
        this.status = status;
    }
    
    
    

    
    
    
    
}
