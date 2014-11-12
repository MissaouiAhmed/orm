package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Cassette")
public class Cassette extends TypeItem implements Serializable {

    public Cassette() {
        //EMPTY Constructor
    
    }
    
}
