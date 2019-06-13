<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ricerca studente</title>
		<style>
			log {
					text-align: center;
	    			position: fixed;
	   				width : 100%;
	   				font-family : "Cambria";
	   				font-size: 30px;
	   				top: 180px;
				}
				
		  alert {
					text-align: center;
	    			position: fixed;
	   				width : 100%;
	   				font-family : "Cambria";
	   				font-size: 20px;
	   				color: #A00000;
	   				top: 500px;
				}
		</style>	
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
		<br>
		<form method="post" action="http://localhost:8080/UniPro/view/accessoAmministratore.jsp">
		   	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		</form>
		
		<% Utils.checkedLogged(request, response); 
		   Boolean esitoCancellazione = (Boolean)request.getAttribute("esitoCancellazioneStudente"); %>
		   
		<log> <b>Elimina studente dal sistema </b> </log>
		
		<br><br><br><br><br><br><br>
		
		<form method="post" action="http://localhost:8080/UniPro/CancellaStudentePerMatricolaServlet">
			<h2>Inserire la matricola dello studente da rimuovere dal sistema</h2> <br>
			<input type="text" name="eliminaMatricola" value="N69000---">
			<input type="submit" name="invia" value="Ok"/>
		</form>
		
		<% if(esitoCancellazione != null && esitoCancellazione.booleanValue() == true) { %>
				
					<alert><b>STUDENTE ELIMINATO DAL SISTEMA</b></alert>
					
		<% } else if(esitoCancellazione != null) { %>
					
					<alert><b>OPERAZIONE non RIUSCITA - Matricola non presente nel sistema</b></alert>
					
		<% } %>
	</body>
</html>