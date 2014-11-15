package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.buisness.ReservationManagement;
import fr.polytech.orm.buisness.SouhaitManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Employee;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Fournisseur;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.Reservation;
import fr.polytech.orm.entities.Souhait;
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
@WebServlet(name = "EmployeeUserManagementServlet", urlPatterns = {"/EmployeeUserManagement"})
public class EmployeeUserManagementServlet extends UserManagementServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       super.processRequest(request, response);
       response.sendRedirect("employee/UserManagement.jsp");
    
        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
       
    }

}
