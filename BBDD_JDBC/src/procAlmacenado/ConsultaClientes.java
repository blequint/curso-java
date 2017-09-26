/*video 118
 * STORED PROCEDIUS para paises de barcelona
 * crear procedimiento en phpmyadmin
 * create procedure MUESTRA_CLIENTES()
 * select * from clientes where poblacion='barcelona'
 * */
package procAlmacenado;

import java.sql.*;

public class ConsultaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			CallableStatement miSentencia=miConexion.prepareCall("{call MUESTRA_CLIENTES}");
			ResultSet rs=miSentencia.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1)+ " "+rs.getString(2)+" "+rs.getString(3));
				
			}
			rs.close();
		}catch(Exception e){
			
		}
	}

}
