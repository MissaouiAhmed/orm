<%@page import="fr.polytech.orm.entities.Adherent"%>
<%@page import="fr.polytech.orm.entities.Exemplaire"%>
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
                  


                    <h2 class="sub-header">Emprunt Item</h2>
<form role="form" action="../EmployeeAddEmprunt" method="post">
                   <div class="form-group">
                             <label for="item">Exemplaire</label>
                             <select id="selecteditem" name="selectedexemplaire" >
                               <option value="" selected=""/>
                             
                                <%
                                    List<Exemplaire> exemplaires = (List) request.getSession().getAttribute("exemplaires");
                                    for (Exemplaire exemplaire : exemplaires) {
                                        if(exemplaire.getEtat().equals("Disponible")){
                                            out.print("<option value="+exemplaire.getReference()+">" + exemplaire.getReference() +
                                                "</option>");
                                        }
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
                         </div>
                        
                         
                        <input type="submit" value="Valider" />
                    </form>

                   
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
