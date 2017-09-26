package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;

public class CampoPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPassword mimarco=new MarcoPassword();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoPassword extends JFrame{
	public MarcoPassword(){
		setBounds(400,300,550,400);
		LaminaPassword lamina=new LaminaPassword();
		add(lamina);
		
	}
}

class LaminaPassword extends JPanel{
	public LaminaPassword(){
		setLayout(new BorderLayout());
		JPanel lamina_superior=new JPanel();
		lamina_superior.setLayout(new GridLayout(2,2));
		add(lamina_superior, BorderLayout.NORTH);
		
		JLabel etiqueta1=new JLabel("Usuario");
		JLabel etiqueta2=new JLabel("Contraseña");
		JTextField c_usuario=new JTextField(15);
		c_contra=new JPasswordField(15);
		
		Comprueba_pass mievento=new Comprueba_pass();
		c_contra.getDocument().addDocumentListener(mievento);
		
		lamina_superior.add(etiqueta1);
		lamina_superior.add(c_usuario);
		lamina_superior.add(etiqueta2);
		lamina_superior.add(c_contra);
		
		JButton enviar=new JButton("Enviar");
		add(enviar, BorderLayout.SOUTH);
		
		
	}
	private class Comprueba_pass implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			char[] contrasena;
			contrasena=c_contra.getPassword();
			if(contrasena.length<8 || contrasena.length>12){
				c_contra.setBackground(Color.red);
			}
			else c_contra.setBackground(Color.white);
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			char[] contrasena;
			contrasena=c_contra.getPassword();
			if(contrasena.length<8 || contrasena.length>12){
				c_contra.setBackground(Color.red);
			}
			else c_contra.setBackground(Color.white);
		}
		
	}
	private JPasswordField c_contra;
}

