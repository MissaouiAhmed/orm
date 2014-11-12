package fr.polytech.orm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Type_Item")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(
            name = "getTypeItembyId",
            query = "SELECT t FROM TypeItem t WHERE t.id = :id "),
    @NamedQuery(
            name = "getALLTypeItems",
            query = "SELECT t FROM TypeItem t"),
    @NamedQuery(
            name = "getALLItemsFromType",
            query = "SELECT t.items FROM TypeItem t WHERE t.id = :id"),
})
public class TypeItem implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "PENATLITE_PAR_JOUR")
    private int penalite_par_jour;

    @Column(name = "DUREE_MAXIMALE")
    private int duree_maximale;

    @Column(name = "MAX_EMPRUNT")
    private int nb_max_emprunt;

    @Column(name = "RENOUVELABLE")
    private boolean est_renouvelable;

    @OneToMany(cascade = ALL, mappedBy = "type", fetch = FetchType.EAGER)
    private List<Item> items =new ArrayList<Item>();

    public TypeItem() {
    }

    public TypeItem(String id, int penalite_par_jour, int duree_maximale,
            int nb_max_emprunt, boolean est_renouvelable, List<Item> items) {
        this.id = id;
        this.penalite_par_jour = penalite_par_jour;
        this.duree_maximale = duree_maximale;
        this.nb_max_emprunt = nb_max_emprunt;
        this.est_renouvelable = est_renouvelable;
        this.items = items;
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
