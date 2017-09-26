package graficos;

import java.awt.event.*;

import javax.swing.*;

public class EventosRaton3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRaton3 mimarco=new MarcoRaton3();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class MarcoRaton3 extends JFrame{
	public MarcoRaton3(){
		setVisible(true);
		setBounds(700,300,600,450);
		EventosDeRaton3 eventoRaton=new EventosDeRaton3();
		addMouseMotionListener(eventoRaton);
	}
}
class EventosDeRaton3 implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Estas arrastrando");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Estas moviendo");
	}

	
	
}
