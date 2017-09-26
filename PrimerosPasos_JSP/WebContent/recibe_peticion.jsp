<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//leyendo datos del formulario
	String ciudad_favorita=request.getParameter("ciudad_favorita");
	
	//crear la cookie nombre valor
	//nomenclatura comun
	Cookie laCookie=new Cookie("agencia_viajes.ciudad_favorita", ciudad_favorita);
	
	//vida de la cookie definida en segundos
	laCookie.setMaxAge(365*24*60*60);
	//enviar a usuario
	
	response.addCookie(laCookie);
%>

Gracias por enviar tus preferencias
<a href="agencia_viajes.jsp">Ir a la agencia de viajes</a>
</body>
</html>