package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.User;
import java.util.List;

public interface UserManagement {

    public void addAdhrent(Adherent adherent);
    public void updateAdhrent(Adherent adherent);
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public Employee getEmployee(String reference);

    public void removeEmployee(Employee employee);
    public void removeAdherent(Adherent adherent);

    public List<Adherent> getAllAdherent();

    public List<Employee> getAllEmpoyee();

    public Adherent getAdherent(String id);

    public String CheckType(User user);

    public boolean CheckExist(User user);

}
