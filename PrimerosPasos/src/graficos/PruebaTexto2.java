package graficos;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class PruebaTexto2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPrueba mimarco=new MarcoPrueba();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoPrueba extends JFrame{
	public MarcoPrueba(){
		setBounds(500,300,500,350);
		LaminaPrueba lamina=new LaminaPrueba();
		add(lamina);
		
	}
}
class LaminaPrueba extends JPanel{
	public LaminaPrueba(){
		JTextField micampo=new JTextField(20);
		Document midoc=micampo.getDocument();
		EscuchaTexto el_evento=new EscuchaTexto();
		midoc.addDocumentListener(el_evento);
		add(micampo);
	}
	private class EscuchaTexto implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Has insertado texto");
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Has borrado texto");
		}
		
	}
}