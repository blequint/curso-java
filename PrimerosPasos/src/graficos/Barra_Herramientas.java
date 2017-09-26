/* video 111 BARRA DE HERRAMIENTAS
 * https://www.youtube.com/watch?v=E4m8vVHpojk&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=111
 * */
package graficos;
 

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Barra_Herramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco_Barra mimarco=new Marco_Barra();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Barra extends JFrame{
	
	public Marco_Barra(){
		
		setTitle("Marco con Barra");
		
		setBounds(500,300,600,450);
		
		lamina=new JPanel();
		
		add(lamina);
		
		// configuración de acciones
		
		Action accionAzul=new AccionColor2("Azul", new ImageIcon("src/graficos/bola_azul.gif"), Color.BLUE);
		
		Action accionAmarillo=new AccionColor2("Amarillo", new ImageIcon("src/graficos/bola_amarilla.png"), Color.YELLOW);
		
		Action accionRojo=new AccionColor2("Rojo", new ImageIcon("src/graficos/rojo.jpg"), Color.RED);
		
		Action accionSalir=new AbstractAction("Salir", new ImageIcon("src/graficos/close-icon.png")){
//clase interna anonima
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//cierra aplicacion
				System.exit(0);
			}
			
		};
		
	JMenu menu= new JMenu("Color");
	menu.add(accionAzul);
	menu.add(accionAmarillo);
	menu.add(accionRojo);
	
	JMenuBar barraMenu=new JMenuBar();
	barraMenu.add(menu);
	setJMenuBar(barraMenu);
	
	//contruccion de barra de herramientas
	JToolBar barra= new JToolBar();
	barra.add(accionAzul);
	barra.add(accionAmarillo);
	barra.add(accionRojo);
	barra.addSeparator();
	barra.add(accionSalir);
	
	//se debe de colocar el borderlayout para que podamos ubicarla y poderla ARRASTRAS
	add(barra, BorderLayout.NORTH);
		
		
		
		
	}
		
	
	private class AccionColor2 extends AbstractAction{
		
		public AccionColor2(String nombre, Icon icono, Color c){
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			
			putValue("Color", c);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			Color c=(Color) getValue("Color");
			
			lamina.setBackground(c);
			
		}		
		
	}
	private JPanel lamina;
}



