
package graficos;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class VariosOyentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPrincipal mimarco=new MarcoPrincipal();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class MarcoPrincipal extends JFrame{
	public MarcoPrincipal(){
		setTitle("Prueba varios");
		setBounds(1300,100,300,200);
		LaminaPrincipal lamina=new LaminaPrincipal();
		add(lamina);
	}
}
class LaminaPrincipal extends JPanel{
	public LaminaPrincipal(){
		JButton botonNuevo=new JButton("Nuevo");
		add(botonNuevo);
		botonCerrar=new JButton("Cerrar");
		add(botonCerrar);
		OyenteNuevo miOyente=new OyenteNuevo();
		botonNuevo.addActionListener(miOyente);
	}
	private class OyenteNuevo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MarcoEmergente marco=new MarcoEmergente(botonCerrar);
			marco.setVisible(true);
		
		}
		
	}
	JButton botonCerrar;
}

class MarcoEmergente extends JFrame {
	public MarcoEmergente(JButton boton_de_principal){
		contador++;
		setTitle("Ventana "+ contador);
		setBounds(40*contador,40*contador,300,150);
		CierraTodos oyenteCerrar=new CierraTodos();
		boton_de_principal.addActionListener(oyenteCerrar);
	}
	private class CierraTodos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			
		}
		
	}
	private static int contador=0;
}