/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.entities;

import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Molka
 */
@Entity
@Table(name = "Type_Item")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TypeItem {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "penalite_par_jour")
    private int penalite_par_jour;
    @Column(name = "duree_maximale")
    private int duree_maximale;
    @Column(name = "nb_max_emprunt")
    private int nb_max_emprunt;
    @Column(name = "est_renouvelable")
    private boolean est_renouvelable;
    @OneToMany(cascade = ALL, mappedBy = "type")
    private List<Item> items;

    public TypeItem(String id, int penalite_par_jour, int duree_maximale, int nb_max_emprunt, boolean est_renouvelable, List<Item> items) {
	this.id = id;
	this.penalite_par_jour = penalite_par_jour;
	this.duree_maximale = duree_maximale;
	this.nb_max_emprunt = nb_max_emprunt;
	this.est_renouvelable = est_renouvelable;
	this.items = items;
    }

    
    
    public TypeItem() {
    }

    public String getId() {
	return id;
    }

    public int getNb_max_emprunt() {
	return nb_max_emprunt;
    }

    public int getPenalite_par_jour() {
	return penalite_par_jour;
    }

    public void setPenalite_par_jour(int penalite_par_jour) {
	this.penalite_par_jour = penalite_par_jour;
    }

    public int getDuree_maximale() {
	return duree_maximale;
    }

    public void setDuree_maximale(int duree_maximale) {
	this.duree_maximale = duree_maximale;
    }

    public boolean isEst_renouvelable() {
	return est_renouvelable;
    }

    public void setEst_renouvelable(boolean est_renouvelable) {
	this.est_renouvelable = est_renouvelable;
    }

    public List<Item> getItems() {
	return items;
    }

}
