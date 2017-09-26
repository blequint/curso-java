/*video 97
 * https://www.youtube.com/watch?v=3IV2SKV6H80&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=97
 * */

package graficos;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;


public class MarcoSliders2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSliders2 mimarco=new FrameSliders2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class FrameSliders2 extends JFrame{
	public FrameSliders2(){
		setBounds(550,400,550,350);
		LaminaSliders2 milamina=new LaminaSliders2();
		add(milamina);
		setVisible(true);
	}
}
class LaminaSliders2 extends JPanel{
	public LaminaSliders2(){
		setLayout(new BorderLayout());
		rotulo=new JLabel("En un lugar de la Mancha de cuyo nombre..");
	
		add(rotulo,BorderLayout.CENTER);
		//min 8px max 50px se define en 12px
		control=new JSlider(8,50,12);
		
		//20*8=48
		
		//rayitas grandes
		control.setMajorTickSpacing(20);
		//rayitas chicas
		control.setMinorTickSpacing(5);
		//pintar rayitas
		control.setPaintTicks(true);
		//pintar numeros
		control.setPaintLabels(true);
		//tipo de letra, italica 10px
		control.setFont(new Font("Serif", Font.ITALIC, 10));
		
		//agregar el oyente
		control.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider=new JPanel();
		laminaSlider.add(control);
		
		add(laminaSlider,BorderLayout.NORTH);
	}
	//changeListener : oyente para sliders
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			//cuenta cuantas veces se ha movido
			contador++;
			//getValue recupera el valor del slider
			//System.out.println("Esta manipulando el slider: "+ control.getValue());
		
			rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
		}
		
	}
	private JLabel rotulo;
	private JSlider control;
	private static int contador;
}