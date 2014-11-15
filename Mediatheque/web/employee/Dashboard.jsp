<%@page import="fr.polytech.orm.entities.Souhait"%>
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
        <%@include file="../navigation/TopBar.html" %>

        <div class="container-fluid">
            <div class="row">
                <%@include file="LeftBar.html" %>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard Mediathéque </h1>



                    <h2 class="sub-header">Liste des Adhérents </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>Nom</th>
                                    <th>Prenom</th>                                    
                                    <th>Numero Carte</th>  
                                    <th>Numero Compte</th> 
                               
                                    <th>Etat Compte</th> 
                                    <th>Fin validite Compte</th>
                                </tr>
                            </thead>
                            <tbody>                               

                                <%
                                    List<Adherent> list3 = (List) request.getSession().getAttribute("adherents");
                                    for (Adherent adherent : list3) {
                                        out.print("<tr class='success'>");
                                        out.print("<td></td>");

                                        out.print("<td>" + adherent.getId() + "</td>");
                                        out.print("<td>" + adherent.getNom() + "</td>");
                                        out.print("<td>" + adherent.getPrenom()+ "</td>");
                                        out.print("<td>" + adherent.getNumeroCarte()+ "</td>");

                                        out.print("<td>" + adherent.getCompte().getNumero()+ "</td>");
                                        out.print("<td>" + adherent.getCompte().isEtat()+ "</td>");
                                        out.print("<td>" + adherent.getCompte().getDateFinValidte()+ "</td>");                                        

                                        out.print("</tr>");

                                    }
                                %>     
                            </tbody>
                        </table>
                    </div>

                    <!-- ************************************************************************************** -->                                    

                    <h2 class="sub-header">Liste des Items </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Reference</th>
                                    <th>Titre</th>
                                    <th>Auteur</th>
                                    
                                </tr>
                            </thead>
                            <tbody>


                                <%
                                    List<Item> items = (List) request.getSession().getAttribute("items");
                                    for (Item item : items) {
                                        out.print("<tr class='info'>");
                                        out.print("<td></td>");
                                        
                                        out.print("<td>" + item.getReference() + "</td>");
                                        out.print("<td>" + item.getTitre()+ "</td>");
                                        out.print("<td>" + item.getAuteur()+ "</td>");
                                        out.print ("<td>"+"molka"+"</td>");
                                        out.print ("<td><a href='../EmployeeDeleteItem?reference="+item.getReference()+"'>REMOVE</td>");
                                     
                                      
                                        out.print("</tr>");

                                    }
                                %>     
                           

                            </tbody>
                        </table>
                               
                    </div>

                    <!-- ************************************************************************************** -->                                    




                    <h2 class="sub-header">Liste des Exemplaires </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>REFERENCE</th>
                                    <th>ETAT</th>
                                    <th>NOMBRE EMPRUNT</th>                                    
                                    <th>ITEM</th>                                    
                                    
                                </tr>
                            </thead>
                            <tbody>                               

                                <%
                                    List<Exemplaire> exemplaires = (List) request.getSession().getAttribute("exemplaires");
                                    for (Exemplaire exemplaire : exemplaires) {
                                        out.print("<tr class='danger'>");
                                        out.print("<td></td>");
                                        
                                        out.print("<td>" + exemplaire.getReference() + "</td>");
                                        out.print("<td>" + exemplaire.getEtat()+ "</td>");
                                        out.print("<td>" + exemplaire.getNb_emprunt()+ "</td>");
                                        out.print("<td>" + exemplaire.getItem().getReference() + "</td>");
                                        out.print ("<td><a href='../EmployeeAddExemplaire?type=Annulation&reference="+exemplaire.getReference()+"'>REMOVE</td>");
                                     
                                        out.print("</tr>");

                                    }
                                %>     



                            </tbody>
                        </table>
                    </div>

                    <!-- ************************************************************************************** -->                                    





                    <h2 class="sub-header">Liste des emprunts </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>NumeroEmprunt</th>
                                    <th>IdAdherent</th>
                                    <th>IdExemplaire</th>   
                                    <th>DateEmprunt</th> 
                                     <th> </th>
                                      <th> </th>
                                </tr>
                            </thead>
                            <tbody>                               

                                <%
                                    List<Emprunt> emprunts = (List) request.getSession().getAttribute("emprunts");
                                    for (Emprunt emprunt : emprunts) {
                                            out.print("<td></td>");
                                        out.print("<td>" + emprunt.getNumero() + "</td>");
                                        out.print("<td>" + emprunt.getAdherent().getId() + "</td>");
                                        out.print("<td>" + emprunt.getExemplaire().getReference() + "</td>");
                                        out.print("<td>" + emprunt.getDateEprunt() + "</td>");
                             out.print ("<td><a href='../EmployeeAddEmprunt?type=Validation&numero="+emprunt.getNumero()+"'>VALIDATE</td>");
                             out.print ("<td><a href='../EmployeeAddEmprunt?type=Annulation&numero="+emprunt.getNumero()+"'>REMOVE</td>");
                            
                                        out.print("</tr>");

                                    }
                                %>     

                            </tbody>
                        </table>
                    </div>

                    <!-- ************************************************************************************** -->                                    
                    <h2 class="sub-header">Liste des reservations </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Numero</th>
                                    <th>IdAdherent</th>
                                    <th>ReferenceItem</th>   
                                    <th>Quantite</th> 
                                    <th>Status</th>  
                                    
                                </tr>
                            </thead>
                            <tbody>                               

                                <%
                                    List<Reservation> reservations = (List) request.getSession().
                                            getAttribute("reservations");
                                    for (Reservation reservation : reservations) {
                                         out.print("<td></td>");
                                        out.print("<td>" + reservation.getNumero() + "</td>");
                                        out.print("<td>" + reservation.getAdherent().getId() + "</td>");
                                        out.print("<td>" + reservation.getItem().getReference() + "</td>");
                                        out.print("<td>" + reservation.getQuantité() + "</td>");
                                         out.print("<td>" + reservation.getStatus() + "</td>");
                            out.print ("<td><a href='../EmployeeAddReservation?type=Validation&numero="+reservation.getNumero()+"'>VALIDATE</td>");
                             out.print ("<td><a href='../EmployeeAddReservation?type=Annulation&numero="+reservation.getNumero()+"'>REMOVE</td>");
                                    
                                        out.print("</tr>");

                                    }
                                %>     
                            </tbody>
                        </table>
                    </div>




                    <!-- ************************************************************************************** -->                                    
                    <h2 class="sub-header">Liste des Fournisseurs </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>firstName</th>
                                    <th>LastName</th>                                    
                                </tr>
                            </thead>
                            <tbody>                               

                                <%
                                    List<Fournisseur> fournisseurs = (List) request.getSession().
                                            getAttribute("fournisseurs");
                                    for (Fournisseur fournisseur : fournisseurs) {
                                        out.print("<tr class='info'>");
                                        out.print("<td></td>");
                                        out.print("<td>" + fournisseur.getNumero_fournisseur() + "</td>");
                                        out.print("<td>" + fournisseur.getNom_fournisseur() + "</td>");
                                        out.print("<td></td>");
                                        out.print("</tr>");

                                    }
                                %>     
                            </tbody>
                        </table>
                    </div>



                    <!-- ************************************************************************************** -->                                    



                    <h2 class="sub-header">Liste des commandes </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>firstName</th>
                                    <th>LastName</th>                                    
                                </tr>
                            </thead>
                            <tbody>                               

                                <%
                                    List<BonDeCommande> commandes = (List) request.getSession().
                                            getAttribute("commandes");
                                    for (BonDeCommande commande : commandes) {
                                        out.print("<tr class='info'>");
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

                                      <h2 class="sub-header">Liste des Souhaits </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>ID</th>
                                    <th>DESCRIPTION</th>
                                    <th>ITEM_NAME</th>                                    
                                    <th>ITEM_TYPE</th>                                    
                                    
                                </tr>
                            </thead>
                            <tbody>                               

                                <%
                                    List<Souhait> souhaits = (List) request.getSession().getAttribute("souhaits");
                                    for (Souhait souhait : souhaits) {
                                        out.print("<tr class='danger'>");
                                        out.print("<td></td>");
                                        
                                        out.print("<td>" + souhait.getNumero()+ "</td>");
                                        out.print("<td>" + souhait.getDescription()+ "</td>");
                                        out.print("<td>" + souhait.getItemName()+ "</td>");
                                        out.print("<td>" + souhait.getItemType()+ "</td>");

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



