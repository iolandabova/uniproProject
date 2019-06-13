<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "unipro.model.Esame" %>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista Esami</title>
		<style>
			log {
					text-align: center;
	    			position: fixed;
	   				width : 100%;
	   				font-family : "Cambria";
	   				font-size: 30px;
	   				top: 180px;
				}
				
		</style>	
		<link rel = "stylesheet" href = "http://localhost:8080/UniPro/css/progetto.css" type = "text/css">
	</head>
	<body>
		<img src = "http://localhost:8080/UniPro/images/corona.png" width = "90px" height = "80px" hspace = "5px"/>
		<logo> UniPro </logo> <br>
		
		<form method="post" action="http://localhost:8080/UniPro/view/logInStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="esci" value="Logout"/>
			</div>
		</form>
		<br>
		<form method="post" action="http://localhost:8080/UniPro/view/accessoStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		</form>
		
		<% 
			Utils.checkedLogged(request, response);
		
			ArrayList<Esame> listaEsami = (ArrayList<Esame>) request.getAttribute("listaEsamiPerNome");
		%>
		
		<log> <b>Prenota esame </b> </log>
		
		<br><br><br><br><br><br><br>
	
		<form method="post" action="http://localhost:8080/UniPro/RestituisciAppelliServlet">
			
			<table border="2">
			<%
			for(Esame es : listaEsami) {
			%>	
				<tr>
					<td>
						<input type="radio" name="esameScelto" value=<%=es.getIdEsame() %>  >
					</td>
					<td>
						<%=es.getNomeEsame()+" ( " + es.getCfu() + " CFU)" %>
					</td>			
				</tr>
			<% 
			}
			%>
			</table> <br>
			<input type="submit" name="invia" value="Prenota"/>
		</form>
	</body>
</html>