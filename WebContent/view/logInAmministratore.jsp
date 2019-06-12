<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Accedi all'area riservata</title>
	</head>
	<body>
		<% if(session!=null) {
				session.invalidate();
		   } %>
		
		<form method="post" action="http://localhost:8080/UniPro/index.html">
		 	<div style="text-align:right;">
				<input type="submit" name="indietro" value="Indietro"/>
			</div>
		</form>
		
		<h1 align="center">Inserisci i tuoi dati</h1>
		<form method="post" action="http://localhost:8080/UniPro/LogInAmministratoreServlet">
				<div style="text-align:center;">
					Username <br><br>
					<input type="text" name="username"/> <br><br>
					Password <br><br>
					<input type="password" name="password"/> <br><br>
					<input type="submit" name="invia" value="Accedi"/> <br><br>
				</div>
		</form>
	</body>
</html>