package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.User;
import java.util.List;

/**
 *
 * @author Missaoui
 */
public interface UserManagement {

    public void addAdhrent(Adherent adherent);

    public void addEmployee(Employee adherent);

    public List<Adherent> getAllAdherent();

    public Adherent getAdherent(String id);

    public String CheckType(User user);

    public boolean CheckExist(User user);

}
