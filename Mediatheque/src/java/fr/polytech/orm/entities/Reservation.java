package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
@NamedQueries({
    @NamedQuery(
            name = "getReservationbyId",
            query = "SELECT l FROM Reservation l WHERE l.numero = :numero "),
    @NamedQuery(
            name = "getALLReservations",
            query = "SELECT l FROM Reservation l "),
    @NamedQuery(
            name = "getReservationbyItemAndAdherent",
            query = "SELECT r FROM Reservation r WHERE r.item.reference = :reference AND r.adherent.id=:id And r.status=fr.polytech.orm.entities.ReservationStatus.EN_ATTENTE")
    
})
public class Reservation implements Serializable {

    @Id
    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ADHERENT", nullable = false)
    private Adherent adherent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ITEM", nullable = false)
    private Item item;

    @Column(name = "DATE_EMPRUNT", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEprunt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ReservationStatus status;

    @Column(name = "DUREE")
    private int quantité;

    public Reservation() {
    }

    public Reservation(String numero, Adherent adherent, Item item,
            Date dateEprunt, ReservationStatus status, int quantité) {
        this.numero = numero;
        this.adherent = adherent;
        this.item = item;
        this.dateEprunt = dateEprunt;
        this.status = status;
        this.quantité = quantité;
    }

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
     @Override
    public String toString() {
        return "Reservation{" + "numero=" + numero + ", adherent=" + adherent +
                ", item=" + item + ", dateEprunt=" + dateEprunt + ", status=" +
                status + ", quantit\u00e9=" + quantité + '}';
    }

    public void setQuantité(String quantite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
