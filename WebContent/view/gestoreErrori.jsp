<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.ErrorCodes" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Error</title>
		<style>
				
		  alert {
					text-align: center;
	    			position: fixed;
	   				width : 100%;
	   				font-family : "Cambria";
	   				font-size: 30px;
	   				color: #A00000;
	   				top: 300px;
				}
		</style>	
		<link rel = "stylesheet" href = "http://localhost:8080/UniPro/css/progetto.css" type = "text/css">
	</head>
	<body>
		<img src = "http://localhost:8080/UniPro/images/corona.png" width = "90px" height = "80px" hspace = "5px"/>
		<logo> UniPro </logo> <br>	
		
		<% Object errorGrezzo = request.getAttribute("codiceErrore");
		   int errore = (int) errorGrezzo; 	
		   
		   if(errore == ErrorCodes.WRONGLOGIN) { %>
		   
		   		<alert><b>Matricola o password errati!</b></alert>
		   		<form method="post" action="http://localhost:8080/UniPro/view/logInStudente.jsp">
		   			<div style="text-align:center; margin-top:280px">
						<input type="submit" name="invia" value="Riprova"/>
					</div>
		   		</form>
		   		
		<% } %> 
		
		<% 
		   if(errore == ErrorCodes.LOGINNOTMADE) { %>
		   
		   		<alert><b>Devi effettuare l'accesso!</b></alert>
		   		<form method="post" action="http://localhost:8080/UniPro/index.html">
		   			<div style="text-align:center; margin-top:280px">
						<input type="submit" name="invia" value="Effettua il Login"/>
					</div>
		   		</form>
		   		
		<% } %> 
		
		<% 
		   if(errore == ErrorCodes.WRONGLOGINAMM) { %>
		   
		   		<alert><b>Username o password errati!</b></alert>
		   		<form method="post" action="http://localhost:8080/UniPro/view/logInAmministratore.jsp">
		   			<div style="text-align:center; margin-top:280px">
						<input type="submit" name="invia" value="Riprova"/>
					</div>
		   		</form>
		   		
		<% } %> 
		
		<% 
		   if(errore == ErrorCodes.ALREADYENTERED) { %>
		   
		   		<alert><b>Studente già presente nel sistema!</b></alert>
		   		<form method="post" action="http://localhost:8080/UniPro/view/accessoAmministratore.jsp">
		   			<div style="text-align:center; margin-top:280px">
						<input type="submit" name="invia" value="Indietro"/>
					</div>
		   		</form>
		   		
		<% } %>
	</body>
</html>