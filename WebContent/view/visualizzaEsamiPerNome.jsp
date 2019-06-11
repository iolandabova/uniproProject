<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "unipro.model.Esame" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista Esami</title>
	</head>
	<body>
		<form method="post" action="./view/accessoStudente.jsp">
		 	<div style="text-align:right;">
				<input type="submit" name="invia" value="Torna al menu principale"/>
			</div>
		</form>
		
		<% 
			ArrayList<Esame> listaEsami = (ArrayList<Esame>) request.getAttribute("listaEsamiPerNome");
		%>
	
		<form method="post" action="./RestituisciAppelliServlet">
			
			<table border="2">
			<%
			for(Esame es : listaEsami) {
			%>	
				<tr>
					<td>
						<input type="radio" name="esameScelto" value=<%=es.getIdEsame() %>  >
					</td>
					<td>
						<%=es.getNomeEsame()+" ( " + es.getCfu() + " CFU)" %>
					</td>			
				</tr>
			<% 
			}
			%>
			</table>
			
			
			<input type="submit" name="invia" value="Ok"/>
		</form>
	</body>
</html>