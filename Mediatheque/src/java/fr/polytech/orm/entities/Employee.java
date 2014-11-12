package fr.polytech.orm.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@NamedQueries({
    @NamedQuery(
            name = "getAllEmployees",
            query = "SELECT e FROM Employee e"),
     @NamedQuery(
            name = "getValidedEmprunts",
            query = "SELECT e.validatesEmprunts FROM Employee e WHERE"
                    + " e.id = :id ")
})
public class Employee extends User {

    public Employee() {
        //EMPTY Constructor
    }

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Emprunt> validatesEmprunts = new ArrayList<Emprunt>();

    public List<Emprunt> getValidatesEmprunts() {
        return validatesEmprunts;
    }

    public void setValidatesEmprunts(List<Emprunt> validatesEmprunts) {
        this.validatesEmprunts = validatesEmprunts;
    }

}
