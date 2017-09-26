package conectaBD;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		botonConsulta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ejecutaConsulta();				
			}
			
		});
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		/***************CONEXION CON BBDD *********************/
		
		try {
			/****CARGA JCOMBOBOX SECCIONES****/
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
			Statement sentencia=miConexion.createStatement();
			
			String consulta="SELECT DISTINCTROW SECCI�N FROM PRODUCTOS";
			ResultSet rs=sentencia.executeQuery(consulta);
			
			while(rs.next()){
				secciones.addItem(rs.getString(1));
			}
			rs.close();

			/****CARGA JCOMBOX PAISES****/
			consulta="SELECT DISTINCTROW PA�SDEORIGEN FROM PRODUCTOS";
			rs=sentencia.executeQuery(consulta);
			
			while(rs.next()){
				paises.addItem(rs.getString(1));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}
	//funcion encapsultada
	private void ejecutaConsulta(){
		ResultSet rs=null;
		try{
			//resetea el texto
			resultado.setText("");
			//elementos del combobox
			String seccion = (String) secciones.getSelectedItem();
			String pais=(String) paises.getSelectedItem();
			
			if(!seccion.equals("Todos") && pais.equals("Todos")){
					enviaConsultaSeccion=miConexion.prepareStatement(consultaSeccion);
					enviaConsultaSeccion.setString(1, seccion);
					rs=enviaConsultaSeccion.executeQuery();
					
			}else if(seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsultaPais=miConexion.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs=enviaConsultaPais.executeQuery();
				
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaTodos=miConexion.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs=enviaConsultaTodos.executeQuery();
			}else{
				enviaTodos=miConexion.createStatement();
				rs=enviaTodos.executeQuery("SELECT * FROM productos");
			}
			while(rs.next()){

				resultado.append(rs.getString(1));
				resultado.append(",");
				resultado.append(rs.getString(2));
				resultado.append(",");
				resultado.append(rs.getString(3));
				resultado.append(",");
				resultado.append(rs.getString(4));
				resultado.append("\n");
		}
			
		}catch(Exception e){
			e.getStackTrace();
		}
		
	
	}
	private Connection miConexion;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	private Statement enviaTodos;

	//no podra modificar el cont de la variable
	private final String consultaSeccion="SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N=?"; 
	private final String consultaPais="SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE PA�SDEORIGEN=?";
	private final String consultaTodos="SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N=? AND "
			+ "PA�SDEORIGEN=?";

	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	

	
}


