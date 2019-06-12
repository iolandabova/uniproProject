<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.ErrorCodes" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Error</title>
	</head>
	<body>
		<% Object errorGrezzo = request.getAttribute("codiceErrore");
		   int errore = (int) errorGrezzo; 	
		   
		   if(errore == ErrorCodes.WRONGLOGIN) { %>
		   
		   		<h2 align="center" style="color:red">Matricola o password errati!</h2>
		   		<form method="post" action="http://localhost:8080/UniPro/view/logInStudente.jsp">
		   			<div style="text-align:center;">
						<input type="submit" name="invia" value="Riprova"/>
					</div>
		   		</form>
		   		
		<% } %> 
		
		<% 
		   if(errore == ErrorCodes.LOGINNOTMADE) { %>
		   
		   		<h2 align="center" style="color:red">Devi effettuare l'accesso!</h2>
		   		<form method="post" action="http://localhost:8080/UniPro/index.html">
		   			<div style="text-align:center;">
						<input type="submit" name="invia" value="Effettua il Login"/>
					</div>
		   		</form>
		   		
		<% } %> 
		
		<% 
		   if(errore == ErrorCodes.WRONGLOGINAMM) { %>
		   
		   		<h2 align="center" style="color:red">Username o password errati!</h2>
		   		<form method="post" action="http://localhost:8080/UniPro/view/logInAmministratore.jsp">
		   			<div style="text-align:center;">
						<input type="submit" name="invia" value="Riprova"/>
					</div>
		   		</form>
		   		
		<% } %> 
		
		<% 
		   if(errore == ErrorCodes.ALREADYENTERED) { %>
		   
		   		<h2 align="center" style="color:red">Studente già presente nel sistema!</h2>
		   		<form method="post" action="http://localhost:8080/UniPro/view/accessoAmministratore.jsp">
		   			<div style="text-align:center;">
						<input type="submit" name="invia" value="Indietro"/>
					</div>
		   		</form>
		   		
		<% } %>
	</body>
</html>