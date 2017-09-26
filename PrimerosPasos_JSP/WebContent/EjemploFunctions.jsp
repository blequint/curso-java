<!-- Video 245 jstl jar jsp tags uso de functions -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- usaremos una funcion para recibir un string y pueda dividir los campos con la funcin de sript y tenerlo en diferentes filas del array
	 -->
	<c:set var="datos" value="Brenda, Quintanilla, Developer, 20000"  />
		<c:set var="datosArray" value="${fn:split(datos, ',') }" />
	<input type="text" value="${datosArray[0]}"><br>
	<input type="text" value="${datosArray[1]}"><br>
	<input type="text" value="${datosArray[2]}"><br>
	<input type="text" value="${datosArray[3]}">
</body>
</html>