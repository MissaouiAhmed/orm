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
                <%@include file="../navigation/LeftBar.html" %>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard Mediatheque </h1>


                    <h2 class="sub-header">Ajout Adherent</h2>

                    <form role="form" action="../AddAdherent" method="post">
                        <div class="form-group">
                            <label for="PRENOM">PRENOM</label>
                            <input type="text" class="form-control" id="PRENOM" placeholder="PRENOM" name="PRENOM">
                        </div>
                        <div class="form-group">
                            <label for="NOM">NOM</label>
                            <input type="text" class="form-control" id="NOM" placeholder="NOM" name="NOM">
                        </div>

                        <div class="form-group">
                            <label for="PASSWORD">PASSWORD</label>
                            <input type="text" class="form-control" id="PASSWORD" placeholder="PASSWORD" name="PASSWORD">
                        </div>
                        <div class="form-group">
                            <label for="LOGIN">LOGIN</label>
                            <input type="text" class="form-control" id="LOGIN" placeholder="LOGIN" name="LOGIN">
                        </div>
                        
                        <div class="form-group">
                            <label for="AGE">AGE</label>
                            <input type="text" class="form-control" id="AGE" placeholder="AGE" name="AGE">
                        </div>
                        <div class="form-group">
                            <label for="lieu">LIEUX DE NAISSANCE</label>
                            <input type="text" class="form-control" id="lieu" placeholder="lieu" name="lieu">
                        </div>
                        <div class="form-group">
                            <label for="COMPTEID">COMPTE ID</label>
                            <input type="text" class="form-control" id="COMPTEID" placeholder="COMPTEID" name="COMPTEID">
                        </div>
                        <div class="form-group">
                            <label for="MONTANT">MONTANT</label>
                            <input type="text" class="form-control" id="MONTANT" placeholder="MONTANT" name="MONTANT">
                        </div>

                       
                        
                        
                        <button type="submit" class="btn btn-default">add Adherent</button>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
