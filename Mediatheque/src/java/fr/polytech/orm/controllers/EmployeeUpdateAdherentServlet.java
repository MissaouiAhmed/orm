package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Compte;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
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
@WebServlet(name = "EmployeeUpdateAdherentServlet", urlPatterns = {"/EmployeeUpdateAdherent"})
public class EmployeeUpdateAdherentServlet extends UpdateAdherentServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        super.processRequest(request, response);
        response.sendRedirect("EmployeeUserManagement");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
       
    }

}
