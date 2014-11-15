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
                <%@include file="../navigation/aLeftBar.html" %>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header"> Dashboard Adherent </h1>
                    <%
                    Adherent ad = (Adherent) request.getSession().getAttribute("ad");
                    %>
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

                                        out.print("</tr>");

                                    }
                                %>     



                            </tbody>
                        </table>
                    </div>

                    <!-- ************************************************************************************** -->                                    
                    
                    <h2 class="sub-header">Liste de mes Souhaits </h2>
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
                                    //List<Souhait> souhaits = (List) request.getSession().getAttribute("souhaits");
                                    List<Souhait> souhaits = (List) ad.getSouhaits();
                                    for (Souhait souhait : souhaits) {
                                        out.print("<tr class='danger'>");
                                        out.print("<td></td>");
                                        
                                        out.print("<td>" + souhait.getNumero()+ "</td>");
                                        //out.print("<td>" + souhait.getAdherent() + "</td>");
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
                    
                    <h2 class="sub-header"> Liste de mes reservations </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Numero</th>
                                    <th>ReferenceItem</th>
                                    <th>Quantite</th>                                    
                                    <th>Status</th>                                    
                                    
                                </tr>
                            </thead>
                            <tbody>              
                                <%
                                List<Reservation> reservations = (List) ad.getReservations();
                                for (Reservation reservation : reservations) {
                                     out.print("<tr class='danger'>");
                                        out.print("<td></td>");
                                        
                                        out.print("<td>" + reservation.getNumero()+ "</td>");
                                        out.print("<td>" + reservation.getItem().getReference()+ "</td>");
                                        out.print("<td>" + reservation.getQuantité()+ "</td>");
                                        out.print("<td>" + reservation.getStatus()+ "</td>");

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



