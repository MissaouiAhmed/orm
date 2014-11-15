<%@page import="fr.polytech.orm.entities.Employee"%>
<%@page import="fr.polytech.orm.entities.BonDeCommande"%>
<%@page import="fr.polytech.orm.entities.Fournisseur"%>
<%@page import="fr.polytech.orm.entities.Reservation"%>
<%@page import="fr.polytech.orm.entities.Emprunt"%>
<%@page import="fr.polytech.orm.entities.Exemplaire"%>
<%@page import="fr.polytech.orm.entities.Item"%>
<%@page import="fr.polytech.orm.entities.Adherent"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/dashboard.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/docs.min.js"></script>
    </head>

    <body>
        <%@include file="../employee/TopBar.html" %>

        <div class="container-fluid">
            <div >
                <%--<%@include file="../navigation/LeftBar.html" %>--%>
                <!-- --------------------------------------------------------------- -->          

                <h2 class="sub-header">Liste des Fournisseur </h2>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Numero founisseur</th>
                                <th>nom founisseur</th>
                                <th></th>  

                                <th><a href="addFournisseur.jsp"><img src="../css/img/add-user-16x16.png" height="20" width="20"/></a> </th>

                            </tr>
                        </thead>
                        <tbody>                               

                            <%
                                List<Fournisseur> fournisseurs = (List) request.getSession().
                                        getAttribute("fournisseurs");
                                for (Fournisseur fournisseur : fournisseurs) {
                                    out.print("<tr class='info'>");
                                    out.print("<td/>");
                                    
                                    out.print("<td>" + fournisseur.getNumero_fournisseur() + "</td>");
                                    out.print("<td>" + fournisseur.getNom_fournisseur() + "</td>");
                                    out.print("</tr>");

                                }
                            %>     
                        </tbody>
                    </table>
                </div>



                <h2 class="sub-header">Liste des commandes </h2>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Numero Commande</th>
                                <th>Date commande</th>
                                <th>Numero fournisseur</th> 
                                <th>Nombre de Produits</th> 
                                
                            </tr>
                        </thead>
                        <tbody>                               

                            <%
                                List<BonDeCommande> commandes = (List) request.getSession().
                                        getAttribute("commandes");
                                for (BonDeCommande commande : commandes) {
                                    out.print("<tr class='info'>");
                                    out.print("<td/>");
                                    
                                    out.print("<td>" + commande.getNumeroCommande() + "</td>");
                                    out.print("<td>" + commande.getDate_commande() + "</td>");
                                    out.print("<td>" + commande.getFournisseur().getNumero_fournisseur() + "</td>");
                                    out.print("<td>" + commande.getLignesCommandes().size() + "</td>");
                                    out.print("</tr>");

                                }
                            %>  

                        </tbody>
                    </table>
                </div> 
                <!-- ************************************************************************************** -->                                    

            </div>
        </div>
    </div>


</body>
</html>

