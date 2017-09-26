package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PruebaAreaTexto2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoPruebaArea mimarco=new MarcoPruebaArea();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoPruebaArea extends JFrame{
	public MarcoPruebaArea(){
		setBounds(500,300,500,350);
		setTitle("Probando area de texto");
		setLayout(new BorderLayout());
		laminaBotones=new JPanel();
		botonInsertar=new JButton("Insertar");
		
		botonInsertar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				areaTexto.append("En un lugar de la Mancha cuyo nombre no quiero acordarme..");
				
			} });
		laminaBotones.add(botonInsertar);
		botonSaltoLinea=new JButton("Salto linea");
		botonSaltoLinea.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean saltar=!areaTexto.getLineWrap();
				//si no encuentra saltos de linea almaacena la variable saltar true
				areaTexto.setLineWrap(saltar);
				
				/*
				if(saltar){
					botonSaltoLinea.setText("Quitar salto");
				}else{
					botonSaltoLinea.setText("Salto linea");
				}
				*/
				botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto Linea");
			}
			
		});
		
		laminaBotones.add(botonSaltoLinea);
		add(laminaBotones,BorderLayout.SOUTH);
		areaTexto= new JTextArea(8,20);
		laminaConBarras=new JScrollPane(areaTexto);
		add(laminaConBarras, BorderLayout.CENTER);
		
	}
	private JPanel laminaBotones;
	private JButton botonInsertar, botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaConBarras;
	
}