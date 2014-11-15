/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.Reservation;
import fr.polytech.orm.entities.ReservationStatus;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author BENATHMANE
 */
@WebServlet(name = "ReserverItemServlet", urlPatterns = {"/ReserverItem"})
public class ReserverItemServlet extends HttpServlet {

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
        
             String operation = request.getParameter("operation");
      
            if(operation.equals("reserver")){
        
                String reference = request.getParameter("reference");
                Adherent ad = (Adherent) request.getSession().getAttribute("ad");
                Reservation res = new Reservation();
                Item it = gestionnaireProducts.getItem(reference);
                res.setItem(it);

                Adherent adherent = gestionnaireAdherent.getAdherent(ad.getId());
                res.setAdherent(adherent);
                res.setNumero(UUID.randomUUID().toString());
                res.setDateEprunt(new Date());
                res.setQuantité(5);
                res.setStatus(ReservationStatus.EN_ATTENTE);

                gestionnaireReservations.addReservation(res);
                response.sendRedirect("aDashboard");
            }
        
    }

      @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
