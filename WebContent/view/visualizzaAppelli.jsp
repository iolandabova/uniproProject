<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.util.ArrayList" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Appelli disponibili</title>
	</head>
	<body>
		<% 
			ArrayList<String> idAppelli = (ArrayList<String>)request.getAttribute("idAppelli");
			ArrayList<String> idEsami = (ArrayList<String>)request.getAttribute("idEsami");
			ArrayList<String> date = (ArrayList<String>)request.getAttribute("date");
			ArrayList<String> aule = (ArrayList<String>)request.getAttribute("aule");
			ArrayList<String> datiDocente = (ArrayList<String>)request.getAttribute("datiDocente");	
		%>
		
		<table border="5">
		<%
		for(int i=0; i < idEsami.size(); i++) {
		%>	
			<tr>
				<td>
					<input type="radio" name="appelloScelto" value=<%=idAppelli.get(i) %>  >
				</td>
				<td>
					<%=idEsami.get(i) %>
				</td>
				
				<td>
					<%=date.get(i) %>
				</td>
				
				<td>
					<%=aule.get(i) %>
				</td>
				
				<td>
					<%=datiDocente.get(i) %>
				</td>						
			</tr>
		
		<% 
		}
		
		
		%>
		
		</table>

	</body>
</html>