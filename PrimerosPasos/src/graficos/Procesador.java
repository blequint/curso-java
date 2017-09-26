/*
 * video 101,102
 * https://www.youtube.com/watch?v=JEy3hb8Fpig&index=101&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * */


package graficos;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Procesador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador mimarco=new MenuProcesador();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MenuProcesador extends JFrame{
	public MenuProcesador(){
		setBounds(500,300,550,400);
		LaminaProcesador milamina=new LaminaProcesador();
		add(milamina);
		setVisible(true);
		
	}
}
class LaminaProcesador extends JPanel{
	public LaminaProcesador(){
		setLayout(new BorderLayout());
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
		
		JMenu fuente=new JMenu("Fuente");
	
		JMenuItem arial=new JMenuItem("Arial");
		
		arial.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//clase interna anonima
				miarea.setFont(new Font("Arial", Font.PLAIN, 12));
				
			}
		});
		JMenuItem courier=new JMenuItem("Courier");
		
		
		//courier.addActionListener(new GestionaMenus());
		
		courier.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//clase interna anonima
				miarea.setFont(new Font("Courier", Font.PLAIN, 12));
				
			}
		});
		
		JMenuItem verdana= new JMenuItem("Verdana");
		
		verdana.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//clase interna anonima
				miarea.setFont(new Font("Verdana", Font.PLAIN, 12));
				
			}
		});
		
		
		
		fuente.add(arial);
		fuente.add(courier);
		fuente.add(verdana);
		
		JMenu estilo=new JMenu("Estilo");
		
		JMenuItem negrita=new JMenuItem("Negrita");
		JMenuItem cursiva=new JMenuItem("Cursiva");
		
		estilo.add(negrita);
		estilo.add(cursiva);
		
		JMenu tamanio=new JMenu("Tamaño");
		
		JMenuItem tam12=new JMenuItem("12");
		JMenuItem tam16=new JMenuItem("16");
		JMenuItem tam20= new JMenuItem("20");
		JMenuItem tam24= new JMenuItem("24");

		
		tamanio.add(tam12);
		tamanio.add(tam16);
		tamanio.add(tam20);
		tamanio.add(tam24);
		
	
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamanio);
		
		laminamenu.add(mibarra);
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		
	}
	/* clase interna
	private class GestionaMenus implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			miarea.setFont(new Font("Courier", Font.PLAIN, 12));
			
		}
		
	}
	*/
	JTextPane miarea;
}
