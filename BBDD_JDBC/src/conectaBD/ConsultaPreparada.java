/**VIDEO 205*/
package conectaBD;

import java.sql.*;
public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//PASO 1 CONEXION
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
			//PASO 2 PREPARAR QUERY
			PreparedStatement miSentencia=miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS"
			+" WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
			
			//PASO 3 ESTABLECER PARAMETROS DE CONSULTA
			//orden , texto
			miSentencia.setString(1, "deportes");
			miSentencia.setString(2, "USA");
			
			//PASO 4 EJECUTAR Y RECORRER QUERY
			ResultSet rs=miSentencia.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
			//REUTILIZACION DE QUERY
			System.out.println("EJECUCION SEGUNDA CONSULTA");
			System.out.println("");
			
			miSentencia.setString(1, "CERÁMICA");
			miSentencia.setString(2, "CHINA");
			
			//PASO 4 EJECUTAR Y RECORRER QUERY
			 rs=miSentencia.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
