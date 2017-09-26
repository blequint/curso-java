/*video 98 y 99
 * https://www.youtube.com/watch?v=06acFKm-kcQ&index=98&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * */
package graficos;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class MarcoSpinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSpinner mimarco=new FrameSpinner();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class FrameSpinner extends JFrame{
	public FrameSpinner(){
		setBounds(550,350,550,350);
		
		add(new LaminaSpinner());
		setVisible(true);
	}
}
class LaminaSpinner extends JPanel{
	public LaminaSpinner(){
		
		//por defecto empieza en 0
		//un spinnermodel pueden ser fechas, o valores de texto
		//spinnerDateModel es la clase de las fechas
		//JSpinner control=new JSpinner(new SpinnerDateModel());

		//para crear valores de texto
//		String lista[]={"Enero","Febrero","Marzo","Abril"};
		
		//trae todas las fuentes instaladas en mi compu y los almacena en el array
		String lista[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	
		
		//JSpinner control=new JSpinner(new SpinnerListModel(lista));
		
		//empieza en , minimo, maximo, saltos
	//	JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,5));
		
		
		//implementacion de mi modelo de sppiner con clase interna
		//JSpinner control=new JSpinner(new MiModeloJSpinner());

		//implementacion de clase interna anonima
		JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,1){
			//son anonimas porque no tienen nombre las clases
			public Object getNextValue(){
				return super.getPreviousValue();
							
			}
			public Object getPreviousValue(){
				return super.getNextValue();
			}
		});

		
		//centrar texto del spinner
		JSpinner.DefaultEditor sEditor=(JSpinner.DefaultEditor)control.getEditor();
		JFormattedTextField text=(JFormattedTextField)sEditor.getComponent(0);
		text.setHorizontalAlignment(JFormattedTextField.CENTER);
		
		Dimension d=new Dimension(200,20);
		control.setPreferredSize(d);
		add(control);
		
	}
	
	/*Clase interna
	
	//par hacer un spinnernumbermodel al reves
	private class MiModeloJSpinner extends SpinnerNumberModel{
		public MiModeloJSpinner(){
			//llamamos al constructor de Spinner padre y empiece en 5, 0 min , 10 max , 1 saltos
			super(5,0,10,1);
		}
		//para sobreescribir los metodos de la clase
		public Object getNextValue(){
			return super.getPreviousValue();
						
		}
		public Object getPreviousValue(){
			return super.getNextValue();
		}
	}
	
	*/

}
