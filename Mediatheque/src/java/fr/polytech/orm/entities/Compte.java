package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "Compte")
public class Compte implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private String numero;

    @Column(name = "DATE_ADHESION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinValidte;
    
    @Column(name = "SOLDE")
    private float solde;
    
    @Column(name = "ETAT")
    private boolean etat;
    
    @OneToOne
    private Adherent adherent;

    

    public Compte(String numero, Date dateFinValidte, Adherent adherent,
            float solde, boolean etat) {
        this.numero = numero;
        this.dateFinValidte = dateFinValidte;
        this.adherent = adherent;
        this.solde = solde;
        this.etat = etat;
    }

    public Compte() {
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateFinValidte() {
        return dateFinValidte;
    }

    public void setDateFinValidte(Date dateFinValidte) {
        this.dateFinValidte = dateFinValidte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

}
