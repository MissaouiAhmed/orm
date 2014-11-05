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
public class Emprunt implements Serializable {

    @Id
    @Column(name = "NUMERO", nullable = false)
    private String numero;
    @ManyToOne
    @JoinColumn(name = "ADHERENT", nullable = false)
    private Adherent adherent;
    @ManyToOne
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
    
    
    

}
