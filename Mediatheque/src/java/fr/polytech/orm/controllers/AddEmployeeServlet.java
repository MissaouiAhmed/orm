package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Compte;
import fr.polytech.orm.entities.Employee;
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
@WebServlet(name = "AddEmployeeServlet", urlPatterns = {"/AddEmployee"})
public class AddEmployeeServlet extends HttpServlet {

    @EJB
    UserManagement gestionnaireAdhrent;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String prenom = request.getParameter("PRENOM");
        String nom = request.getParameter("NOM");
        String password = request.getParameter("PASSWORD");
        String login = request.getParameter("LOGIN");
        String age = request.getParameter("AGE");
        String lieu = request.getParameter("lieu");

        Employee emp=new Employee();
        emp.setAge(Integer.parseInt(age));
        emp.setId(UUID.randomUUID().toString());
        emp.setLieuNaissance(lieu);
        emp.setLogin(login);
        emp.setNom(nom);
        emp.setPassword(password);
        emp.setPrenom(prenom);

        gestionnaireAdhrent.addEmployee(emp);

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("UserManagement");
    }

}
