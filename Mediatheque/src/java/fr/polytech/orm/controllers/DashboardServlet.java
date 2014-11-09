package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Fournisseur;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.Reservation;
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
@WebServlet(name = "DashboardServlet", urlPatterns = {"/Dashboard"})
public class DashboardServlet extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Adherent> list = gestionnaireAdhrent.getAllAdherent();
        request.getSession().setAttribute("adherents", list);

        List<Item> items = gestionnaireProdcuts.getAllItems();
        request.getSession().setAttribute("items", items);

        List<Exemplaire> exemplaires = gestionnaireProdcuts.getAllExemplaires();
        request.getSession().setAttribute("exemplaires", exemplaires);

        List<Emprunt> emprunts = gestionnaireEmprunt.getAllEmprunt();
        request.getSession().setAttribute("emprunts", emprunts);

        List<Reservation> reservations = gestionnaireReservations.getAllReservations();
        request.getSession().setAttribute("reservations", reservations);

        List<Fournisseur> fournisseurs = gestionnaireReaprovisionnement.getAllFournisseurs();
        request.getSession().setAttribute("fournisseurs", fournisseurs);

        List<BonDeCommande> commandes = gestionnaireReaprovisionnement.getAllCommandes();
        request.getSession().setAttribute("commandes", commandes);

        response.sendRedirect("admin/Dashboard.jsp");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
