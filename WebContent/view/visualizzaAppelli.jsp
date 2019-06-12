<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.util.ArrayList" %> 
<%@ page import = "unipro.model.dto.AppelloDTO" %>
<%@ page import="constraintsAndUtil.Utils" %> 
<%@ page import = "java.util.Date" %>  
<%@ page import = "java.text.SimpleDateFormat" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Appelli disponibili</title>
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
		
			ArrayList<AppelloDTO> listaAppelli = (ArrayList<AppelloDTO>)request.getAttribute("listaAppelli");
			Boolean esitoPrenotazione = (Boolean)request.getAttribute("esitoPrenotazione");
			String pattern = "dd-MM-yyyy kk:mm";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		%>
		
		<form method="post" action="http://localhost:8080/UniPro/PrenotaAppelloServlet">
			<table border="2">
			<%
			for(AppelloDTO ap : listaAppelli) {
				String date = simpleDateFormat.format(ap.getData());
			%>	
				<tr>
					<td>
						<input type="radio" name="appelloScelto" value=<%=ap.getIdAppello() %>  >
					</td>
					<td>
						<%=ap.getNomeEsame()+" "+date+" "+ap.getAula()+" "+ap.getCognomeDocente()+" "+ap.getNomeDocente()%>
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
					
					<div>PRENOTAZIONE non EFFETTUATA - Hai già prenotato quest'appello</div>
					
			<% } %>
		</form>
	</body>
</html>