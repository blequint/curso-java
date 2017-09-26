package transacciones;

/*video 220
ERROR PENDIENTE POR INVESTIGAR
 * 
 * USO DE TRANSACCIONES*/



import java.sql.*;

import javax.swing.JOptionPane;

public class Transaccion_Productos {



	

		public static void main(String[] args) {
			// TODO Auto-generated method stub	
			
			Connection miConexion=null;
			try{					
					
				miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "admin");				
				//false da como inicitiva que se hara un grupo de sentencias, true las sentencias seran individuales
				
				miConexion.setAutoCommit(false);

				Statement miStatement =miConexion.createStatement();
							
			    String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN='ITALIA'";				    
			    String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO>300";			    
			    String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";
			    
			    boolean ejecutar=ejecutar_transaccion();
			    if(ejecutar){
					 miStatement.executeUpdate(instruccionSql_3);
			    	 miStatement.executeUpdate(instruccionSql_1);
					 miStatement.executeUpdate(instruccionSql_2);
					 miConexion.commit();
					 
					 System.out.println("Se ejecuto la transaccion correctamente");

			    }else{
			    	System.out.println("No se realizo cambio alguno en BBDD");
			    }
			    
			   
			    //se agrupan las sentencias sql. CONFIRMA EL GRUPO
			    				    
					
			}catch(Exception e){
				
				try {
					miConexion.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

					
				System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			
				
				e.printStackTrace();	
					
					
				}

			}
		static boolean ejecutar_transaccion(){
			String ejecucion=JOptionPane.showInputDialog("¿Ejecutamos transaccion?");
			if(ejecucion.equals("Si"))
			return true;
			else return false;
		}

		}


