<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Area Riservata</title>
	</head>
	<body>
		<form method="post" action="./view/logInAmministratore.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="esci" value="Logout"/>
			</div>
		</form>
		<% 
			Utils.checkedLogged(request, response);	
		
		    String username = (String) session.getAttribute("utenteRegistrato");
		    String nomeAmm = (String) session.getAttribute("nomeAmministratore");
		    String cognomeAmm = (String) session.getAttribute("cognomeAmministratore"); %>
		   
		<h1 align="center" style="font-family:verdana; color:green;">Benvenuto nel sito <%= nomeAmm+" "+cognomeAmm %>!</h1>
		
		<ul>
			<li><a href="http://localhost:8080/UniPro//formRegistrazioneStudente.html"> Registra nuovo studente</a></li>
		</ul>

	</body>
</html>