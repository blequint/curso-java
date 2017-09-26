package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PruebaAreaTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoArea mimarco=new MarcoArea();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoArea extends JFrame{
	public MarcoArea(){
		setBounds(500,300,500,350);
		LaminaArea lamina=new LaminaArea();
		add(lamina);
	}
}
class LaminaArea extends JPanel{
	public LaminaArea(){
		miarea=new JTextArea(8,20);
		JScrollPane laminaBarras=new JScrollPane(miarea);
		miarea.setLineWrap(true); //con esto ya no se ensancha
		add(laminaBarras);
		JButton boton=new JButton("Dale");
		boton.addActionListener(new GestionaArea());
		add(boton);
	}
	private class GestionaArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(miarea.getText());
		}
		
	}
	private JTextArea miarea;
}
