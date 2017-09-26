/*
 video 118 - 120
 * */
package graficos;

import javax.swing.*;

import java.awt.*;

public class LibreDisposicion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLibre mimarco=new MarcoLibre();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class MarcoLibre extends JFrame{
	public MarcoLibre(){
		setBounds(450,350,600,400);
		LaminaLibre milamina=new LaminaLibre();
		add(milamina);
		setVisible(true);
		
	}
}
class LaminaLibre extends JPanel{
	public LaminaLibre(){
		
		setLayout(new EnColumnas());
		
		JLabel nombre =new JLabel("Nombre: ");
		JLabel apellido=new JLabel("Apellido: ");
		
		JTextField c_nombre=new JTextField();
		JTextField c_apellido=new JTextField();
		JLabel edad=new JLabel("Edad: ");
		JTextField c_edad=new JTextField();
		JLabel tel=new JLabel("Telefono: ");
		JTextField c_tel=new JTextField();

		/*
		nombre.setBounds(20,20,80,10);
		c_nombre.setBounds(100,20,100,20);
		apellido.setBounds(20,60,80,15);
		c_apellido.setBounds(100,55,100,20);
*/
		
		add(nombre);
		add(c_nombre);
		add(apellido);
		add(c_apellido);
		add(edad);
		add(c_edad);
		add(tel);
		add(c_tel);
		
	
		/*
		JButton boton1=new JButton("Boton 1");
		//coordenada
		boton1.setBounds(50,50,120,50);
		add(boton1);
		*/
	}
}
//para hacer nuestra propia plantilla
class EnColumnas implements LayoutManager{

	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void layoutContainer(Container micontenedor) {
		int d=micontenedor.getWidth();
		x=d/2;
		y=20;
		int contador=0;
		int n=micontenedor.getComponentCount();
		
		for(int i=0;i<n; i++){
			contador++;
			Component c=micontenedor.getComponent(i);
			c.setBounds(x-100,y,100,20);
			x+=100;
			
			if(contador%2==0){
				x=d/2;
				y+=40;
			}
			
		}
	}

	@Override
	public Dimension minimumLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension preferredLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLayoutComponent(Component arg0) {
		// TODO Auto-generated method stub
		
	}
	//x=20
	private int x;
	private int y;
}