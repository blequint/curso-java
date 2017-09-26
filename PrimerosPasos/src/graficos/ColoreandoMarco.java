package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;
public class ColoreandoMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConColor mimarco=new MarcoConColor();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
class MarcoConColor extends JFrame{
	public MarcoConColor(){
		setTitle("Prueba dibujo");
		setSize(400,400);
		LaminaConColor milamina=new LaminaConColor();
		add(milamina);
		milamina.setBackground(Color.PINK);
		milamina.setBackground(SystemColor.window);
	
	}
}

class LaminaConColor extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	Graphics2D g2=(Graphics2D) g;
	Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
	g2.setPaint(Color.BLUE);
	g2.draw(rectangulo);
	g2.setPaint(Color.RED);	
	
	g2.fill(rectangulo);
		Ellipse2D elipse=new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		//g2.setPaint(Color.BLUE);
		
		Color micolor=new Color(125,189,200);
	//	g2.setPaint(new Color(0,140,255).brighter());
		g2.setPaint(micolor);
		//.darker
		
		g2.fill(elipse);
//		g2.draw(elipse);
		g2.draw(new Line2D.Double(100,100,300,250));
		double CentroenX=rectangulo.getCenterX();
		double CentroenY=rectangulo.getCenterY();
		double radio=150;
		Ellipse2D circulo=new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX,CentroenY, CentroenX+radio,CentroenY+radio);
		
		g2.draw(circulo);
		//g.drawRect(50,50,200,200);
		//g.drawLine(50, 50, 100, 50);
		//g.drawArc(50, 100, 100, 200, 120,150);
	}
}