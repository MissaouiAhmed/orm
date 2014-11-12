package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Fournisseur")
@NamedQueries({
    @NamedQuery(
            name = "getAllFournisseur",
            query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(
            name = "getCommandesOfFournisseurById",
            query = "SELECT f.boncommandes FROM Fournisseur f "
                    + "WHERE f.numero_fournisseur = :numero_fournisseur ")
})
public class Fournisseur implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private String numero_fournisseur;

    @Column(name = "nom_fournisseur")
    private String nom_fournisseur;

    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.EAGER)
    private List<BonDeCommande> boncommandes = new ArrayList<BonDeCommande>();

    public Fournisseur() {
    }

    public Fournisseur(String numero_fournisseur, String nom_fournisseur) {
        this.numero_fournisseur = numero_fournisseur;
        this.nom_fournisseur = nom_fournisseur;
    }

    public List<BonDeCommande> getBoncommandes() {
        return boncommandes;
    }

    public void setBoncommandes(List<BonDeCommande> boncommandes) {
        this.boncommandes = boncommandes;
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

}
