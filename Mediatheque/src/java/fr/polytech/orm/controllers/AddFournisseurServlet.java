package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.entities.Fournisseur;
import java.io.IOException;
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
@WebServlet(name = "AddFournisseurServlet", urlPatterns = {"/AddFournisseur"})
public class AddFournisseurServlet extends HttpServlet {

    @EJB
    ReStockManagement gestionnaireReaprovisionnement;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Fournisseur f = new Fournisseur();
        
             String id = request.getParameter("ID");
        String nom = request.getParameter("FOUNISSEUR");
        f.setNumero_fournisseur(id);
        
        f.setNom_fournisseur(nom);
        
        gestionnaireReaprovisionnement.addFournisseur(f);

        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("FournisseurManagement");
    }

}
