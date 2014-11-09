package fr.polytech.orm.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Missaoui
 */
@Entity
@Table(name="Employee")

@NamedQueries({
    @NamedQuery(
    name="getAllEmployees",
    query="SELECT l FROM Employee l" )
})
public class Employee extends User {

    public Employee() {
    }
 
    
}
