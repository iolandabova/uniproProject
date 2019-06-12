<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Prenotazione cancellata</title>
	</head>
	<body>
		<form method="post" action="./view/logInStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="esci" value="Logout"/>
			</div>
		</form>
		
		<form method="post" action="./view/accessoStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		 </form>
	
		<% 
			Utils.checkedLogged(request, response);
			
			Boolean esitoPrenotazione = (Boolean)request.getAttribute("esitoPrenotazione"); 
			
			if(esitoPrenotazione != null && esitoPrenotazione.booleanValue() == true) { %>
		
				<div>PRENOTAZIONE CANCELLATA</div>
		 <% } %>
	</body>
</html>