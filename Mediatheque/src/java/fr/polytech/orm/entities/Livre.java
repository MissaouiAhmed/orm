package fr.polytech.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Livre")
public class Livre extends TypeItem {

    public Livre() {
    }

}
