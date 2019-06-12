<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Accedi all'area riservata</title>
		<style>
			log {
				text-align: center;
    			position: relative;
   				 top: 130px;
			}
		</style>
		<link rel = "stylesheet" href = "http://localhost:8080/UniPro/css/progetto.css" type = "text/css">
	</head>
	<body>
		<% if(session!=null) {
				session.invalidate();
		   } %>
		<img src = "http://localhost:8080/UniPro/images/corona.png" width = "90px" height = "80px" hspace = "5px"/>
		<logo> UniPro </logo> <br>
		
		<form method="post" action="http://localhost:8080/UniPro/index.html">
		 	<div style="text-align:right;">
				<input type="submit" name="indietro" value="Indietro"/>
			</div>
		</form>
		
		<div>
			<log>
				<h1>Inserisci i tuoi dati</h1>
					<form method="post" action="http://localhost:8080/UniPro/LogInServlet">
					
						<a style = "font-family : Cambria; font-size : 20px"> Matricola </a> <br><br>
						<input type="text" name="matricola"/> <br><br>
						<a style = "font-family : Cambria; font-size : 20px"> Password </a> <br><br>
						<input type="password" name="pass"/> <br><br>
						<input type="submit" name="invia" value="Accedi"/> <br><br>
					</form>
			</log>
		</div>
	</body>
</html>