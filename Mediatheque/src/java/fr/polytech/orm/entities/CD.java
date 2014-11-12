package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="CD")
public class CD extends TypeItem implements Serializable{

    public CD() {
        //EMPTY Constructor
    }
    
}
