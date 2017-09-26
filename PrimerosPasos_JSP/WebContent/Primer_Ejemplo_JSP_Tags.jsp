<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- importando libreria core -->

<%
	String alumnos[]={"Antonio", "Sandra", "Maria", "Paco"};
	//suponiendo que viene de un formulario lo estamos obteniendo
	pageContext.setAttribute("losAlumnos", alumnos);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
		//forma convencional de hacerlo no recomendada
		/*
		for(String tempAlumnos: alumnos)
			out.print(tempAlumnos + "<br>");
	*/
	%>	
	<!-- etiqueta, variable temporal, arreglo que recorreremos -->
	<c:forEach var="tempAlumnos" items="${losAlumnos}">
		${tempAlumnos}<br>
		
	</c:forEach>
</body>
</html>