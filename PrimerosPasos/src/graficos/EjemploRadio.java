package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EjemploRadio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRadio2 mimarco=new MarcoRadio2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class MarcoRadio2 extends JFrame{
	public MarcoRadio2(){
		setBounds(550,300,500,350);
		LaminaRadio2 lamina=new LaminaRadio2();
		add(lamina);
	}
}
class LaminaRadio2 extends JPanel{
	public LaminaRadio2(){
		setLayout(new BorderLayout());
		texto=new JLabel("En un lugar de la mancha de cuyo nombre..");
		add(texto,BorderLayout.CENTER);
		ButtonGroup migrupo=new ButtonGroup();
		boton1=new JRadioButton("Pequeño",false);
		boton2=new JRadioButton("Mediano",true);
		boton3=new JRadioButton("Grande",false);
		boton4=new JRadioButton("Muy Grande",false);
		
		migrupo.add(boton1);
		migrupo.add(boton2);
		migrupo.add(boton3);
		migrupo.add(boton4);
		
		JPanel laminaRadio=new JPanel();
		
		laminaRadio.add(boton1);
		laminaRadio.add(boton2);
		laminaRadio.add(boton3);
		laminaRadio.add(boton4);
		
		boton1.addActionListener(new eventoRadio());
		boton2.addActionListener(new eventoRadio());
		boton3.addActionListener(new eventoRadio());
		boton4.addActionListener(new eventoRadio());
		
		add(laminaRadio,BorderLayout.SOUTH);
		
	
		
	}
	private class eventoRadio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==boton1){
				//System.out.println("has pulsado el 1");
				texto.setFont(new Font("Serif", Font.PLAIN,10));
			}
			else if(e.getSource()==boton2){
				texto.setFont(new Font("Serif", Font.PLAIN,12));
				
			}
			else if(e.getSource()==boton3){
				texto.setFont(new Font("Serif", Font.PLAIN,18));
			}
			else if(e.getSource()==boton4){
				texto.setFont(new Font("Serif", Font.PLAIN,24));
			}
		}
		
		
	}
	private JLabel texto;
	private JRadioButton boton1,boton2,boton3,boton4;
}