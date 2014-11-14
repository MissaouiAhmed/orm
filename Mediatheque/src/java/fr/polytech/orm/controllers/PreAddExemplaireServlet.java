package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.entities.Item;
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
@WebServlet(name = "PreAddExemplaireServlet", urlPatterns = {"/PreAddExemplaire"})
public class PreAddExemplaireServlet extends HttpServlet {

    @EJB
    ProductManagement gestionnaireProdcuts;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Item> items = gestionnaireProdcuts.getAllItems();
        request.getSession().setAttribute("items", items);

        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("admin/addIExemplaire.jsp");
    }

}
