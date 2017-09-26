package graficos;
import javax.swing.*;
import java.awt.event.*;
public class EventosVentana2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoVentana2 mimarco=new MarcoVentana2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcoVentana2 mimarco2=new MarcoVentana2();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mimarco.setTitle("Ventana 1");
		mimarco2.setTitle("Ventana 2");
		mimarco.setBounds(300,300,500,350);
		mimarco2.setBounds(900,300,500,350);
	}

}
class MarcoVentana2 extends JFrame{
	public MarcoVentana2(){
		setVisible(true);
		//setTitle("Respondiendo");
		//setBounds(300,300,500,350);
		//M_ventana2 oyente=new M_ventana2();
	//	addWindowListener(oyente);
		addWindowListener(new M_ventana2());
	}
}
class M_ventana2 extends WindowAdapter{
	

	public void windowIconified(WindowEvent e){
		System.out.println("Ventana minimizada");
		
	}

}