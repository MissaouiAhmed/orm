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

                
                
                <div >
                    <!--<h1 class="page-header">Dashboard Mediathéque </h1>-->



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
                                    <th></th><th></th>
                                    <th><a href="addUser.jsp"><img src="../css/img/add-user-16x16.png"/></a> </th>
                                    
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
                                        
                                        out.print ("<td><a href='../EmployeeAdherentManagement?operation=remove&reference="+adherent.getId()+"'>REMOVE</td>");
                                        out.print ("<td><a href='../EmployeeAdherentManagement?operation=update&reference="+adherent.getId()+"'>UPDATE</td>");
                                     
                                        out.print("</tr>");

                                    }
                                %>     
                            </tbody>
                        </table>
                    </div>
                            
                    
      
                </div>
            </div>
        </div>


    </body>
</html>

  