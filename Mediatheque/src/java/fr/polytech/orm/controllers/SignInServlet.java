package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.UserManagement;
import java.io.IOException;
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
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignIn"})
public class SignInServlet extends HttpServlet {

    @EJB
    UserManagement gestionnaireAdhrent;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            response.sendRedirect("Dashboard");
        }

        if (login.equalsIgnoreCase("user") && password.equalsIgnoreCase("user")) {
            response.sendRedirect("aDashboard");
        }

        if (login.equalsIgnoreCase("employee") && password.equalsIgnoreCase("employee")) {
            response.sendRedirect("Dashboard");
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
