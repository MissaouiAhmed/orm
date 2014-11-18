<%@page import="fr.polytech.orm.entities.Adherent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                    <%
                    Adherent ad = (Adherent) request.getSession().getAttribute("ad");
                    %>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
                    data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="../adherent/consultmyinfos.jsp"><% out.print("Welcome " + ad.getNom()); %></a>
              
            
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a class="navbar-brand" href="../indexAdherent">Home</a></li>
                <li><a href="../aDashboard">Dashboard</a></li>
                <li><a href="../Presearch">Search Item</a></li>
                <li><a href="../adherent/addSouhait.jsp">Add wishes</a></li>
                <li><a href="../adherent/consultmyinfos.jsp">Consult my infos</a></li>
                <li><a href="../index.jsp">Signout</a></li>
            </ul>
           
        </div>
    </div>
</nav>     
