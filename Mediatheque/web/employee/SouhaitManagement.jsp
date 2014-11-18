<%@page import="fr.polytech.orm.entities.Souhait"%>
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

                <h2 class="sub-header">Liste des Souhaits </h2>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Numero Souhaits</th>
                                <th>Description</th>
                                <th></th>  

                            </tr>
                        </thead>
                        <tbody>                               

                            <%
                                List<Souhait> souhaits = (List) request.getSession().
                                        getAttribute("souhaits");
                                for (Souhait souhait : souhaits) {
                                  
                                    out.print("<td></td>");
                                    
                                    out.print("<td>" + souhait.getNumero() + "</td>");
                                    out.print("<td>" + souhait.getDescription() + "</td>");
                                    out.print("</tr>");

                                }
                            %>     
                        </tbody>
                    </table>
                </div>



            </div>
        </div>
    

</body>
</html>

