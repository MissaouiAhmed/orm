package fr.polytech.orm.dao;

import fr.polytech.orm.entities.*;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;

/**
 *
 * @author Missaoui
 */
public class DaoFactory {

    private DaoFactory() {
        //PRIVATE EMPTY CONSTRUCTOR
    }
    public static GenericDao<Adherent, String> AdherentDAO = new GenericDaoImpl<Adherent, String>();

    public static GenericDao<Item, String> itemDAO = new GenericDaoImpl<Item, String>();

    public static GenericDao<Exemplaire, String> exemplaireDAO = new GenericDaoImpl<Exemplaire, String>();

    public static GenericDao<Emprunt, String> empruntDAO = new GenericDaoImpl<Emprunt, String>();

    public static GenericDao<Reservation, String> reservationDAO = new GenericDaoImpl<Reservation, String>();

    public static GenericDao<Fournisseur, String> fournisseurDAO = new GenericDaoImpl<Fournisseur, String>();

    public static GenericDao<BonDeCommande, String> bonDeCommandeDAO = new GenericDaoImpl<BonDeCommande, String>();

    public static GenericDao<Souhait, String> SouhaitDAO = new GenericDaoImpl<Souhait, String>();

    public static GenericDao<Employee, String> EmployeeDAO = new GenericDaoImpl<Employee, String>();

}
