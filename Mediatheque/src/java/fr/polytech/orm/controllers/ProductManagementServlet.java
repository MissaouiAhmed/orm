package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.buisness.SouhaitManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Fournisseur;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.Reservation;
import fr.polytech.orm.entities.Souhait;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Missaoui
 */
@WebServlet(name = "ProductManagementServlet", urlPatterns = {"/ProductManagement"})
public class ProductManagementServlet extends HttpServlet {

    @EJB
    UserManagement gestionnaireAdhrent;

    @EJB
    ProductManagement gestionnaireProdcuts;

    @EJB
    EmpruntManagement gestionnaireEmprunt;

    @EJB
    ReservationManagement gestionnaireReservations;

    @EJB
    ReStockManagement gestionnaireReaprovisionnement;

    @EJB
    SouhaitManagement gestionnaireSouhaits;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Item> items = gestionnaireProdcuts.getAllItems();
        request.getSession().setAttribute("items", items);

        List<Exemplaire> exemplaires = gestionnaireProdcuts.getAllExemplaires();
        request.getSession().setAttribute("exemplaires", exemplaires);

        List<Emprunt> emprunts = gestionnaireEmprunt.getAllEmprunt();
        request.getSession().setAttribute("emprunts", emprunts);

        List<Reservation> reservations = gestionnaireReservations.getAllReservations();
        request.getSession().setAttribute("reservations", reservations);
        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("admin/ProductManagement.jsp");
    }

}
