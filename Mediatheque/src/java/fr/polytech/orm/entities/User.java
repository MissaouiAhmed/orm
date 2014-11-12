package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(
            name = "getUserbyId",
            query = "SELECT u FROM User u WHERE u.id = :id "),
    @NamedQuery(
            name = "getAllUsers",
            query = "SELECT u FROM User u")
})
public abstract class User implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "DATE_NAISSANCE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;

    @Column(name = "AGE")
    private int age;

    public User() {
    }

    public User(String id, String prenom, String nom, String password,
            String login, Date dateNaissance, String lieuNaissance, int age) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
        this.login = login;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

}
