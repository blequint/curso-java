/*video 202
 * */

package conectaBD;

import java.sql.*;

public class Conecta_Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//PASO 1: CREAR CONEXION
			/*con la instruccion sql: SHOW VARIABLES WHERE VARIABLE_NAME IN('hostname','port') se obtiene el hostname
			 * y el puerto que tiene el servidor mysql*/
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
			
			//PASO 2: CREAR OBJETO STATEMENT PARA HACER EL QUERY
			Statement miStatement=miConexion.createStatement();
			
			//PASO 3: EJECUTAR SQL
			ResultSet result=miStatement.executeQuery("SELECT * FROM productos");
		
			//PASO 4: RECORRER EL RESULTSET
			while(result.next()){
				System.out.println(result.getString("NOMBREARTÕCULO")+" "+result.getString("CÛDIGOARTÕCULO")+" "+result.getDouble("PRECIO")*2+" "+result.getDate("FECHA") );
			}
		}catch(Exception e){
			System.out.println("No conecta!!");
			e.printStackTrace(); //imprime una pista de lo que ha ocurrido
		}
	}

}
