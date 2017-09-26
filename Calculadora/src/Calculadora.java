

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCalculadora mimarco=new MarcoCalculadora();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}
class MarcoCalculadora extends JFrame{
	public MarcoCalculadora(){
		
		setTitle("Calculadora");
		setBounds(500,300,450,300);
		LaminaCalculadora lamina=new LaminaCalculadora();
		add(lamina);
		pack(); //se adapta al tamaño por defecto del contenedor
	}
}
class LaminaCalculadora extends JPanel{
	public LaminaCalculadora(){
		principio=true;
		setLayout(new BorderLayout());
		pantalla=new JButton("0");
		
		pantalla.setEnabled(false);
		add(pantalla, BorderLayout.NORTH);
	
		lamina2=new JPanel();
		lamina2.setLayout(new GridLayout(4,4));
		/*
		JButton boton1=new JButton("1");
		lamina2.add(boton1);
		JButton boton2=new JButton("2");
		lamina2.add(boton2);
		JButton boton3=new JButton("3");
		lamina2.add(boton3);
		JButton boton4=new JButton("4");
		lamina2.add(boton4);
		
		JButton boton5=new JButton("5");
		lamina2.add(boton5);
		JButton boton6=new JButton("6");
		lamina2.add(boton6);
		JButton boton7=new JButton("7");
		lamina2.add(boton7);
		JButton boton8=new JButton("8");
		lamina2.add(boton8);
		
		JButton boton9=new JButton("9");
		lamina2.add(boton9);
		JButton botonmenos=new JButton("-");
		lamina2.add(botonmenos);
		JButton botonmas=new JButton("+");
		lamina2.add(botonmas);
		JButton botonpor=new JButton("*");
		lamina2.add(botonpor);
		
		JButton botonpunto=new JButton(".");
		lamina2.add(botonpunto);
		JButton botondiv=new JButton("/");
		lamina2.add(botondiv);
		JButton botonigual=new JButton("=");
		lamina2.add(botonigual);
		JButton boton=new JButton("");
		lamina2.add(boton);
		*/
		ActionListener insertar=new InsertaNumero();
		ActionListener orden=new AccionOrden();
		
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		
		ponerBoton("/", orden);
		
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		
		ponerBoton("*",orden);
		
		ponerBoton("1",insertar);
		ponerBoton("2",insertar);
		ponerBoton("3",insertar);
		ponerBoton(".",insertar);
		
		ponerBoton("0",insertar);
	
		ponerBoton("-",orden);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		
		

		add(lamina2,BorderLayout.CENTER);
		ultimaOperacion="=";
		
		
	}
	
	private void ponerBoton(String rotulo, ActionListener oyente){
		
	
		JButton boton=new JButton(rotulo);
		boton.addActionListener(oyente);
		lamina2.add(boton);
		
	}
	private class InsertaNumero implements ActionListener{

	
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String entrada=e.getActionCommand();
			if(principio){
				pantalla.setText("");
				principio=false;
			}
			pantalla.setText(pantalla.getText()+entrada);
			
			
		}
		
	}
	private class AccionOrden implements ActionListener{


		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String operacion=e.getActionCommand(); //obtiene el texto del boton
			System.out.println(operacion);
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion=operacion;
			principio=true;
		}
		public void calcular(double x){
			if(ultimaOperacion.equals("+")){
				resultado+=x;
				//System.out.println(resultado);
			}
			else if(ultimaOperacion.equals("-")){
				resultado-=x;
			}
			else if(ultimaOperacion.equals("*")){
				resultado*=x;
			}
			else if(ultimaOperacion.equals("/")){
				resultado/=x;
			}
			else if(ultimaOperacion.equals("=")){
				resultado=x;
			}
			pantalla.setText(""+resultado);
		}
		
	}
	private JPanel lamina2;
	private JButton pantalla;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;
}
