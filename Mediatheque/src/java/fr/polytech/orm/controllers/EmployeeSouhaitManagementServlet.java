package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.buisness.SouhaitManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.Fournisseur;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.LigneCommande;
import fr.polytech.orm.entities.Souhait;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tounsi
 */
@WebServlet(name = "EmployeeSouhaitManagementServlet", urlPatterns = {"/EmployeeSouhaitManagement"})
public class EmployeeSouhaitManagementServlet extends HttpServlet {

    @EJB
    SouhaitManagement gestionnaireSouhait;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
      /*
        
        String description = request.getParameter("description");
        String ITEM_NAME = request.getParameter("ITEM_NAME");
        String ITEM_TYPE = request.getParameter("ITEM_TYPE");
        Adherent ad = (Adherent) request.getSession().getAttribute("ad");
        Souhait s = new Souhait();
        s.setNumero(UUID.randomUUID().toString());
        s.setDescription(description);
        s.setItemName(ITEM_NAME);
        s.setItemType(ITEM_TYPE);
        s.setAdherent(ad);
        gestionnaireSouhait.addSouhait(s);*/
        List<Souhait> souhaits = gestionnaireSouhait.getAllSouhaits();
        request.getSession().setAttribute("souhaits", souhaits);
        
        response.sendRedirect("employee/SouhaitManagement.jsp");
        
    }

     

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
         
    }

}
