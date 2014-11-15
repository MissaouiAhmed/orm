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
        <%@include file="../navigation/adherentTopBar.html" %>


        <div class="container-fluid">
            <div class="row">
                <%--<%@include file="../navigation/aLeftBar.html" %>--%>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                   <center><h1 class="page-header"> Dashboard Adherent </h1></center>


                    <h2 class="sub-header">Ajout Souhait</h2>

                    <form role="form" action="../AddSouhait" method="post">
                        <div class="form-group">
                            <label for="reference">DESCRIPTION</label>
                            <textarea  type="text" class="form-control" id="description" placeholder="Saisir une Description"
                                       name="description"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="titre">ITEM NAME</label>
                            <input type="text" class="form-control" id="ITEM_NAME" placeholder="Nom de l'Iterm" name="ITEM_NAME">
                        </div>

                        <div class="form-group">
                            <label for="auteur">ITEM TYPE</label>
                            <input type="text" class="form-control" id="ITEM_TYPE" placeholder="Type de l'Item" name="ITEM_TYPE">
                        </div>
                        
                        
                        <button type="submit" class="btn btn-default">add Souhait</button>
                    </form>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
