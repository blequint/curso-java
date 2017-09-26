<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
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
	String nombre=request.getParameter("nombre");
	String apellido=request.getParameter("apellido");
	String contra=request.getParameter("contra");
	String usuario=request.getParameter("usuario");
	String pais=request.getParameter("pais");
	String tecno=request.getParameter("tecnologias");
	//especifica la ruta del driver

	Class.forName("com.mysql.jdbc.Driver");

	try{ //el try es opcional
		
	
	//java.sql.Connection miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
	Connection miConexion=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root", "");
	Statement miStatement=miConexion.createStatement();
	String instruccionSql="INSERT INTO usuarios(nombre, apellido, usuario, contrasena, pais, tecnologia) VALUES ( '"+nombre+"','"+apellido+"','"+usuario+"','"+contra+"','"+pais+"','"+tecno+"')";
	miStatement.executeUpdate(instruccionSql);
	out.println("Registrado con exito");
	}catch(Exception e){
		out.println("Ha habido un error");
	}
%>
</body>
</html>