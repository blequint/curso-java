<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*" %>
<!-- permite prescindir de agregar el nombre de la clase
	//java.sql.Connection miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");

 -->
<%
	String usuario=request.getParameter("usuario");
	String contra=request.getParameter("contra");
	//especifica la ruta del driver

	Class.forName("com.mysql.jdbc.Driver");

	try{ //el try es opcional
		
	
	//java.sql.Connection miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
	Connection miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
	//prepara una consulta para evitar inyecciones
	PreparedStatement c_preparada=miConexion.prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND contrasena=?");
	//se definen los parametros
	c_preparada.setString(1, usuario);	
	c_preparada.setString(2, contra);
	//trae el arreglo de datos de la consulta
	ResultSet miResultset=c_preparada.executeQuery();
			
	if(miResultset.absolute(1)) out.println("Usuario autorizado");
	else out.println("No hay usuarios con esos datos");
		
	}catch(Exception e){
		out.println("Ha habido un error");
	}
%>
</body>
</html>