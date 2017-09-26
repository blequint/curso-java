package conectaBD;

import java.sql.*;

public class ModificaBD {
public static void main(String[] args){
	try{
		//PASO 1: CREAR CONEXION
		/*con la instruccion sql: SHOW VARIABLES WHERE VARIABLE_NAME IN('hostname','port') se obtiene el hostname
		 * y el puerto que tiene el servidor mysql*/
		Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
		
		//PASO 2: CREAR OBJETO STATEMENT PARA HACER EL QUERY
		Statement miStatement=miConexion.createStatement();
		
		//PASO 3: EJECUTAR SQL
		//AGREGAR: // String query="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES('AR77', 'PANTALÓN', 25.35)";
		//EDITAR: // String query="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
		String query="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";

		miStatement.executeUpdate(query);
		System.out.println("Datos ELIMINADOS correctamente");
	
	}catch(Exception e){
		System.out.println("No conecta!!");
		e.printStackTrace(); //imprime una pista de lo que ha ocurrido
	}
}

}

