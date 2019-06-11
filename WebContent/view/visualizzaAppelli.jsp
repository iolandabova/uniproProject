<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.util.ArrayList" %> 
<%@ page import = "unipro.model.dto.AppelloDTO" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Appelli disponibili</title>
	</head>
	<body>
		<form method="post" action="./view/accessoStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		</form>
		<% 
			ArrayList<AppelloDTO> listaAppelli = (ArrayList<AppelloDTO>)request.getAttribute("listaAppelli");
			Boolean esitoPrenotazione = (Boolean)request.getAttribute("esitoPrenotazione");
		%>
		
		<form method="post" action="./PrenotaAppelloServlet">
			<table border="2">
			<%
			for(AppelloDTO ap : listaAppelli) {
			%>	
				<tr>
					<td>
						<input type="radio" name="appelloScelto" value=<%=ap.getIdAppello() %>  >
					</td>
					<td>
						<%=ap.getNomeEsame()+" "+ap.getData()+" "+ap.getAula()+" "+ap.getCognomeDocente()+" "+ap.getNomeDocente()%>
					</td>			
				</tr>
			<% 
			}
			%>
			</table>
			<input type="submit" name="invia" value="Prenota"/>
			<% if(esitoPrenotazione != null && esitoPrenotazione.booleanValue() == true) { %>
				
					<div>PRENOTAZIONE EFFETTUATA</div>
					
			<% } else if(esitoPrenotazione != null){ %>
					
					<div>PRENOTAZIONE non EFFETTUATA</div>
					
			<% } %>
		</form>
	</body>
</html>