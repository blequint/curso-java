package modelo;

import java.sql.*;


public class CargaMenus {
	public CargaMenus(){
		miConexion=new Conexion();
	}
	
	public String ejecutaConsultas(){
		Productos miProducto=null;
		Connection accesoBBDD=miConexion.getConexion();
		try{
			Statement secciones=accesoBBDD.createStatement();		
			Statement paises=accesoBBDD.createStatement();
			rs=secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			rs2=paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
			
			miProducto=new Productos();
			miProducto.setSeccion(rs.getString(1));
			miProducto.setpOrigen(rs2.getString(1));

			
			rs.close();
			rs2.close();
			accesoBBDD.close();
		}catch(Exception e){
			
		}
		return miProducto.getSeccion();
	}
	
	/*
	public ResultSet ejecutaConsultas(){
		Connection accesoBBDD=miConexion.getConexion();
		try {
			Statement secciones=accesoBBDD.createStatement();
			return rs=secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
		} catch (SQLException e) {
		}
		return null;
	}
	*/
	private Conexion miConexion;
	//publica para poder acceder a este desde otras partes
	public ResultSet rs; //secciones
	public ResultSet rs2; //paises
}
