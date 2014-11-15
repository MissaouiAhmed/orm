package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.Reservation;
import fr.polytech.orm.entities.ReservationStatus;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "AddExemplaireServlet", urlPatterns = {"/AddExemplaire"})
public class AddExemplaireServlet extends HttpServlet {

    @EJB
    ProductManagement gestionnaireProdcuts;
    @EJB
    ReservationManagement gestionnaireReservations;
@EJB
    UserManagement gestionnaireAdhrent;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reference = request.getParameter("reference");
        String type = request.getParameter("type");
        if (type!=null && type.equals("Annulation")){
           // Exemplaire exemplaire = new Exemplaire();
           // exemplaire.setReference("reference");
            Exemplaire exemplaire=gestionnaireProdcuts.getExemplaire(reference);
            gestionnaireProdcuts.deleteExemplaire(exemplaire);
           
        }
        else {
        String selecteditem = request.getParameter("selecteditem");
        Exemplaire e = new Exemplaire();
        e.setReference(reference);
        Item item = gestionnaireProdcuts.getItem(selecteditem);
        e.setItem(item);
        e.setEtat("Disponible");
        gestionnaireProdcuts.addExemplaire(e);
      
        /*Adherent adherent =new Adherent();
        adherent.setId("01");
        Item item= new Item();
        item.setReference("001");*/
        
      
        
    }
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
          response.sendRedirect("ProductManagement");
    }

}
