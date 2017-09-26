<html>
<body>
<h2>Objetos predefinidos JSP</h2>
<!-- Hace una solicitud de los datos del navegador -->
Peticion datos del navegador: <%= request.getHeader("User-Agent") %>

<br><br>
<!-- Hace una solicitud del idioma -->
Peticion idioma utilizado: <%= request.getLocale() %>
</body>
</html>