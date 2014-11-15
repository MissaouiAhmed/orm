package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.entities.Item;
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
@WebServlet(name = "AddItemServlet", urlPatterns = {"/AddItem"})
public class AddItemServlet extends HttpServlet {

    @EJB
    ProductManagement gestionnaireProdcuts;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reference = request.getParameter("reference");

        
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");

        Item ad = new Item();
        ad.setReference(reference);
        ad.setAuteur(auteur);
        ad.setTitre(titre);
        ad.setDateDispostion(new Date());
        gestionnaireProdcuts.addItem(ad);

        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("Dashboard");
    }

}
