package fr.polytech.orm.buisness;

import fr.polytech.orm.dao.DaoFactory;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Stateless
public class UserManagementImpl implements UserManagement {

    @PersistenceContext
    private EntityManager em;

    public void addAdhrent(Adherent adherent) {
        DaoFactory.AdherentDAO.create(adherent, em);
    }

    public void updateAdhrent(Adherent adherent) {
        DaoFactory.AdherentDAO.update(adherent, em);
    }
    public void updateEmployee(Employee employee) {
        DaoFactory.EmployeeDAO.update(employee, em);
    }
    public void addEmployee(Employee employee) {
        DaoFactory.EmployeeDAO.create(employee, em);
    
    }
    public Employee getEmployee(String reference){
        return (Employee) em.createNamedQuery("getEmployeeByid").setParameter("id", reference).
                getSingleResult();
    }
    public void removeEmployee(Employee employee) {
            DaoFactory.EmployeeDAO.delete(employee, em);    
    }
    public List<Adherent> getAllAdherent() {
        return em.createQuery("select a from Adherent a").getResultList();

    }
    
   public List<Employee> getAllEmpoyee() {
        return em.createNamedQuery("getAllEmployees").getResultList();

    }     
    public Adherent getAdherent(String id) {
        return (Adherent) em.createNamedQuery("getAdherentbyId").setParameter("id", id).
                getSingleResult();
    }
    
    public void removeAdherent(Adherent adherent) {
            DaoFactory.AdherentDAO.delete(adherent, em);    
    }
    public String CheckType(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean CheckExist(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
