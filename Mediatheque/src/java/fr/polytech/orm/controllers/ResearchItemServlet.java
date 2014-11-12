/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ProductManagement;
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
 * @author BENATHMANE
 */
@WebServlet(name = "ResearchItemServlet", urlPatterns = {"/ResearchItem"})
public class ResearchItemServlet extends HttpServlet {

    @EJB
    ProductManagement gestionnaireProdcuts;
       

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String reference = request.getParameter("item");
        Item item = gestionnaireProdcuts.getItem(reference);
        request.getSession().setAttribute("item", item);
        
        response.sendRedirect("adherent/AffichResultserchitem.jsp");
        
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
