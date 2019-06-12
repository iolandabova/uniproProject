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
		
			ArrayList<Esame> listaEsami = (ArrayList<Esame>) request.getAttribute("listaEsami");
		%>
	
		<form method="post" action="./RestituisciAppelliServlet">
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
		<form method="post" action="./RicercaEsamiPerNomeServlet">
			<input type="text" name="ricercaEsame" value="Cerca">
			<input type="submit" name="invia" value="Ok"/>
		</form>
		
	</body>
</html>