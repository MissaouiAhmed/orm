
package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Molka
 */
@Entity
@Table(name="BonDeCommande")

@NamedQueries({
    @NamedQuery(
    name="getAllBonDeCommandes",
    query="SELECT l FROM BonDeCommande l" )
})
public class BonDeCommande implements Serializable {
    @Id
    private String numeroCommande;
    @Column(name = "DATE_COMMANDE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_commande;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Fournisseur fournisseur;

    public BonDeCommande(String numeroCommande, Date date_commande, Fournisseur fournisseur, List<LigneCommande> lignesCommandes) {
	this.numeroCommande = numeroCommande;
	this.date_commande = date_commande;
	this.fournisseur = fournisseur;
	this.lignesCommandes = lignesCommandes;
    }

    

    
    
    
    @OneToMany(mappedBy = "pk.commande",cascade = CascadeType.ALL)
    private List<LigneCommande> lignesCommandes;

    public List<LigneCommande> getLignesCommandes() {
        return lignesCommandes;
    }

    public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
        this.lignesCommandes = lignesCommandes;
    }

    public BonDeCommande() {
        lignesCommandes=new ArrayList<LigneCommande>();
    }
    
    
    
    
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    
    
  

    public String getNumeroCommande() {
	return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
	this.numeroCommande = numeroCommande;
    }

    
    

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }
    
    
    
}
