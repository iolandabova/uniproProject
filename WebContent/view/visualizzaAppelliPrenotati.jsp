<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %> 
<%@ page import = "unipro.model.dto.AppelloDTO" %>    
<%@ page import = "java.util.Date" %>  
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import="constraintsAndUtil.Utils" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Appelli prenotati</title>
		<style>
			log {
					text-align: center;
	    			position: fixed;
	   				width : 100%;
	   				font-family : "Cambria";
	   				font-size: 30px;
	   				top: 180px;
				}
				
		  alert {
					text-align: center;
	    			position: fixed;
	   				width : 100%;
	   				font-family : "Cambria";
	   				font-size: 20px;
	   				color: #A00000;
	   				top: 600px;
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
		
			ArrayList<AppelloDTO> listaAppelliPrenotati = (ArrayList<AppelloDTO>)request.getAttribute("listaAppelliPrenotati");	
			Boolean esitoCancellazione = (Boolean)request.getAttribute("esitoCancellazione");	
			String pattern = "dd-MM-yyyy kk:mm";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
		%>
			<log> <b>Elenco esami prenotati </b> </log>
		
			<br><br><br><br><br><br><br>
		
			<table border="2">
			<%
			for(AppelloDTO ap : listaAppelliPrenotati) {
				String date = simpleDateFormat.format(ap.getData());
			%>	
				<tr>
					<form method="post" action="http://localhost:8080/UniPro/CancellaPrenotazioneAppelloServlet">
						<td>
							<%=ap.getNomeEsame()+" "+ date +" aula "+ap.getAula()+" "+ap.getCognomeDocente()+" "+ap.getNomeDocente()%>
							<input type="hidden" name="idAppello" value=<%=ap.getIdAppello() %>>
						
						</td>
						<td>
							<input type="submit" name="invia" value="cancella"/>
						</td>
					</form>			
				</tr>
			<% 
			}
			%>
			</table>
		
		<% if(esitoCancellazione != null && esitoCancellazione.booleanValue() == true) { %>
				
					<alert><b>PRENOTAZIONE CANCELLATA</b></alert>
					
		<% } %>
	</body>
</html>