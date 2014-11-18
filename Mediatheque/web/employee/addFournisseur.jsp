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
                    


                    <h2 class="sub-header">Ajout Fournisseur</h2>

                    <form action="../EmployeeAddFournisseur" method="post">
                        <table>
                            <tr><td>ID:</td><td><input type="text" id = "id" name="id" /></td></tr>
                            <tr><td>NOM FOUNISSEUR</td><td><input type="text" id = "Name" name="Name" /></td></tr>
                        </table>
                        <input type="submit" value="AddFournisseur" />
                    </form>

                   
                    </div>
                </div>
            </div>
       


    </body>
</html>
