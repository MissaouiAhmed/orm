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
@Table(name = "Reservation")
public class Reservation implements Serializable {

    @Id
    @Column(name = "NUMERO", nullable = false)
    private String numero;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADHERENT", nullable = false)
    private Adherent adherent;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM", nullable = false)
    private Item item;
    
    
    @Column(name = "DATE_EMPRUNT", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEprunt;

    @Column(name = "STATUS")
    private ReservationStatus status;
    
    @Column(name = "DUREE")
    private int quantité;

    public Adherent getAdherent() {
	return adherent;
    }

    public Date getDateEprunt() {
	return dateEprunt;
    }

    public Item getItem() {
	return item;
    }

    

    public String getNumero() {
	return numero;
    }


    public int getQuantité() {
	return quantité;
    }

    

    

    public ReservationStatus getStatus() {
	return status;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public void setDateEprunt(Date dateEprunt) {
        this.dateEprunt = dateEprunt;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    
   
    
    

}
