<!-- https://www.youtube.com/watch?v=KeX8lj8R-2o&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=243
video 243 JSP TAGS III y 244 para c:if
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="java.util.*, java.sql.*, pildorasinformaticas.com.jsptags.Empleado" %>
	<%
		ArrayList<Empleado> datos=new ArrayList<>();
		//especifica la ruta del driver
		Class.forName("com.mysql.jdbc.Driver");
		try{
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_jsp", "root","admin");
			Statement miStatement=miConexion.createStatement();
			String instruccionSql="SELECT * FROM empleados";
			ResultSet rs=miStatement.executeQuery(instruccionSql);
			
			while(rs.next()){
				datos.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
				
			}
			rs.close();
			miConexion.close();
			
			
		}catch(Exception e){
			out.println("Ha habido un error");
		}
		pageContext.setAttribute("losEmpleados", datos);
	%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.cabecera{
font-weight:bold;}
</style>
</head>
<body>
<table border="1">
	<tr class="cabecera"> <td>Nombre</td><td> Apellido</td><td>Puesto</td><td>Salario</td><td>Bonus</td>
	<c:forEach var="EmpTemp" items="${losEmpleados}">
		<tr>
			<td>${EmpTemp.nombre} </td><td>${EmpTemp.apellido}</td><td> ${EmpTemp.puesto} </td>
			<td>
			<c:if test="${EmpTemp.salario<14000}">
				${EmpTemp.salario+5000}
			</c:if>
			<c:if test="${EmpTemp.salario>=14000}">
				${EmpTemp.salario}
			</c:if>
			</td>
			
			<!-- Aumentara 5000 aquellos que tengan un sueldo menor de 15000 -->
			<!-- variable a condicionar -->
			<td>
			<c:if test="${EmpTemp.salario<14000}">5000</c:if>
			<c:if test="${EmpTemp.salario>14000}">-----</c:if>
			</td>
			<!-- otra etiqueta equivalente a swich es c:choose -->
		</tr>
	</c:forEach>
	
</body>
</html>