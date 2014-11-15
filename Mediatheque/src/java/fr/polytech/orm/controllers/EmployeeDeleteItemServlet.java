package fr.polytech.orm.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tounsi
 */
@WebServlet(name = "EmployeeDeleteItemServlet", urlPatterns = {"/EmployeeDeleteItem"})
public class EmployeeDeleteItemServlet extends DeleteItemServlet {

   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 super.processRequest(request, response);
        response.sendRedirect("EmployeeProductManagement");
        

        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        
    }

}
