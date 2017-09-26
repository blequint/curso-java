package graficos;
import javax.swing.*;
import java.awt.*;

public class Layouts_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLayout mimarco=new MarcoLayout();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class MarcoLayout extends JFrame{
	public MarcoLayout(){
		setTitle("Prueba Acciones");
		setBounds(60,350,600,300);
		PanelLayout lamina=new PanelLayout();
		
	//	FlowLayout disposicion=new FlowLayout(FlowLayout.LEFT);
		
		add(lamina,BorderLayout.NORTH);
		PanelLayout2 lamina2=new PanelLayout2();
		
		add(lamina2, BorderLayout.SOUTH);
	}
}
class PanelLayout extends JPanel{
	public PanelLayout(){
	setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
	//setLayout(new BorderLayout(10,10));
		add(new JButton("Amarillo"), BorderLayout.NORTH);
		add(new JButton("Rojo"),BorderLayout.SOUTH);

	
	}
	
}

class PanelLayout2 extends JPanel{
	public PanelLayout2(){
		setLayout(new BorderLayout(10,10));
		add(new JButton("Azul"),BorderLayout.WEST);
		add(new JButton("Verde"),BorderLayout.EAST);
		add(new JButton("Negro"),BorderLayout.CENTER);
	
		
	}
}