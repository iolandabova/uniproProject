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
		   
		   		<h2 align="center" style="color:red">Nome utente o password errati!</h2>
		   		<form method="post" action="logInStudente.html">
		   			<div style="text-align:center;">
						<input type="submit" name="invia" value="Riprova"/>
					</div>
		   		</form>
		   		
		<% } %> 
	</body>
</html>