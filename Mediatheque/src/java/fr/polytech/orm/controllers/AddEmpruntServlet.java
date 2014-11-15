package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.EmpruntManagement;
import fr.polytech.orm.buisness.ProductManagement;
import fr.polytech.orm.buisness.UserManagement;
import fr.polytech.orm.entities.Adherent;
import fr.polytech.orm.entities.Emprunt;
import fr.polytech.orm.entities.EmpruntStatus;
import fr.polytech.orm.entities.Exemplaire;
import java.io.IOException;
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
@WebServlet(name = "AddEmpruntServlet", urlPatterns = {"/AddEmprunt"})
public class AddEmpruntServlet extends HttpServlet {

    @EJB
    EmpruntManagement gestionnaireEmprunt;
    @EJB
    ProductManagement gestionnaireProducts;
    @EJB
    UserManagement gestionnaireAdherent;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selectedExemplaire = request.getParameter("selectedexemplaire");
         String selectedAdherent = request.getParameter("selectedadehrent");
         
 String numero = request.getParameter("numero");
        String type = request.getParameter("type");
     if(type!=null && type.equals("Validation")){
       int nbemprunt=0;
       // Emprunt res = new Emprunt();
        //res.setNumero(numero);
        Emprunt res=gestionnaireEmprunt.getEmprunt(numero);
        res.setStatus(EmpruntStatus.EN_COURS);
        gestionnaireEmprunt.updateEmprunt(res);
        Exemplaire exemplaire = gestionnaireProducts.getExemplaire(selectedExemplaire);
        exemplaire.setEtat("NonDisponible");
        nbemprunt++;
        exemplaire.setNb_emprunt(nbemprunt);
       gestionnaireProducts.updateExemplaire(exemplaire);
        
     }
     else if (type!=null && type.equals("Annulation")){
        Emprunt res = new Emprunt();
        res.setNumero(numero);
        res=gestionnaireEmprunt.getEmprunt(numero);
        res.setStatus(EmpruntStatus.TERMINE);
        gestionnaireEmprunt.updateEmprunt(res);
         Exemplaire exemplaire = gestionnaireProducts.getExemplaire(selectedExemplaire);
        exemplaire.setEtat("Disponible");
       gestionnaireProducts.updateExemplaire(exemplaire);
        //gestionnaireEmprunt.deleteEmprunt(res);
          
     }
     else {
        /*Exemplaire e = new Exemplaire();
        e.setReference(UUID.randomUUID().toString());
        Item ad = new Item();
        ad.setReference(UUID.randomUUID().toString());
        e.setItem(ad);

        Adherent add = new Adherent();
        add.setId(UUID.randomUUID().toString());
        add.setPrenom(UUID.randomUUID().toString());*/
         
       Emprunt em = new Emprunt();
        Exemplaire exemplaire = gestionnaireProducts.getExemplaire(selectedExemplaire);
        em.setExemplaire(exemplaire);
        
 
         Adherent adherent = gestionnaireAdherent.getAdherent(selectedAdherent);
        em.setAdherent(adherent);
        
        em.setDateEprunt(new Date());
        em.setDuree(6);
        em.setNumero(UUID.randomUUID().toString());
        em.setStatus(EmpruntStatus.EN_COURS);
        gestionnaireEmprunt.addEmprunt(em);

       

    }
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
         response.sendRedirect("ProductManagement");
    }

}
