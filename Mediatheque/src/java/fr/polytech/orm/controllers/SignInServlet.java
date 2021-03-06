package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Employee;
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
    @EJB
    UserManagement gestionnaireEmployee;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            response.sendRedirect("Dashboard");
        } 
        
            
          //  if (login.equalsIgnoreCase("employee") && password.equalsIgnoreCase("employee")) {
         //  response.sendRedirect("EmployeeDashboard");
        /*{
             List<Employee> list1 = gestionnaireEmployee.getAllEmpoyee();
            for (Employee employee : list1) {
                if (login.equalsIgnoreCase(employee.getLogin()) 
                        && password.equalsIgnoreCase(employee.getPassword())) {
                    HttpSession s;
                    s = request.getSession();
                    s.setAttribute("em", employee);
                    //response.sendRedirect("Dashbord");
                     response.sendRedirect("indexEmployee");
                } else {
                    response.sendRedirect("#");
                }*/
            
    //} 
        else {
            boolean foundAdherent = false;
            List<Adherent> list = gestionnaireAdhrent.getAllAdherent();
            for (Adherent adherent : list) {
                if (login.equalsIgnoreCase(adherent.getLogin()) 
                        && password.equalsIgnoreCase(adherent.getPassword())) {
                    HttpSession s;
                    s = request.getSession();
                    s.setAttribute("ad", adherent);
                    foundAdherent = true;
                    response.sendRedirect("indexAdherent");
                }
            }
            if(!foundAdherent){
                     List<Employee> list1 = gestionnaireEmployee.getAllEmpoyee();
            for (Employee employee : list1) {
                if (login.equalsIgnoreCase(employee.getLogin()) 
                        && password.equalsIgnoreCase(employee.getPassword())) {
                    HttpSession s;
                    s = request.getSession();
                    s.setAttribute("em", employee);
                    //response.sendRedirect("Dashbord");
                     response.sendRedirect("EmployeeDashboard");
                }
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
