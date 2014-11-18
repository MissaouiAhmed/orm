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
@Table(name = "Emprunt")
@NamedQueries({
    @NamedQuery(
            name = "getEmpruntbyId",
            query = "SELECT e FROM Emprunt e WHERE e.numero = :numero"),
    @NamedQuery(
            name = "getAllEmprunts",
            query = "SELECT e FROM Emprunt e"),
    @NamedQuery(
            name = "getEmpruntStatus",
            query = "SELECT e.status FROM Emprunt e WHERE e.numero = :numero"),
    @NamedQuery(
            name = "getEmpruntsByStatus",
            query = "SELECT e FROM Emprunt e WHERE e.status = :status"),
    @NamedQuery(
             name = "getEmpruntbyItemAndAdherent",
            query = "SELECT e FROM Emprunt e WHERE e.exemplaire.item.reference = :reference AND e.adherent.id=:id And (e.status=fr.polytech.orm.entities.EmpruntStatus.EN_COURS OR e.status=fr.polytech.orm.entities.EmpruntStatus.EN_ATTENTE) ")
    
})
public class Emprunt implements Serializable {

    @Id
    @Column(name = "NUMERO", nullable = false)
    private String numero;
    
    @Column(name = "DATE_EMPRUNT", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEprunt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private EmpruntStatus status;

    @Column(name = "DATERETOUR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRetour;

    @Column(name = "DUREE")
    private int duree;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ADHERENT", nullable = false)
    private Adherent adherent;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EXEMPLAIRE", nullable = false)
    private Exemplaire exemplaire;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEE")
    private Employee employee;

    public Emprunt() {
    }

    public Emprunt(String numero, Date dateEprunt, EmpruntStatus status,
            Date dateRetour, int duree, Adherent adherent,
            Exemplaire exemplaire, Employee employee) {
        this.numero = numero;
        this.dateEprunt = dateEprunt;
        this.status = status;
        this.dateRetour = dateRetour;
        this.duree = duree;
        this.adherent = adherent;
        this.exemplaire = exemplaire;
        this.employee = employee;
    }
    
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

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public void setDateEprunt(Date dateEprunt) {
        this.dateEprunt = dateEprunt;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setStatus(EmpruntStatus status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
