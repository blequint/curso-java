/*video 119
 stored procedius
 crear procedimiento en phpmyadmin:
 
 CREATE PROCEDURE ACTUALIZA_PRODD(N_PRECIO INT, N_ART VARCHAR(20))

UPDATE PRODUCTOS SET PRECIO=N_PRECIO WHERE NOMBREARTÍCULO=N_ART;
 */
package procAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class Actualiza_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nPrecio=Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
		String nArticulo=JOptionPane.showInputDialog("Introduce nombre de articulo");
		
		try{
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			CallableStatement miSentencia=miConexion.prepareCall("{call ACTUALIZA_PROD(?,?)}");
			
			miSentencia.setInt(1,nPrecio);
			miSentencia.setString(2, nArticulo);
			
			miSentencia.execute();
			System.out.println("Actualizacion okey");
			
		}catch(Exception e){
			System.out.println("ERROR");
		}
		
	}

}
