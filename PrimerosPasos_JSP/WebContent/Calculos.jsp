<%@ page import="pildorasinformaticas.com.CalculosMatematicos.*" %>

<!-- Para importar paquetes  -->
<html>
<body>
<!--  paquete, clase, metodo -->
La suma de 5 y 7 es: <%= Calculos.metodoSuma(5, 7) %>
<br> <!-- pildorasinformaticas.com.CalculosMatematicos.Calculos.metodoSuma(5, 7) cuando no se importa el paquete -->
La resta de 5 y 7 es: <%= Calculos.metodoResta(5, 7) %>
<br>
La multiplicacion de 5 y 7 es: <%= Calculos.metodoMultiplica(5, 7) %>


</body>
</html>