package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        } else if (login.equalsIgnoreCase("employee") && password.equalsIgnoreCase("employee")) {
            response.sendRedirect("EmployeeDashboard");
        } else {
            List<Adherent> list = gestionnaireAdhrent.getAllAdherent();
            for (Adherent adherent : list) {
                if (login.equalsIgnoreCase(adherent.getLogin()) && password.equalsIgnoreCase(adherent.getPassword())) {
                    HttpSession s;
                    s = request.getSession();
                    s.setAttribute("ad", adherent);
                    response.sendRedirect("aDashboard");
                } else {
                    response.sendRedirect("#");
                }
            }
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
