<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "unipro.model.Esame" %>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Esami disponibili</title>
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
		
			ArrayList<Esame> listaEsami = (ArrayList<Esame>) request.getAttribute("listaEsami");
		%>
	
		<form method="post" action="http://localhost:8080/UniPro/RestituisciAppelliServlet">
			<select name="esameScelto">
			<option value="-">--scegli un esame--</option>
			<%
				for(Esame es : listaEsami) {
			%>
					<option value=<%=es.getIdEsame()%>><%=es.getNomeEsame()+" ( " + es.getCfu() + " CFU)" %>  </option>	
			<% 
				}
			%>
			</select>
			<input type="submit" name="invia" value="Ok"/>
		</form>
		<br><br>
		<form method="post" action="http://localhost:8080/UniPro/RicercaEsamiPerNomeServlet">
			<input type="text" name="ricercaEsame" value="Cerca">
			<input type="submit" name="invia" value="Ok"/>
		</form>
		
	</body>
</html>