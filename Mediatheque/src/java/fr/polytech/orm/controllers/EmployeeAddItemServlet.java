package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ProductManagement;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tounsi
 */
@WebServlet(name = "EmployeeAddItemServlet", urlPatterns = {"/EmployeeAddItem"})
public class EmployeeAddItemServlet extends AddItemServlet {

    @EJB
    ProductManagement gestionnaireProdcuts;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       super.processRequest(request, response);
        response.sendRedirect("EmployeeDashboard");
    
      
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
