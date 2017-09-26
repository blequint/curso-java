/*
 * video 116 y 117
 * https://www.youtube.com/watch?v=GJVgIyFRktM&index=116&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 *Uso de disposiciones Spring, muelle es como un resorte
 * */
package graficos;

import javax.swing.*;
import java.awt.*;
public class DisposicionMuelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMuelle mimarco=new MarcoMuelle();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoMuelle extends JFrame{
	public MarcoMuelle(){
		setBounds(300,400,1000,350);
		LaminaMuelle milamina=new LaminaMuelle();
		add(milamina);
		setVisible(true);
	}
}
class LaminaMuelle extends JPanel{
	public LaminaMuelle(){
		JButton boton1=new JButton("Boton 1");
		JButton boton2=new JButton("Boton 2");
		JButton boton3=new JButton("Boton 3");
		SpringLayout milayout=new SpringLayout();
		setLayout(milayout);
		
		add(boton1);
		add(boton2);
		add(boton3);
		//muelle de las esquinas
		Spring mimuelle=Spring.constant(0,0,100);
		//rigido
		//10 px
		Spring muelle_rigido=Spring.constant(80);
		milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
		milayout.putConstraint(SpringLayout.WEST, boton2, muelle_rigido, SpringLayout.EAST, boton1);
		milayout.putConstraint(SpringLayout.WEST, boton3, muelle_rigido, SpringLayout.EAST, boton2);
		milayout.putConstraint(SpringLayout.EAST, this, mimuelle, SpringLayout.WEST, boton3);
		
		
	}
}