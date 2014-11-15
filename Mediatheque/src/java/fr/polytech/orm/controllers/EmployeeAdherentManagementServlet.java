package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.Fournisseur;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.LigneCommande;
import java.io.IOException;
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
@WebServlet(name = "EmployeeAdherentManagementServlet", urlPatterns = {"/EmployeeAdherentManagement"})
public class EmployeeAdherentManagementServlet extends HttpServlet {

    @EJB
    UserManagement gestionnaireUsers;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      String operation = request.getParameter("operation");
      
      if(operation.equals("remove")){
        String reference = request.getParameter("reference");
          Adherent adherent= gestionnaireUsers.getAdherent(reference);
        gestionnaireUsers.removeAdherent(adherent);
        response.sendRedirect("EmployeeUserManagement");
          
      }

      if(operation.equals("update")){
        String reference = request.getParameter("reference");
        Adherent adherent= gestionnaireUsers.getAdherent(reference);
        request.getSession().setAttribute("adherent", adherent);
        response.sendRedirect("employee/updateadherent.jsp");
          
      }
          
       
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
         
    }

}
