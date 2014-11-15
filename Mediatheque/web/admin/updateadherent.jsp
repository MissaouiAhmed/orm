<%@page import="fr.polytech.orm.entities.Adherent"%>
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
            <div>
                <%--<%@include file="../navigation/LeftBar.html" %>--%>
                <!-- --------------------------------------------------------------- -->          

                <!-- Wrapper for slides -->
  
                                <%
                                    Adherent adherent = (Adherent) request.getSession().getAttribute("adherent");
                                    
                                %> 
                
                <div>
                    <h1 class="page-header"> </h1>


                    <h2 class="sub-header">Update adherent Adherent</h2>

                    <form role="form" action="../UpdateAdherent" method="post">
                        
                        <div class="form-group">
                            <label for="ID">ID</label>
                            <% out.print("<input type='text' class='form-control' id='ID' value='"+adherent.getId()+"' name='ID' readonly>"); %>
                        </div>
                        <div class="form-group">
                            <label for="PRENOM">PRENOM</label>
                            <% out.print("<input type='text' class='form-control' id='PRENOM' placeholder='"+adherent.getPrenom()+"' name='PRENOM'>"); %>                        
                        </div>
                        <div class="form-group">
                            <label for="NOM">NOM</label>
                            <% out.print("<input type='text' class='form-control' id='NOM' placeholder='"+adherent.getNom()+"' name='NOM'>"); %>
                        
                        </div>

                        <div class="form-group">
                            <label for="PASSWORD">PASSWORD</label>
                            <% out.print("<input type='text' class='form-control' id='PASSWORD' placeholder='"+adherent.getPassword()+"' name='PASSWORD'>"); %>
                       
                        </div>
                        <div class="form-group">
                            <label for="LOGIN">LOGIN</label>
                             <% out.print("<input type='text' class='form-control' id='LOGIN' placeholder='"+adherent.getLogin()+"' name='LOGIN'>"); %>
                       
                        </div>
                        
                        <div class="form-group">
                            <label for="AGE">AGE</label>
                            <% out.print("<input type='text' class='form-control' id='AGE' placeholder='"+adherent.getAge()+"' name='AGE'>"); %>
                       
                        </div>
                        <div class="form-group">
                            <label for="lieu">LIEUX DE NAISSANCE</label>
                             <% out.print("<input type='text' class='form-control' id='lieu' placeholder='"+adherent.getLieuNaissance()+"' name='lieu'>"); %>
                       
                        </div>
                        <div class="form-group">
                            <label for="MONTANT">MONTANT</label>
                            <% out.print("<input type='text' class='form-control' id='MONTANT' placeholder='"+adherent.getCompte().getSolde()+"' name='MONTANT'>"); %>
                       
                        </div>

                       
                        
                        
                        <button type="submit" class="btn btn-default">update Adherent</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
