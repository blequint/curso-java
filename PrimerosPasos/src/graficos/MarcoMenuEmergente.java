//video 109
// https://www.youtube.com/watch?v=s0k9jIHt-as&index=109&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
package graficos;

import javax.swing.*;

import java.awt.*;

public class MarcoMenuEmergente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEmergenteM mimarco=new MarcoEmergenteM();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoEmergenteM extends JFrame{
	public MarcoEmergenteM(){
		setBounds(100,100,300,250);
		LaminaEmergenteM milamina=new LaminaEmergenteM();
		add(milamina);
		setVisible(true);
	}
}
class LaminaEmergenteM extends JPanel{
	public LaminaEmergenteM(){
		setLayout(new BorderLayout());
		JPanel laminamenu=new JPanel();

		JMenuBar mibarra=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		estilo=new JMenu("Estilo");
		tamanio=new JMenu("Tamaño");
		
	
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamanio);
		laminamenu.add(mibarra);
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		//menu
	/********************************************/	
		// menu emergente
		JPopupMenu emergente=new JPopupMenu();
		JMenuItem opcion1=new JMenuItem("Opcion 1");
		emergente.add(opcion1);
		JMenuItem opcion2=new JMenuItem("Opcion 2");
		emergente.add(opcion2);
		JMenuItem opcion3=new JMenuItem("Opcion 3");
		emergente.add(opcion3);
		//se debe especificar sobre que al hacer click
		//aqui especifica en la lamina 
		//setComponentPopupMenu(emergente);
		
		miarea.setComponentPopupMenu(emergente);

	}
	private JMenu fuente;
	private JMenu estilo;
	private JMenu tamanio;
	private JTextPane miarea;
}
