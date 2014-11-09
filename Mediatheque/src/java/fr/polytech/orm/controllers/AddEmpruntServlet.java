package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
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
@WebServlet(name = "AddEmpruntServlet", urlPatterns = {"/AddEmprunt"})
public class AddEmpruntServlet extends HttpServlet {

    @EJB
    EmpruntManagement gestionnaireEmprunt;

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

        Emprunt em = new Emprunt();
        em.setDateEprunt(new Date());
        em.setDuree(6);
        em.setNumero(UUID.randomUUID().toString());
        em.setExemplaire(e);
        em.setAdherent(add);
        gestionnaireEmprunt.addEmprunt(em);

        response.sendRedirect("Dashboard");

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
