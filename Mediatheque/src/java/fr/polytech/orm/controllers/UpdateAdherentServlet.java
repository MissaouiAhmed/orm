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
@WebServlet(name = "UpdateAdherentServlet", urlPatterns = {"/UpdateAdherent"})
public class UpdateAdherentServlet extends HttpServlet {

    @EJB
    UserManagement gestionnaireAdhrent;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String prenom = request.getParameter("PRENOM");
        String nom = request.getParameter("NOM");
        String password = request.getParameter("PASSWORD");
        String login = request.getParameter("LOGIN");
        String age = request.getParameter("AGE");
        String montant = request.getParameter("MONTANT");
        String lieu = request.getParameter("lieu");
        String id = request.getParameter("ID");

        
        Adherent ad = gestionnaireAdhrent.getAdherent(id);
        ad.setAge(Integer.parseInt(age));
        ad.setLieuNaissance(lieu);
        ad.setLogin(login);
        ad.setNom(nom);
        ad.setPassword(password);
        ad.setPrenom(prenom);
        ad.getCompte().setSolde(Float.parseFloat(montant));

        gestionnaireAdhrent.updateAdhrent(ad);


    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("UserManagement");
    }

}
