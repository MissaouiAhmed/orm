/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.entities;

import java.util.Date;
import java.util.List;
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
@Table(name="Item")
public class Item {
     @Id
    @Column(name="REFERENCE",nullable=false)
    private String reference;
    @Column(name = "titre")
    private String titre;
   @Column(name = "auteur")
    private String auteur;
   @Column(name = "dateAdhesion")
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdhesion;
   @Column(name = "dateEdition")
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEdition;
    
    @ManyToOne
    private Type_Item type;
    
    @OneToMany(mappedBy = "pk.commandeitem")
    private List<LigneCommande> lignesCommandes;

    public List<LigneCommande> getLignesCommandes() {
        return lignesCommandes;
    }

    public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
        this.lignesCommandes = lignesCommandes;
    }
    
    
    

    public Type_Item getType() {
        return type;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(Type_Item type) {
        this.type = type;
    }
    
    
    
   
     public Item(String reference, String titre, String auteur,Date dateAdhesion,Date dateEdition ) {
        this.reference = reference;
        this.titre = titre;
        this.auteur = auteur;
        this.dateAdhesion = dateAdhesion;
        this.dateEdition=dateEdition;
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

    public Date getDateAdhesion() {
        return dateAdhesion;
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

    public void setDateAdhesion(Date dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }
    
     
    
}
