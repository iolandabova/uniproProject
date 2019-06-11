<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %> 
<%@ page import = "unipro.model.dto.AppelloDTO" %>    
<%@ page import = "java.util.Date" %>  
<%@ page import = "java.text.SimpleDateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Appelli prenotati</title>
	</head>
	<body>
	
		<form method="post" action="./view/accessoStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		</form>	
		<% 
			ArrayList<AppelloDTO> listaAppelliPrenotati = (ArrayList<AppelloDTO>)request.getAttribute("listaAppelliPrenotati");	
			Boolean esitoCancellazione = (Boolean)request.getAttribute("esitoCancellazione");	
			String pattern = "dd-MM-yyyy kk:mm";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
		%>
		
		
			<table border="2">
			<%
			for(AppelloDTO ap : listaAppelliPrenotati) {
				String date = simpleDateFormat.format(ap.getData());
			%>	
				<tr>
					<form method="post" action="./CancellaPrenotazioneAppelloServlet">
						<td>
							<%=ap.getNomeEsame()+" "+ date +" "+ap.getAula()+" "+ap.getCognomeDocente()+" "+ap.getNomeDocente()%>
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
				
					<div>CANCELLAZIONE EFFETTUATA</div>
					
		<% } %>
	</body>
</html>