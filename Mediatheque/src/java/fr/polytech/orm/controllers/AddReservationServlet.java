package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.entities.Adherent;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Exemplaire e = new Exemplaire();
        e.setReference(UUID.randomUUID().toString());
        Item ad = new Item();
        ad.setReference(UUID.randomUUID().toString());
        e.setItem(ad);

        Adherent add = new Adherent();
        add.setId(UUID.randomUUID().toString());
        add.setPrenom(UUID.randomUUID().toString());

        Reservation res = new Reservation();
        res.setNumero(UUID.randomUUID().toString());
        res.setDateEprunt(new Date());
        res.setAdherent(add);
        res.setItem(ad);
        res.setQuantité(5);
        res.setStatus(ReservationStatus.EN_ATTENTE);

        gestionnaireReservations.addReservation(res);
        response.sendRedirect("Dashboard");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
