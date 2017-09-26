package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PruebaChecks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCheck mimarco=new MarcoCheck();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class MarcoCheck extends JFrame{
	public MarcoCheck(){
		setBounds(550,300,550,350);
		LaminaCheck lamina=new LaminaCheck();
		add(lamina);
	}
}
class LaminaCheck extends JPanel{
	public LaminaCheck(){
		setLayout(new BorderLayout());
		
		Font miletra=new Font("Serif",Font.PLAIN,24);
		texto=new JLabel("En un lugar de la mancha de cuyo nombre..");
		texto.setFont(miletra);
		JPanel laminaTexto=new JPanel();
		laminaTexto.add(texto);
		add(laminaTexto,BorderLayout.CENTER);
		
		check1=new JCheckBox("Negrita");
		check2=new JCheckBox("Cursiva");
		
		check1.addActionListener(new ManejaChecks());
		check2.addActionListener(new ManejaChecks());
		
		JPanel laminaChecks=new JPanel();
		laminaChecks.add(check1);
		laminaChecks.add(check2);
		add(laminaChecks,BorderLayout.SOUTH);
		
		
	}
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int tipo=0;
			if(check1.isSelected()) tipo+=Font.BOLD;
			//bold=1
			
			if(check2.isSelected()) tipo+=Font.ITALIC;
			//italic=2
			
			texto.setFont(new Font("Serif",tipo,24));
		}
		
	}
	private JLabel texto;
	private JCheckBox check1, check2;
}