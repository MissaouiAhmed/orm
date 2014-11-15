<%@page import="fr.polytech.orm.entities.Employee"%>
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
                                    Employee employee = (Employee) request.getSession().getAttribute("employee");
                                    
                                %> 
                
                <div>
                    <h1 class="page-header"> </h1>


                    <h2 class="sub-header">Update adherent Adherent</h2>

                    <form role="form" action="../UpdateEmployee" method="post">
                        
                        <div class="form-group">
                            <label for="ID">ID</label>
                            <% out.print("<input type='text' class='form-control' id='ID' value='"+employee.getId()+"' name='ID' readonly>"); %>
                        </div>
                        <div class="form-group">
                            <label for="PRENOM">PRENOM</label>
                            <% out.print("<input type='text' class='form-control' id='PRENOM' placeholder='"+employee.getPrenom()+"' name='PRENOM'>"); %>                        
                        </div>
                        <div class="form-group">
                            <label for="NOM">NOM</label>
                            <% out.print("<input type='text' class='form-control' id='NOM' placeholder='"+employee.getNom()+"' name='NOM'>"); %>
                        
                        </div>

                        <div class="form-group">
                            <label for="PASSWORD">PASSWORD</label>
                            <% out.print("<input type='text' class='form-control' id='PASSWORD' placeholder='"+employee.getPassword()+"' name='PASSWORD'>"); %>
                       
                        </div>
                        <div class="form-group">
                            <label for="LOGIN">LOGIN</label>
                             <% out.print("<input type='text' class='form-control' id='LOGIN' placeholder='"+employee.getLogin()+"' name='LOGIN'>"); %>
                       
                        </div>
                        
                        <div class="form-group">
                            <label for="AGE">AGE</label>
                            <% out.print("<input type='text' class='form-control' id='AGE' placeholder='"+employee.getAge()+"' name='AGE'>"); %>
                       
                        </div>
                        <div class="form-group">
                            <label for="lieu">LIEUX DE NAISSANCE</label>
                             <% out.print("<input type='text' class='form-control' id='lieu' placeholder='"+employee.getLieuNaissance()+"' name='lieu'>"); %>
                       
                        </div>
                       
                       
                        
                        
                        <button type="submit" class="btn btn-default">update employee</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
