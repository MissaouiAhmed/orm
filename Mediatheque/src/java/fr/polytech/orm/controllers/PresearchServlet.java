/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.Exemplaire;
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
 * @author BENATHMANE
 */
@WebServlet(name = "PresearchServlet", urlPatterns = {"/Presearch"})
public class PresearchServlet extends HttpServlet {

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


        List<Item> items = gestionnaireProdcuts.getAllItems();
        request.getSession().setAttribute("items", items);

        response.sendRedirect("adherent/researchItem.jsp");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
