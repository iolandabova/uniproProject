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
		<form method="post" action="http://localhost:8080/UniPro/view/logInStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="esci" value="Logout"/>
			</div>
		</form>
		<% 
			Utils.checkedLogged(request, response);	
		
		    String matricola = (String) session.getAttribute("utenteRegistrato");
		    String nome = (String) session.getAttribute("nomeStudente");
		    String cognome = (String) session.getAttribute("cognomeStudente"); %>
		   
		<h1 align="center" style="font-family:verdana; color:green;">Benvenuto nel sito <%= nome+" "+cognome+" "+ matricola %>!</h1>
		
		<ul>
			<li><a href="http://localhost:8080/UniPro/RestituisciAnagraficaStudenteServlet"> Anagrafica Studente</a></li>
			<li><a href="http://localhost:8080/UniPro/RestituisciPianoDiStudiServlet"> Piano di Studi</a></li>
			<li><a href="http://localhost:8080/UniPro/RestituisciEsamiServlet"> Prenota esame</a></li>
			<li><a href="http://localhost:8080/UniPro/RestituisciAppelliPrenotatiServlet"> Esami prenotati</a></li>
		</ul>

	</body>
</html>