<%@page import="fr.polytech.orm.entities.Adherent"%>
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
        <%@include file="../navigation/TopBar.html" %>


        <div class="container-fluid">
            <div class="row">
               
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                   


                    <h2 class="sub-header">Reservation</h2>

                    <form action="../EmployeeAddReservation" method="post">
                        <div class="form-group">
                             <label for="item">Item</label>
                             <select id="selecteditem" name="selecteditem" >
                               <option value="" selected=""/>
                             
                                <%
                                    List<Item> items = (List) request.getSession().getAttribute("items");
                                    for (Item item : items) {
                                        out.print("<option value="+item.getReference()+">" + item.getReference() +
                                                "</option>");
                            
                                    }
                                %>     
                                
                                
                            </select>
                         </div>
                                
                                 <div class="form-group">
                             <label for="item">Adherent</label>
                             <select id="selecteditem" name="selectedadehrent" >
                               <option value="" selected=""/>
                             
                                <%
                                    List<Adherent> adherents = (List) request.getSession().getAttribute("adherents");
                                    for (Adherent adherent : adherents) {
                                        out.print("<option value="+adherent.getId()+">" + adherent.getId() +
                                                "</option>");
                            
                                    }
                                %>     
                                
                            </select>
                         
                        <input type="submit" value="ADD" />
                    </form>

                   
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
