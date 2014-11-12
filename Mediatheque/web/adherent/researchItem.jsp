<%-- 
    Document   : researchItem
    Created on : 12 nov. 2014, 09:07:59
    Author     : BENATHMANE
--%>

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
                <%@include file="../navigation/aLeftBar.html" %>
                <!-- --------------------------------------------------------------- -->          

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard Adherent </h1>


                    <h2 class="sub-header">Research Item</h2>

                    <form action="../ResearchItem" method="post">
                        <table>
                            <tr><td>Item : </td><td><input type="text" id = "item" name="item" /></td></tr>
                        </table>
                        <input type="submit" value="CreateRecord" />
                    </form>

                   
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>

