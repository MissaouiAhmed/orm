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
                <%@include file="../navigation/aLeftBar.html" %>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header"> Dashboard Adherent </h1>


                    <!-- ************************************************************************************** -->                                    

                  <h2 class="sub-header">Resultat Recherche </h2>
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
                                    Item item = (Item) request.getSession().getAttribute("item");
                                        out.print("<tr class='info'>");
                                        out.print("<td><a href='../#'>Reserver</a></td>");
                                        
                                        out.print("<td>" + item.getReference() + "</td>");
                                        out.print("<td>" + item.getTitre()+ "</td>");
                                        out.print("<td>" + item.getAuteur()+ "</td>");
                                        
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



