/*video 96 
 * https://www.youtube.com/watch?v=XtoSO1yXgSc&index=96&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * */

package graficos;
import java.awt.Font;

import javax.swing.*;

public class MarcoSliders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSliders mimarco=new FrameSliders();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class FrameSliders extends JFrame{
	public FrameSliders(){
		setBounds(550,400,550,350);
		LaminaSliders milamina=new LaminaSliders();
		add(milamina);
		setVisible(true);
	}
}
class LaminaSliders extends JPanel{
	public LaminaSliders(){
		
		//por defecto me crea 100 puntos y me lo situa en 50
		//0,100,50 = inicio, fin, situacion
		//SwingConstants.HORIZONTAL
		//la orientacion define si esta vertical o horizontal
		//JSlider control=new JSlider(SwingConstants.HORIZONTAL,20,100,25);
	
		JSlider control=new JSlider(0,100,25);
		//control.setOrientation(SwingConstants.VERTICAL);
		
		//para decorar
		//lineas mayores
		control.setMajorTickSpacing(50);
		//lineas cortas
		control.setMinorTickSpacing(25);
		
		//para imprimir la decoracion
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		//definir el tipo de letra del formato
		control.setFont(new Font("Serif", Font.ITALIC, 12));
		//para agregar imagenes a las lineas
		control.setSnapToTicks(true);
		add(control);
	}
}
