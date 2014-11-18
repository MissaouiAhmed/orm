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
                    <center><h2 class="page-header"> Dashboard Adherent </h2></center>


                    <!-- ************************************************************************************** -->                                    

                    <h2 class="sub-header">Resultat Recherche </h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Titre</th>
                                    <th>Auteur</th>
                                </tr>
                            </thead>
                            <tbody>


                                <%
                                    List<Item> items = (List) request.getSession().getAttribute("item");
                                    for (Item item : items) {
                                        out.print("<tr class='info'>");
                                        
                                        
                                        
                                        boolean dejareserve = false;
                                        
                                        for (Reservation reservation : ad.getReservations()){
                                            //out.print(reservation);
                                            dejareserve = reservation.getItem().equals(item);
                                            break;
                                        }
                                        
                                        if (dejareserve) {
                                            out.print("<td>Already booked</td>");
                                        } else {
                                            out.print("<td><a href='../ReserverItem?operation=reserver&reference=" + item.getReference() + "'>RESERVER</td>");
                                        }
                                        
                                        
                                        
                                        
                                        out.print("<td>" + item.getTitre() + "</td>");
                                        out.print("<td>" + item.getAuteur() + "</td>");

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



