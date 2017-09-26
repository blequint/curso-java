/*videp 95
 * https://www.youtube.com/watch?v=MYdAW9f7YHk&index=95&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&t=211s
 * */

package graficos;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PruebaCombo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCombo mimarco=new MarcoCombo();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoCombo extends JFrame{
	public MarcoCombo(){
		setBounds(550,300,550,400);
		LaminaCombo lamina=new LaminaCombo();
		add(lamina);
		setVisible(true);
	}
}
class LaminaCombo extends JPanel{
	public LaminaCombo(){
		setLayout(new BorderLayout());
		texto=new JLabel("En un lugar de la mancha de cuyo nombre..");
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		add(texto,BorderLayout.CENTER);
		
		JPanel laminanorte=new JPanel();
		micombo=new JComboBox();
		
		//tipos de letra que tendra el combo, deben ser genericas para evitar incompaibilidad
		micombo.addItem("Serif");
		micombo.addItem("Courier");
		micombo.addItem("Monospaced");
		micombo.addItem("Dialog");
		EventoCombo mievento=new EventoCombo();
	

		//para lograr que el combo se pueda escribir
		micombo.setEditable(true);
		//oyente
		micombo.addActionListener(mievento);
		laminanorte.add(micombo);
		add(laminanorte, BorderLayout.NORTH);
	}
	private class EventoCombo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			//metodo getselecteditem regresa un objeto para que no ocurra error de indefined debe convertirse
			//el objeto a String
			texto.setFont(new Font((String)micombo.getSelectedItem(), Font.PLAIN,18));
		}
		
	}
	private JLabel texto;
	private JComboBox micombo;
}
