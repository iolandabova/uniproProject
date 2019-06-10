<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "unipro.model.Esame" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Esami disponibili</title>
	</head>
	<body>
		<% 
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
	</body>
</html>