/*video 76*/

package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class MultiplesFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion mimarco=new MarcoAccion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class MarcoAccion extends JFrame{
	public MarcoAccion(){
		setTitle("Prueba Acciones");
		setBounds(600,350,600,300);
		PanelAccion lamina=new PanelAccion();
		add(lamina);
	}
}
class PanelAccion extends JPanel{
	public PanelAccion(){
		URL rutaAmarillo=PanelAccion.class.getResource("graficos/bola_amarilla.png");
		URL rutaAzul=PanelAccion.class.getResource("graficos/bola_azul.gif");
		URL rutaRojo=PanelAccion.class.getResource("graficos/rojo.jpg");
		AccionColor accionAmarillo=new AccionColor("Amarillo",new ImageIcon(rutaAmarillo), Color.yellow);
		AccionColor accionAzul=new AccionColor("Azul",new ImageIcon(rutaAzul), Color.blue);
		AccionColor accionRoja=new AccionColor("Rojo",new ImageIcon(rutaRojo), Color.red);
		
	/*	JButton botonAmarillo=new JButton(accionAmarillo);
		add(botonAmarillo);
		*/
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRoja));
		/*
		JButton botonAmarillo=new JButton("Amarillo");
		JButton botonAzul=new JButton("Azul");
		JButton botonRojo=new JButton("Rojo");
		add(botonAmarillo);
		add(botonAzul);
		add(botonRojo);
		*/
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");

		
		ActionMap mapaAccion=getActionMap();
		mapaAccion.put("fondo_amarillo",accionAmarillo );
		mapaAccion.put("fondo_azul",accionAzul);
		mapaAccion.put("fondo_rojo",accionRoja );
		
		
	}
	private class AccionColor extends AbstractAction{

		public AccionColor(String nombre, Icon icono, Color color_boton){
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color "+nombre);
			putValue("color_de_fondo", color_boton);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c=(Color)getValue("color_de_fondo");
			setBackground(c);
			System.out.println("Nombre: "+getValue(Action.NAME)+" Descripcion: "+getValue(Action.SHORT_DESCRIPTION));
		}
		
	}
}

