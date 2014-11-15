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

                <div>
                    <h1 class="page-header">Dashboard Mediatheque </h1>


                    <h2 class="sub-header">Ajout Fournisseur</h2>

                    
                      <form role="form" action="../AddFournisseur" method="post">
                        <div class="form-group">
                            <label for="ID">ID</label>
                            <input type="text" class="form-control" id="ID" placeholder="ID" name="ID">
                        </div>
                        <div class="form-group">
                            <label for="FOUNISSEUR">NOM FOUNISSEUR</label>
                            <input type="text" class="form-control" id="FOUNISSEUR" placeholder="FOUNISSEUR" name="FOUNISSEUR">
                        </div>

                        <button type="submit" class="btn btn-default">ADD FOUNISSEUR</button>

                   
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
