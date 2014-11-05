package fr.polytech.orm.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Missaoui
 */
@Entity
@Table(name="Employee")
public class Employee extends User {

    public Employee() {
    }
 
    
}
