package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EjemploRadio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRadio3 mimarco=new MarcoRadio3();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class MarcoRadio3 extends JFrame{
	public MarcoRadio3(){
		setBounds(550,300,500,350);
		LaminaRadio3 lamina=new LaminaRadio3();
		add(lamina);
	}
}
class LaminaRadio3 extends JPanel{
	public LaminaRadio3(){
		setLayout(new BorderLayout());
		texto=new JLabel("En un lugar de la mancha de cuyo nombre..");
		texto.setFont(new Font("Serif",Font.PLAIN,12));
		add(texto,BorderLayout.CENTER);
		laminaBotones=new JPanel();
		migrupo=new ButtonGroup();
		
		colocarBotones("Pequeño",false,10);
		colocarBotones("Mediano",true,12);
		colocarBotones("Grande",false,18);
		colocarBotones("Muy Grande",false,24);
		
		add(laminaBotones,BorderLayout.SOUTH);
		
		
	}
	public void colocarBotones(String nombre, boolean seleccion, final int tamanio){
		//variables que se usaran dentro de una funcion de algun metodo deben ser constantes
		//es decir con el tipo final para que no marque error
		JRadioButton boton=new JRadioButton(nombre, seleccion);
		migrupo.add(boton);
		laminaBotones.add(boton);
		
		ActionListener oyente=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				texto.setFont(new Font("Serif",Font.PLAIN,tamanio));
			}
			
		};
		boton.addActionListener(oyente);
		
	}
	
	private JLabel texto;
	private JRadioButton boton1,boton2,boton3,boton4;
	private ButtonGroup migrupo;
	private JPanel laminaBotones;
}