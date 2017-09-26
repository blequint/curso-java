package graficos;

import java.awt.event.*;
import javax.swing.*;

public class EventosDeRaton_Adaptador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRaton2 mimarco=new MarcoRaton2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class MarcoRaton2 extends JFrame{
	public MarcoRaton2(){
		setVisible(true);
		setBounds(700,300,600,450);
		EventosDeRaton2 eventoRaton=new EventosDeRaton2();
		addMouseListener(eventoRaton);
	}
}
class EventosDeRaton2 extends MouseAdapter{
/*
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Coordenada X: "+e.getX()+"\nCoordenada Y: "+e.getY());
		System.out.println(e.getClickCount());
	}
*/
	public void mousePressed(MouseEvent e){
		//System.out.println(e.getModifiersEx());
		//click derecho e izquierdo
		//1024
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
			System.out.println("Has pulsado el boton izquierdo");
		}else if(e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK){
			System.out.println("Has pulsado la rueda del raton");
		}else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK){
			System.out.println("Has pulsado el boton derecho");
			
		}
	}
	
	
}
