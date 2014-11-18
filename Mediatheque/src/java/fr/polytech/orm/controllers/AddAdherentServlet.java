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
@WebServlet(name = "AddAdherentServlet", urlPatterns = {"/AddAdherent"})
public class AddAdherentServlet extends HttpServlet {

    @EJB
    UserManagement gestionnaireAdhrent;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type!=null && type.equals("Annulation")){
            //TODO
          
     }
        else{

        String prenom = request.getParameter("PRENOM");
        String nom = request.getParameter("NOM");
        String password = request.getParameter("PASSWORD");
        String login = request.getParameter("LOGIN");
        String compteId = request.getParameter("COMPTEID");
        String age = request.getParameter("AGE");
        String montant = request.getParameter("MONTANT");
        String lieu = request.getParameter("lieu");

        Compte compte = new Compte();
        compte.setNumero(compteId);
        compte.setEtat(true);
        compte.setDateFinValidte(null);
        compte.setSolde(Integer.parseInt(montant));

        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        date.add(Calendar.YEAR, 1);
        compte.setDateFinValidte(date.getTime());

        Adherent ad = new Adherent();
        //ad.setId(UUID.randomUUID().toString());
        ad.setAge(Integer.parseInt(age));
        ad.setCompte(compte);
        compte.setAdherent(ad);
        ad.setDateAhesion(new Date());
        ad.setLieuNaissance(lieu);
        ad.setLogin(login);
        ad.setNom(nom);
        ad.setNumeroCarte(UUID.randomUUID().toString());
        ad.setPassword(password);
        ad.setPrenom(prenom);

        gestionnaireAdhrent.addAdhrent(ad);


    }
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("UserManagement");
    }

}
