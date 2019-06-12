<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "unipro.model.Esame" %>
<%@ page import="constraintsAndUtil.Utils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Piano di Studi</title>
	</head>
	<body>
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
		
			//ArrayList<Esame> listaEsami = (ArrayList<Esame>) request.getAttribute("listaEsami");
		%>
		<!--	<ul>
			<%--
				for(Esame es : listaEsami) {
			%>
					<li><%=es.getNomeEsame()+" ( " + es.getCfu() + " CFU)" %></li>	
			<% 
				}
			--%>
			</ul> -->
			<ul>
				<c:forEach var="esame" items="${listaEsami}">
					<div>
						<li> ${esame.nomeEsame.concat(' (' ).concat(esame.cfu).concat(' CFU)')} </li>
					</div>
				</c:forEach>
			</ul>
	</body>
</html>