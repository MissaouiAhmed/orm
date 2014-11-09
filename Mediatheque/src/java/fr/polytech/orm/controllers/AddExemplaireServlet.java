package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
import java.io.IOException;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reference = request.getParameter("reference");
        String selecteditem = request.getParameter("selecteditem");
        Exemplaire e = new Exemplaire();
        e.setReference(reference);
        Item ad = gestionnaireProdcuts.getItem(selecteditem);
        e.setItem(ad);
        gestionnaireProdcuts.addExemplaire(e);

        response.sendRedirect("Dashboard");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
