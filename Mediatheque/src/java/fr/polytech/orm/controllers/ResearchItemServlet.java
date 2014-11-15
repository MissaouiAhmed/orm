/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author BENATHMANE
 */
@WebServlet(name = "ResearchItemServlet", urlPatterns = {"/ResearchItem"})
public class ResearchItemServlet extends HttpServlet {

    @EJB
    ProductManagement gestionnaireProdcuts;
       

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String titreitem = request.getParameter("titreitem");
        String auteuritem = request.getParameter("auteuritem");
        if (!titreitem.isEmpty() && !auteuritem.isEmpty()){
            List <Item> item = gestionnaireProdcuts.getItemsbyTitreAndAuteur(titreitem, auteuritem);
            request.getSession().setAttribute("item", item);
        } else if (!titreitem.isEmpty() && auteuritem.isEmpty()){
            List <Item> item = gestionnaireProdcuts.getItemsbyTitre(titreitem);
            request.getSession().setAttribute("item", item);
        }else if (titreitem.isEmpty() && !auteuritem.isEmpty()){
            List <Item> item = gestionnaireProdcuts.getItemsbyAuteur(auteuritem);
            request.getSession().setAttribute("item", item);
        } else {
            response.sendRedirect("#");
        }
        response.sendRedirect("adherent/AffichResultserchitem.jsp");
        
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
