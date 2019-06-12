<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registra nuovo studente</title>
	</head>
	<body>
		<form method="post" action="http://localhost:8080/UniPro/view/logInAmministratore.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="esci" value="Logout"/>
			</div>
		</form>
		<br>
		<form method="post" action="http://localhost:8080/UniPro/view/accessoAmministratore.jsp">
		   	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		</form>
		
		<% Utils.checkedLogged(request, response); %>
		
		<h1 align="center">Registra nuovo studente</h1>
		<h2 align="center">Inserisci i dati in MAIUSCOLO </h2>
		<form method="post" action="http://localhost:8080/UniPro/RegistrazioneStudenteServlet">
			<div style="text-align:left;">
				
				Matricola 
				<input type="text" name="matricola" value="N69000---"/> <br><br>
				Nome 
				<input type="text" name="nome"/> 
				Cognome 
				<input type="text" name="cognome"/> <br><br>
				Sesso 
				<input type="text" name="sesso"/> 
				Data di nascita
				<input type="text" name="nascita" value="DD-MMM-AA"> <br><br>
				Indirizzo
				<input type="text" name="indirizzo"/> 
				Città 
				<input type="text" name="citta"/> <br><br>
				Email 
				<input type="text" name="email" value="nomestudente@UNIPRO.IT"/> <br><br>
				Password
				<input type="text" name="password" value="nomestudenteAA"/> <br><br>
				<input type="submit" name="invia" value="Registra"/> <br><br>
			</div>
		</form>

	</body>
</html>