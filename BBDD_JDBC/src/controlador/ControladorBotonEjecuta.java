package controlador;

import java.awt.event.*;
import java.sql.*;
import modelo.*;
import vista.*;


public class ControladorBotonEjecuta implements ActionListener {
	
	public ControladorBotonEjecuta(Marco_Aplicacion2 elmarco){
		this.elmarco=elmarco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		elmarco.resultado.setText("");
		String seleccionSeccion=(String)elmarco.secciones.getSelectedItem();
		String seleccionPais=(String)elmarco.paises.getSelectedItem();
		
		resultadoConsulta=obj.filtraBBDD(seleccionSeccion, seleccionPais);
		try{
		while(resultadoConsulta.next()){
			elmarco.resultado.append(resultadoConsulta.getString(1));
			elmarco.resultado.append(", ");
			elmarco.resultado.append(resultadoConsulta.getString(2));
			elmarco.resultado.append(", ");
			elmarco.resultado.append(resultadoConsulta.getString(3));
			elmarco.resultado.append(", ");
			elmarco.resultado.append(resultadoConsulta.getString(4));
			elmarco.resultado.append("\n");
			

		}
		}catch(Exception e2){}
	}
	private Marco_Aplicacion2 elmarco;
	EjecutaConsultas obj=new EjecutaConsultas();
	private ResultSet resultadoConsulta;
}
