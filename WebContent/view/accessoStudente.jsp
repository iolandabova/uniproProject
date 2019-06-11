<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Area Riservata</title>
	</head>
	<body>
		<% 
		   String matricola = (String) session.getAttribute("utenteRegistrato");
		   String nome = (String) request.getAttribute("nomeStudente");
		   String cognome = (String) request.getAttribute("cognomeStudente"); %>
		   
		<h1 align="center" style="font-family:verdana; color:green;">Benvenuto nel sito <%= nome+" "+cognome+" "+ matricola %>!</h1>
		
		<ul>
			<li><a href="./RestituisciAnagraficaStudenteServlet"> Anagrafica Studente</a></li>
			<li><a href="./RestituisciPianoDiStudiServlet"> Piano di Studi</a></li>
			<li><a href="./RestituisciEsamiServlet"> Prenotazione esame</a></li>
			<li><a href="./RestituisciAppelliPrenotatiServlet"> Esami prenotati</a></li>
		</ul>

	</body>
</html>