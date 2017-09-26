package graficos;
import javax.swing.*;
import java.awt.event.*;
public class EventosVentana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoVentana mimarco=new MarcoVentana();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcoVentana mimarco2=new MarcoVentana();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mimarco.setTitle("Ventana 1");
		mimarco2.setTitle("Ventana 2");
		mimarco.setBounds(300,300,500,350);
		mimarco2.setBounds(900,300,500,350);
	}

}
class MarcoVentana extends JFrame{
	public MarcoVentana(){
		setVisible(true);
		//setTitle("Respondiendo");
		//setBounds(300,300,500,350);
		M_ventana oyente=new M_ventana();
		addWindowListener(oyente);
	}
}
class M_ventana implements WindowListener{
	public void windowActivated(WindowEvent e){
		System.out.println("Ventana activada");
	}
	public void windowClosed(WindowEvent e){
		System.out.println("La venana ha sido cerrada");
	}
	public void windowClosing(WindowEvent e){
		System.out.println("Cerrando ventana");
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("Ventana desactivada");
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("Ventana restaurada");
	}
	public void windowIconified(WindowEvent e){
		System.out.println("Ventana minimizada");
		
	}
	public void windowOpened(WindowEvent e){
		System.out.println("Ventana abierta");
	}
}