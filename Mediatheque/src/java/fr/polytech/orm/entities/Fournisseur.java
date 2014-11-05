package fr.polytech.orm.entities;

import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Molka
 */
@Entity
@Table(name = "Fournisseur")
public class Fournisseur {

    @Id
    @Column(name = "ID", nullable = false)
    private String numero_fournisseur;
    @Column(name = "nom_fournisseur")
    private String nom_fournisseur;
    @OneToMany(cascade = ALL, mappedBy = "fournisseur")
    private List<BonDeCommande> boncommande;

    public Fournisseur(String numero_fournisseur, String nom_fournisseur,
            List<BonDeCommande> boncommande) {
        this.numero_fournisseur = numero_fournisseur;
        this.nom_fournisseur = nom_fournisseur;
        this.boncommande = boncommande;
    }

    public String getNumero_fournisseur() {
        return numero_fournisseur;
    }

    public void setNumero_fournisseur(String numero_fournisseur) {
        this.numero_fournisseur = numero_fournisseur;
    }

    public String getNom_fournisseur() {
        return nom_fournisseur;
    }

    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }

    public List<BonDeCommande> getBoncommande() {
        return boncommande;
    }

    public void setBoncommande(List<BonDeCommande> boncommande) {
        this.boncommande = boncommande;
    }

}
