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
        <%@include file="../navigation/adherentTopMenu.jsp" %>

        <div class="container-fluid">
            <div>
                <%--<%@include file="../navigation/aLeftBar.html" %>--%>
                <!-- --------------------------------------------------------------- -->          

                <div>
                    <center><h1 class="page-header"> Dashboard Adherent </h1></center>
                    <!-- ************************************************************************************** -->                                    
                        
                    
                    <h2 class="sub-header"> Liste de mes informations </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nom</th>
                                    <th>Prenom</th>
                                    <th>LieudeNaissance</th>
                                    <th>Age</th>
                                    <th>dateAhesion</th>
                                    <th>numeroCarte</th>
                                    <th>numeroCompte</th>                                    
                                    <th>dateFinValidte</th> 
                                    <th>solde</th>   
                                    <th>etat</th>   
                                    
                                </tr>
                            </thead>
                            <tbody>              
                                <%
                                     out.print("<tr class='danger'>");
                                        out.print("<td></td>");
                                        
                                        out.print("<td>" + ad.getNom() + "</td>");                               
                                        out.print("<td>" + ad.getPrenom() + "</td>");                                
                                        out.print("<td>" + ad.getLieuNaissance() + "</td>");
                                        out.print("<td>" + ad.getAge()+ "</td>");
                                        out.print("<td>" + ad.getDateAhesion() + "</td>");                                      
                                        out.print("<td>" + ad.getNumeroCarte() + "</td>");
                                        out.print("<td>" + ad.getCompte().getNumero()+ "</td>");
                                        out.print("<td>" + ad.getCompte().getDateFinValidte()+ "</td>");
                                        out.print("<td>" + ad.getCompte().getSolde()+ "</td>");
                                        out.print("<td>" + ad.getCompte().isEtat() + "</td>");
                                        out.print("</tr>");

                                    
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



