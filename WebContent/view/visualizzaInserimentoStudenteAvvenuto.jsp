<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inserimento studente avvenuto</title>
	</head>
	<body>
		<form method="post" action="http://localhost:8080/UniPro/view/logInAmministratore.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="esci" value="Logout"/>
			</div>
		</form>
		
		<% Utils.checkedLogged(request, response); %>
		
		<h2 align="center">Studente inserito correttamente nel sistema</h2>
		   		<form method="post" action="http://localhost:8080/UniPro/view/accessoAmministratore.jsp">
		   			<div style="text-align:center;">
						<input type="submit" name="invia" value="Torna al menu principale"/>
					</div>
		   		</form>
	</body>
</html>