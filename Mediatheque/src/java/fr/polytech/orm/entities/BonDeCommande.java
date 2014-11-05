/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Molka
 */
@Entity
@Table(name="BonDeCommande")
public class BonDeCommande {
    @Id
    @Column(name="ID",nullable=false)
    private String numero_commande;
    @Column(name = "nom_fournisseur")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_commande;
    
    @ManyToOne
    private Fournisseur fournisseur;

    
    @OneToMany(mappedBy = "pk.Commandebondecommde")
    private List<LigneCommande> lignesCommandes;

    public List<LigneCommande> getLignesCommandes() {
        return lignesCommandes;
    }

    public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
        this.lignesCommandes = lignesCommandes;
    }
    
    
    
    
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    
    
  
    public BonDeCommande(String numero_commande, Date date_commande) {
        this.numero_commande = numero_commande;
        this.date_commande = date_commande;
    }

    
    public String getNumero_commande() {
        return numero_commande;
    }

    public void setNumero_commande(String numero_commande) {
        this.numero_commande = numero_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }
    
    
    
}
