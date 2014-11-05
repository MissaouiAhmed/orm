package fr.polytech.orm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Missaoui
 */
@Entity
@Table(name="Souhait")
public class Souhait {

    @Id
    @Column(name = "ID")
    private String numero;

    @Column(name = "DESCRIPTION")
    private String description;
    
    @ManyToOne
    private Adherent adherent;

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Souhait(String numero, String description, Adherent adherent) {
        this.numero = numero;
        this.description = description;
        this.adherent = adherent;
    }

    public Souhait() {
    }

    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
