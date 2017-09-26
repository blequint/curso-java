package practicas;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class LaminaBotones extends JPanel{
	public LaminaBotones(String titulo, String[] opciones){
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
	//padre, distribucion del contenido de la caja
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		grupo=new ButtonGroup();
		
		for(int i=0; i<opciones.length; i++){
			JRadioButton bot=new JRadioButton(opciones[i]);
			
			bot.setActionCommand(opciones[i]);
			grupo.add(bot);
			add(bot);
			//seleccion el primero
			bot.setSelected(i==0);
		}
	}
	public String dameSeleccion(){
		//ButtonModel miboton=grupo.getSelection();
		//String s=miboton.getActionCommand();
		return grupo.getSelection().getActionCommand();
		
		
	}
	private ButtonGroup grupo;
}
