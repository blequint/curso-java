package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;
public class TrabajandoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFuente mimarco=new MarcoConFuente();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
class MarcoConFuente extends JFrame{
	public MarcoConFuente(){
		setTitle("Prueba con fuentes");
		setSize(400,400);
		LaminaConFuente milamina=new LaminaConFuente();
		add(milamina);
		
		milamina.setForeground(Color.GRAY);
		
	}
}

class LaminaConFuente extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	Graphics2D g2=(Graphics2D) g;
	
	Font mifuente=new Font("Arial", Font.BOLD,26);
	g2.setFont(mifuente);
	//g2.setColor(Color.BLUE);
	g2.drawString("Brenda", 100, 100);

	g2.setFont(new Font("Courier", Font.ITALIC,24));
	//g2.setColor(new Color(128,0,50).brighter());
	g2.drawString("Curso de Java",100,200);
	}
}