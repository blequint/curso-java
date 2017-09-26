<!-- libreria para el array list -->
<%@ page import="java.util.*" %>
<html>

<body>
<form name="Formulario_Compra" action="Lista_Compra.jsp">
 
  <p>Artículos a comprar:</p>
  <p>
    <label>
      <input type="checkbox" name="articulos" value="agua " >
      Agua </label>
    <br>
    <label>
      <input type="checkbox" name="articulos" value="leche" >
      Leche </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="pan" >
      Pan </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="mazanas" >
      Manzanas </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="carne" >
      Carne </label>
      <br>
       <label>
      <input type="checkbox" name="articulos" value="pescado" >
      Pescado </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Enviar">
    <br>
  </p>
</form>
<h2>Carro de la compra: </h2>
<ul>

<%
//es necesario iniciar la variable
//es necesario hacer un casting para recibir un objets como una lista de string
//al principio no encontrara que misElementos hayan sido creados por lo que arrojara nulo
List<String> ListaElementos=(List<String>)session.getAttribute("misElementos");

//estas lineas solo las lee una vez
if(ListaElementos==null){
	ListaElementos=new ArrayList<String>();
	session.setAttribute("misElementos", ListaElementos);
}


//getParameter() nos devuelve un string
//getParameterValues() nos devuelve un array de tipo string

String[] elementos=request.getParameterValues("articulos");
if(elementos != null){
	for(String elemTemp : elementos){
		//out.println("<li>"+ elemTemp+"</li>");
		ListaElementos.add(elemTemp);
		
	}
}
for(String elemeTemp : ListaElementos){
	out.println("<li>"+elemeTemp+"</li>");
}
%>
</ul>
</body>
</html>