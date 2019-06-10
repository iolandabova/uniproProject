<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %> 
<%@ page import = "unipro.model.dto.AppelloDTO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Appelli prenotati</title>
	</head>
	<body>
		
		<% 
			ArrayList<AppelloDTO> listaAppelliPrenotati = (ArrayList<AppelloDTO>)request.getAttribute("listaAppelliPrenotati");	
		%>
		
		<form method="post" action="./RestituisciAppelliPrenotatiServlet">
			<table border="2">
			<%
			for(AppelloDTO ap : listaAppelliPrenotati) {
			%>	
				<tr>
					<td>
						<%=ap.getNomeEsame()+" "+ap.getData()+" "+ap.getAula()+" "+ap.getCognomeDocente()+" "+ap.getNomeDocente()%>
					</td>			
				</tr>
			<% 
			}
			%>
			</table>
		</form>
	</body>
</html>