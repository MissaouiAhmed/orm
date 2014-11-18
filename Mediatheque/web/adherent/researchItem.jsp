<%-- 
    Document   : researchItem
    Created on : 12 nov. 2014, 09:07:59
    Author     : BENATHMANE
--%>

<%@page import="fr.polytech.orm.entities.Reservation"%>
<%@page import="fr.polytech.orm.entities.Item"%>
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
            <div class="row">
                <%--<%@include file="../navigation/aLeftBar.html" %>--%>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                   <center><h1 class="page-header"> Dashboard Adherent </h1></center>


                    <h2 class="sub-header">Research Item</h2>
                    <h6>Veuillez inserer les critéres de votre recherche :</h6>
                    <!--<form action="../ResearchItem" method="post">
                        <table>
                            <div class="form-group">
                            <tr><td>Titre de l'item : </td><td>&nbsp;&nbsp;<input type="text" id = "titreitem" name="titreitem" /></td></tr>
                            <tr><td>Auteur de l'item : </td><td>&nbsp;&nbsp;<input type="text" id = "auteuritem" name="auteuritem" /></td></tr>
                        </table>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form>-->
                    
                        <form action="../ResearchItem" method="post" class="form-inline" role="form">
                            <div class="form-group">
                                <div class="input-group">
                                    <label class="sr-only">Titre Item</label>
                                    <div class="input-group-addon">@Titre Item</div>
                                    <input type="text" class="form-control" id = "titreitem" name="titreitem"
                                           placeholder="Enter Titre Item"> </div>
                                <label class="sr-only">Auteur Item</label>
                                <div class="input-group-addon">@Auteur Item</div>
                                    <input type="text" id = "auteuritem" name="auteuritem"  class="form-control"
                                           placeholder="Enter Auteur"> </div>
                            </div> 
                            <button type="submit" class="btn btn-default">Search</button>
                        </form>

                    

                    <h6><I>* Si vous ne trouverez pas votre item, vous pouvez contacter un employee en exprimant votre souhait et il sera pris en compte, Merci</I></h6>
                   
                   
                
                <!-- ************************************************************************************** -->                                    

                    <h2 class="sub-header">Liste des Items </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Titre</th>
                                    <th>Auteur</th>
                                    <th>Date de disposition</th>
                                </tr>
                            </thead>
                            <tbody>


                                <%
                                    List<Item> items = (List) request.getSession().getAttribute("items");
                                    for (Item item : items) {
                                        out.print("<tr class='info'>");
                                        
                                    boolean dejareserve = false;
                                        
                                        for (Reservation reservation : ad.getReservations()){
                                            out.print(reservation);
                                            dejareserve = reservation.getItem().equals(item);
                                            break;
                                        }
                                        
                                        if (dejareserve) {
                                            out.print("<td>Already booked</td>");
                                        } else {
                                            out.print("<td><a href='../ReserverItem?operation=reserver&reference=" + item.getReference() + "'>RESERVER</td>");
                                        }
                                        
                                        out.print("<td>" + item.getTitre()+ "</td>");
                                        out.print("<td>" + item.getAuteur()+ "</td>");
                                        out.print("<td>" + item.getDateDispostion()+ "</td>");
                                        out.print("</tr>");

                                    }
                                %>     

                            </tbody>
                        </table>
                    </div>

                 </div>
                </div>
            </div>
        </div>


    </body>
</html>

