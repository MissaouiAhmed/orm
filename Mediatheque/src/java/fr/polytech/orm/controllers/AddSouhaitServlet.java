package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.SouhaitManagement;
import fr.polytech.orm.entities.*;
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
@WebServlet(name = "AddSouhaitServlet", urlPatterns = {"/AddSouhait"})
public class AddSouhaitServlet extends HttpServlet {


    @EJB
    SouhaitManagement gestionnaireSouhait;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String description = request.getParameter("description");
        String ITEM_NAME = request.getParameter("ITEM_NAME");
        String ITEM_TYPE = request.getParameter("ITEM_TYPE");
        Adherent ad = (Adherent) request.getSession().getAttribute("ad");
        Souhait s = new Souhait();
        s.setDescription(description);
        s.setItemName(ITEM_NAME);
        s.setItemType(ITEM_TYPE);
        s.setAdherent(ad);
        ad.getSouhaits().add(s);
        gestionnaireSouhait.addSouhait(s);
        
        response.sendRedirect("aDashboard");
        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
