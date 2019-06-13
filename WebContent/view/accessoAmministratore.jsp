<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<style>
				log {
					text-align: center;
	    			position: fixed;
	   				width : 100%;
	   				font-family : "Cambria";
	   				font-size: 30px;
	   				top: 200px;
				}
		</style>
		
		<title>Area Riservata</title>
		<link rel = "stylesheet" href = "http://localhost:8080/UniPro/css/progetto.css" type = "text/css">
	</head>
	<body>
		<img src = "http://localhost:8080/UniPro/images/corona.png" width = "90px" height = "80px" hspace = "5px"/>
		<logo> UniPro </logo> <br>
		
		<form method="post" action="http://localhost:8080/UniPro/view/logInAmministratore.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="esci" value="Logout"/>
			</div>
		</form>
		<% 
			Utils.checkedLogged(request, response);	
		
		    String username = (String) session.getAttribute("utenteRegistrato");
		    String nomeAmm = (String) session.getAttribute("nomeAmministratore");
		    String cognomeAmm = (String) session.getAttribute("cognomeAmministratore"); %>
		   
		<log> <b> Benvenuto/a <%= nomeAmm+" "+cognomeAmm %></b></log>
		
		<ul> <br><br><br><br><br><br><br><br><br>
			<li><a href="http://localhost:8080/UniPro/view/formRegistrazioneStudente.jsp" style="font-size:20px"> Registra nuovo studente</a></li>
			<li><a href="http://localhost:8080/UniPro/view/cancellaStudentePerMatricola.jsp" style="font-size:20px"> Elimina studente dal sistema</a></li>
		</ul>

	</body>
</html>