<%@page import="java.util.List"%>
<%@page import="fr.polytech.orm.entities.Item"%>
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
                    <h1 class="page-header">Dashboard Mediatheque </h1>


                    <h2 class="sub-header">Ajout Exemplaire</h2>

                    

                    
                     <form role="form" action="../EmployeeAddExemplaire" method="post">
                        <div class="form-group">
                            <label for="reference">reference</label>
                            <input type="text" class="form-control" id="reference" placeholder="reference" 
                                   name="reference">
                        </div>
                        <div class="form-group">
                             <label for="item">item</label>
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

                       
                        
                        <button type="submit" class="btn btn-default">add Exemplaire</button>
                    </form>
                   
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
