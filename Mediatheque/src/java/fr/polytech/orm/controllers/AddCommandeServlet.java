package fr.polytech.orm.controllers;

import fr.polytech.orm.buisness.ReStockManagement;
import fr.polytech.orm.entities.BonDeCommande;
import fr.polytech.orm.entities.Fournisseur;
import fr.polytech.orm.entities.Item;
import fr.polytech.orm.entities.LigneCommande;
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
@WebServlet(name = "AddCommandeServlet", urlPatterns = {"/AddCommande"})
public class AddCommandeServlet extends HttpServlet {

    @EJB
    ReStockManagement gestionnaireReaprovisionnement;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Fournisseur f = new Fournisseur();
        f.setNom_fournisseur("f");
        f.setNumero_fournisseur(UUID.randomUUID().toString());

        Item ad = new Item();
        ad.setReference(UUID.randomUUID().toString());

        Item ad2 = new Item();
        ad2.setReference(UUID.randomUUID().toString());

        BonDeCommande commande = new BonDeCommande();
        commande.setFournisseur(f);
        commande.setNumeroCommande(UUID.randomUUID().toString());

        LigneCommande l1 = new LigneCommande();
        l1.setCommande(commande);
        l1.setItem(ad);
        l1.setQuantité(2);

        LigneCommande l2 = new LigneCommande();
        l2.setCommande(commande);
        l1.setItem(ad2);
        l1.setQuantité(3);

        commande.getLignesCommandes().add(l1);
        commande.getLignesCommandes().add(l2);

        gestionnaireReaprovisionnement.addCommmande(commande);
       

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
         response.sendRedirect("Dashboard");
    }

}
