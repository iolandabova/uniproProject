<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "unipro.model.Esame" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Piano di Studi</title>
	</head>
	<body>
		<% 
			ArrayList<Esame> listaEsami = (ArrayList<Esame>) request.getAttribute("listaEsami");
		%>
			<ul>
			<%
				for(Esame es : listaEsami) {
			%>
					<li><%=es.getNomeEsame()+" ( " + es.getCfu() + " CFU)" %></li>	
			<% 
				}
			%>
			</ul>
	</body>
</html>