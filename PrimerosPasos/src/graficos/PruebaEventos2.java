package graficos;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class PruebaEventos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBotones mimarco=new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones2 extends JFrame{
	public MarcoBotones2(){
		setTitle("Botones y Eventos");
		setBounds(700,300,500,300);
		LaminaBotones2 milamina=new LaminaBotones2();
		add(milamina);
	}
}
class LaminaBotones2 extends JPanel {
	JButton botonAzul=new JButton("Azul");
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	public LaminaBotones2(){
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		ColorDeFondo amarillo=new ColorDeFondo(Color.yellow);
		ColorDeFondo azul=new ColorDeFondo(Color.blue);
		ColorDeFondo rojo=new ColorDeFondo(Color.red);
		botonAzul.addActionListener(azul);
		botonAmarillo.addActionListener(amarillo);
		botonRojo.addActionListener(rojo);
	}
	private class ColorDeFondo implements ActionListener{
		public ColorDeFondo(Color c){
			colorDeFondo=c;
		}
		public void actionPerformed(ActionEvent e){
			setBackground(colorDeFondo);
		}
		private Color colorDeFondo;
	}
	
}
