//clase que llena las secciones al abrir la aplicacion mediante un oyente
package controlador;

import java.awt.event.*;
import vista.*;
import modelo.*;

//para evitar usar una interfaz que me oblique a usar todos los metodos se
//usaba una clase adaptadora 
public class ControladorCargaMenus extends WindowAdapter {
	public ControladorCargaMenus(Marco_Aplicacion2 elmarco){
		this.elmarco=elmarco;
	}
	public void windowOpened(WindowEvent e){
		//arreglo de cada una de las secciones
		obj.ejecutaConsultas();
		
		try{
			while(obj.rs.next()){
				elmarco.secciones.addItem(obj.rs.getString(1));
			}
			while(obj.rs2.next()){
				elmarco.paises.addItem(obj.rs2.getString(1));
			}
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
		
	}
	CargaMenus obj=new CargaMenus();
	private Marco_Aplicacion2 elmarco;
}
