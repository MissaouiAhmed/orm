<%@page import="fr.polytech.orm.entities.Souhait"%>
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
        <link href="../css/adherentcss.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/docs.min.js"></script>
    </head>

    <body>
        
        <%@include file="../navigation/adherentTopMenu.jsp" %>

        <div class="container-fluid">
            <div>
                <%--<%@include file="../navigation/aLeftBar.html" %>--%>
                <!-- --------------------------------------------------------------- -->
                <div id="wrapper">
	<h1><small>Top 3 Nouveautés</small></h1>
	<div id="content">
		<ul id="movieposters">
			<li>
				<img src="../css/img/1.jpg" alt="Chassé croisé" />
				<div class="movieinfo">
					<h3>Chassé croisé</h3>
					<p>Présente-t-on encore Largo Winch, l'aventurier milliardaire le plus populaire de la ...</p>
					<a href="http://livre.fnac.com/a7229042/Largo-Winch-Tome-19-Chasse-croise-Philippe-Francq" title="Chassé croisé">More info</a>
				</div>
			</li>
			<li>
				<img src="../css/img/2.jpg" alt="Le suicide français" />
				<div class="movieinfo">
					<h3>Le suicide français</h3>
					<p>Les Français ont perdu confiance. Ils ont le sentiment que le pays fait fausse route ...</p>
					<a href="http://livre.fnac.com/a7510120/Eric-Zemmour-Le-suicide-francais" title="Le suicide français">More info</a>
				</div>
			</li>
			<li>
				<img src="../css/img/3.jpg" alt="Le Scorpion" />
				<div class="movieinfo">
					<h3>Le Scorpion</h3>
					<p>Tome 11 La neuvième famille ...</p>
                                        <a href="http://livre.fnac.com/a7616250/Le-Scorpion-Tome-11-La-neuvieme-famille-Enrico-Marini" title="Le Scorpion">More info</a>
				</div>
                            </li>
                        </ul>
                  </div>
                </div>
            </div>
        </div>
                <!-- --------------------------------------------------------------- -->



    </body>
</html>



