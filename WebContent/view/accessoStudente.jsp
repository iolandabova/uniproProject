<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Area Riservata</title>
	</head>
	<body>
		<% Object matricolaGrezza = session.getAttribute("utenteRegistrato");
		   String matricola = (String) matricolaGrezza;
		   Object nomeGrezzo = request.getAttribute("nomeStudente");
		   String nome = (String) nomeGrezzo;
		   Object cognomeGrezzo = request.getAttribute("cognomeStudente");
		   String cognome = (String) cognomeGrezzo;%>
		<h1 align="center" style="font-family:verdana; color:green;">Benvenuto nel sito <%= nome+" "+cognome+" "+ matricola %>!</h1>
		
		<ul>
			<li><a href="./RestituisciEsamiServlet"> Anagrafica Studente</a></li>
			<li><a href="./RestituisciPianoDiStudi"> Piano di Studi</a></li>
			<li><a href="./RestituisciEsamiServlet"> Prenotazione esame</a></li>
			<li><a href="./RestituisciAppelliPrenotatiServlet"> Esami prenotati</a></li>
		</ul>

	</body>
</html>