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
                <%@include file="LeftBar.html" %>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard Mediatheque </h1>


                    <h2 class="sub-header">Delete Item</h2>

                    <form role="form" action="../EmployeeDeleteItem" method="post">
                        <div class="form-group">
                            <label for="reference">reference</label>
                            <input type="text" class="form-control" id="reference" placeholder="reference"
                                   name="reference">
                        </div>
                        <div class="form-group">
                            <label for="titre">titre</label>
                            <input type="text" class="form-control" id="titre" placeholder="titre" name="titre">
                        </div>

                        <div class="form-group">
                            <label for="auteur">auteur</label>
                            <input type="text" class="form-control" id="auteur" placeholder="auteur" name="auteur">
                        </div>
                        
                        
                        <button type="submit" class="btn btn-default">delete Item</button>
                    </form>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
