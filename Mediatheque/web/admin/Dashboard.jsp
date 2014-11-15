<%@page import="fr.polytech.orm.entities.Employee"%>
<%@page import="fr.polytech.orm.entities.BonDeCommande"%>
<%@page import="fr.polytech.orm.entities.Fournisseur"%>
<%@page import="fr.polytech.orm.entities.Reservation"%>
<%@page import="fr.polytech.orm.entities.Emprunt"%>
<%@page import="fr.polytech.orm.entities.Exemplaire"%>
<%@page import="fr.polytech.orm.entities.Item"%>
<%@page import="fr.polytech.orm.entities.Adherent"%>
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
            <div >
                <%--<%@include file="../navigation/LeftBar.html" %>--%>
                <!-- --------------------------------------------------------------- -->          
                <div id="carousel-example-generic" class="carousel slide "
                     data-ride="carousel" data-interval="2000" >
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1" ></li>
    <!--                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>-->
                    </ol>
                    <div class="carousel-inner">

                        <div class="item active">
                            <img src="../css/img/2013_mediatheque.jpg" alt="..."  />
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img src="../css/img/mediatheque.JPG" alt="..."/> 
                            <div class="carousel-caption">
                            </div>
                        </div>
<!--                        <div class="item">
                            <img src="../css/img/im2.jpg" alt="..."/> 
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img src="../css/img/im4.jpg" alt="..."  />
                            <div class="carousel-caption">
                            </div>
                        </div>-->
                        </div>
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>


            </div>
        </div>
    </div>


</body>
</html>

