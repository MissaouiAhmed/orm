package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="DVD")
public class DVD extends TypeItem implements Serializable {

    public DVD() {
        //EMPTY Constructor
    }
    
}
