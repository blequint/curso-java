package modelo;

import java.sql.*;

public class EjecutaConsultas {
	public EjecutaConsultas(){
		miConexion=new Conexion();
	}
	
	public ResultSet filtraBBDD(String seccion, String pais){
		Connection conecta=miConexion.getConexion();
		rs=null;
		try{
			if(!seccion.equals("Todos") && pais.equals("Todos")){
				enviaConsultaSeccion=conecta.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1, seccion);
				rs=enviaConsultaSeccion.executeQuery();
				
			}else if(seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsultaPais=conecta.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs=enviaConsultaPais.executeQuery();
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsultaTodos=conecta.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs=enviaConsultaTodos.executeQuery();
			}else {
				enviaTodos=conecta.createStatement();
				rs=enviaTodos.executeQuery("SELECT * FROM productos");
			}
			
		}catch(Exception e){}
		return rs;
	}
	private String pruebas;
	private Conexion miConexion;
	private ResultSet rs;
	private Statement enviaTodos;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;

	private final String consultaSeccion="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private final String consultaPais="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private final String consultaTodos="SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=? ";

}
