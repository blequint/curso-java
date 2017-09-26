/*video 100 y 107
 * https://www.youtube.com/watch?v=L_QzjDWoKDo&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=100
 * */
package graficos;

import javax.swing.*;
import java.awt.*;

public class MarcoMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuFrame mimarco=new MenuFrame();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MenuFrame extends JFrame{
	public MenuFrame(){
		setBounds(550,350,550,350);
		MenuLamina milamina=new MenuLamina();
		add(milamina);
		setVisible(true);
		
	}
}
class MenuLamina extends JPanel{
	public MenuLamina(){
		//crea el soporte de las opciones
		JMenuBar mibarra=new JMenuBar();
		
		JMenu archivo=new JMenu("Archivo");
		JMenu edicion=new JMenu("Edicion");
		JMenu herramientas=new JMenu("Herramientas");
		
		JMenuItem guardar=new JMenuItem("Guardar");
		JMenuItem guardarcomo=new JMenuItem("Guardar Como");

		JMenuItem cortar=new JMenuItem("Cortar", new ImageIcon("bin/graficos/cortar.gif"));
		JMenuItem copiar=new JMenuItem("Copiar", new ImageIcon("bin/graficos/copiar.gif"));
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		JMenuItem pegar=new JMenuItem("Pegar", new ImageIcon("bin/graficos/pegar.gif"));
		JMenu opciones=new JMenu("Opciones");
		
		JMenuItem opcion1=new JMenuItem("Opcion 1");
		JMenuItem opcion2=new JMenuItem("Opcion 2");
		
		opciones.add(opcion1);
		opciones.add(opcion2);

		JMenuItem generales=new JMenuItem("Generales");
	
		archivo.add(guardar);
		archivo.add(guardarcomo);
		
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.addSeparator(); 
		edicion.add(opciones);
		
		herramientas.add(generales);

		
		

		
		mibarra.add(archivo);
		mibarra.add(edicion);
		mibarra.add(herramientas);
		add(mibarra);
		
	}
}