<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ricerca studente</title>
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
		
		<% Utils.checkedLogged(request, response); 
		   Boolean esitoCancellazione = (Boolean)request.getAttribute("esitoCancellazioneStudente"); %>
		
		<form method="post" action="http://localhost:8080/UniPro/CancellaStudentePerMatricolaServlet">
			Inserire la matricola dello studente da rimuovere dal sistema <br><br>
			<input type="text" name="eliminaMatricola" value="N69000---">
			<input type="submit" name="invia" value="Ok"/>
		</form>
		
		<% if(esitoCancellazione != null && esitoCancellazione.booleanValue() == true) { %>
				
					<div>STUDENTE ELIMINATO DAL SISTEMA</div>
					
		<% } else if(esitoCancellazione != null) { %>
					
					<div>OPERAZIONE non RIUSCITA - Matricola non presente nel sistema</div>
					
		<% } %>
	</body>
</html>