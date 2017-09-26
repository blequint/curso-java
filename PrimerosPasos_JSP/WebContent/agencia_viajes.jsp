<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">Agencia de viajes </h1>

<%
	//valor por defecto
	String ciudad_favorita="Madrid";

	//lee la cookie de la peticion del navegador
	
	Cookie[] lasCookies=request.getCookies();
	
	//Buscar las preferencias. La ciudad favorita
	//solo si hay cookie creada
	if(lasCookies!=null){
		for(Cookie cookie_temporal : lasCookies){
			//si corresponde la cookie que estamos buscando con alguna del arreglo que tenemos
			if("agencia_viajes.ciudad_favorita".equals(cookie_temporal.getName())){
				ciudad_favorita=cookie_temporal.getValue();
				//se sale del codigo una vez que lo encuentra
				break;
				
			}
		}
	}
%>
<h3>Vuelos a <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo </p>
<p>Esto es un texto de ejemplo </p>
<p>Esto es un texto de ejemplo </p>

<h3>Hoteles a <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo </p>
<p>Esto es un texto de ejemplo </p>
<p>Esto es un texto de ejemplo </p>

<h3>Descuentos a <%= ciudad_favorita %></h3>

<p>Esto es un texto de ejemplo </p>
<p>Esto es un texto de ejemplo </p>
<p>Esto es un texto de ejemplo </p>

</body>
</html>