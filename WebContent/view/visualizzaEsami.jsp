<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Esami disponibili</title>
	</head>
	<body>
		<% 
			ArrayList<String> idEsami = (ArrayList<String>) request.getAttribute("idEsami");
			ArrayList<String> nomiEsami = (ArrayList<String>) request.getAttribute("nomiEsami");
			ArrayList<Integer> cfuEsami = (ArrayList<Integer>) request.getAttribute("cfuEsami");
		%>
	
		<form method="post" action="./RestituisciAppelliServlet">
			<select name="esameScelto">
			<option value="-">--scegli un esame--</option>
			<%
				for(int i = 0; i< idEsami.size(); i++) {
			%>
					<option value=<%=idEsami.get(i)%>><%=nomiEsami.get(i)+" ( " + cfuEsami.get(i) + " CFU)" %>  </option>	
			<% 
				}
			%>
			</select>
			<input type="submit" name="invia" value="Ok"/>
		</form>
	</body>
</html>