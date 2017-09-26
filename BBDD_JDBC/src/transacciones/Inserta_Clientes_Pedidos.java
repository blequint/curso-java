/*video 220
ERROR PENDIENTE POR INVESTIGAR
 * 
 * USO DE TRANSACCIONES*/

package transacciones;

import java.sql.*;

public class Inserta_Clientes_Pedidos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Connection miConexion=null;
		try{					
				
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "admin");				
			//false da como inicitiva que se hara un grupo de sentencias, true las sentencias seran individuales
			
			miConexion.setAutoCommit(false);

			Statement miStatement =miConexion.createStatement();
						
		    String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			    
		    miStatement.executeUpdate(instruccionSql_1);
			    
		    String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
			    
		    miStatement.executeUpdate(instruccionSql_2);
		    
		    //se agrupan las sentencias sql. CONFIRMA EL GRUPO
		    miConexion.commit();
		    				    
		    System.out.println("Datos INSERTADOS correctamente");
				
		}catch(SQLException e){
				
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			
			try {
				//es necesario el rollback cuando el setautocommit es false
				miConexion.rollback();
				System.out.println("ROLLBACK");
				;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("no esta retornando los cambios");
			}
			
			e.printStackTrace();	
				
				
			}

		}

	}

