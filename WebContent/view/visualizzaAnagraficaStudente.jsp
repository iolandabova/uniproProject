<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="unipro.model.Studente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Anagrafica Studente</title>
	</head>
	<body>
		<form method="post" action="./view/accessoStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		 </form>
	
		<% Studente s = (Studente) request.getAttribute("datiStudente"); %>
		
		MATRICOLA 
		<input type="text" name="matricola" value="<%= s.getMatricola() %>" readonly/> <br><br>
		NOME
		<input type="text" name="nome" value="<%= s.getNome() %>" readonly/> <br><br>
		COGNOME
		<input type="text" name="cognome" value="<%= s.getCognome() %>" readonly/> <br><br>
		SESSO
		<input type="text" name="sesso" value="<%= s.getSesso() %>" readonly/> <br><br>
		DATA DI NASCITA
		<input type="text" name="nascita" value="<%= s.getDataNascita() %>" readonly/> <br><br>
		RESIDENTE IN
		<input type="text" name="indirizzo" value="<%= s.getIndirizzo() %>" readonly/> <br><br>
		CITTA'
		<input type="text" name="citta" value="<%= s.getCitta() %>" readonly/> <br><br>
		EMAIL
		<input type="text" name="email" value="<%= s.getEmail() %>" readonly/> <br><br>
		 
	</body>
</html>