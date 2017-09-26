package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PruebaTexto{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoTexto mimarco=new MarcoTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}
class MarcoTexto extends JFrame{
	public MarcoTexto(){
		
		setBounds(600,300,600,350);
		LaminaTexto lamina=new LaminaTexto();
		add(lamina);
	}
}
class LaminaTexto extends JPanel{
	public LaminaTexto(){
		//JTextField campo1=new JTextField("Texto por defecto");
	//	JTextField campo1=new JTextField(20);
		setLayout(new BorderLayout());
		JPanel lamina2=new JPanel();
		lamina2.setLayout(new FlowLayout());
		
		resultado=new JLabel("", JLabel.CENTER);
		 campo1=new JTextField(20);
		 JLabel texto1 = new JLabel("Email: ");
		lamina2.add(texto1);
		lamina2.add(campo1);
		add(resultado, BorderLayout.CENTER);
	//	System.out.println(campo1.getText().trim());
		JButton miboton=new JButton("Comprobar");
		DameTexto mievento=new DameTexto();
		miboton.addActionListener(mievento);
		lamina2.add(miboton);
		
		add(lamina2, BorderLayout.NORTH);
		
	}
	private class DameTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int correcto=0;
			String email=campo1.getText().trim();
			for(int i=0; i<email.length(); i++){
				if(email.charAt(i)=='@'){
					correcto++;
				}
			}
			
			if(correcto!=1){
				resultado.setText("Incorrecto");
			}else
			resultado.setText("Correcto");
			
			
		}
		
	}
	private JTextField campo1;
	private JLabel resultado;
}

