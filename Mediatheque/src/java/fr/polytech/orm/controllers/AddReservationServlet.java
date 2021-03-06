package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.EmpruntStatus;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.Reservation;
import fr.polytech.orm.entities.ReservationStatus;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
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
@WebServlet(name = "AddReservationServlet", urlPatterns = {"/AddReservation"})
public class AddReservationServlet extends HttpServlet {

    @EJB
    ReservationManagement gestionnaireReservations;
    @EJB
    ProductManagement gestionnaireProducts;
    @EJB
    UserManagement gestionnaireAdherent;
      @EJB
    EmpruntManagement gestionnaireEmprunt;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String selectedItem = request.getParameter("selecteditem");
         String selectedAdherent = request.getParameter("selectedadehrent");
         
         
        String numero = request.getParameter("numero");
        String type = request.getParameter("type");
     if(type!=null && type.equals("Validation")){

        Reservation res = new Reservation();
        res.setNumero(numero);
        res=gestionnaireReservations.getReservation(numero);
        res.setStatus(ReservationStatus.TERMINE);
        gestionnaireReservations.updateReservation(res);
        Emprunt emprunt = new Emprunt();
        emprunt.setAdherent(res.getAdherent());
        emprunt.setExemplaire(gestionnaireProducts.getDispExemplaire(res.getItem().getExemplaires()));
        emprunt.setDateEprunt(new Date());
        emprunt.setDuree(6);
        emprunt.setStatus(EmpruntStatus.EN_ATTENTE);
        gestionnaireEmprunt.addEmprunt(emprunt);
       
     }
     else if (type!=null && type.equals("Annulation")){
        Reservation res = new Reservation();
        res.setNumero(numero);
        res=gestionnaireReservations.getReservation(numero);
        res.setStatus(ReservationStatus.INVALID);
        gestionnaireReservations.deleteReservation(res);
         
     }
     else {
     
        Reservation res = new Reservation();
        Item item = gestionnaireProducts.getItem(selectedItem);
        Adherent adherent = gestionnaireAdherent.getAdherent(selectedAdherent);
        if((gestionnaireReservations.getReservationByItemAndAdherent(selectedItem, selectedAdherent)==null)&&(gestionnaireEmprunt.getEmpruntbyItemAndAdherent(selectedItem, selectedAdherent)==null)){
        
        res.setItem(item);
        res.setAdherent(adherent);
        res.setDateEprunt(new Date());
        //res.setQuantité(quantite);
        res.setStatus(ReservationStatus.EN_ATTENTE);
        gestionnaireReservations.addReservation(res);
      }
    }}

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("ProductManagement");
    }

}
