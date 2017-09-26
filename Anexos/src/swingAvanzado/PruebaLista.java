//video 265 uso de JList
package swingAvanzado;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PruebaLista {

	public static void main(String[] args) {
		JFrame mimarco=new MarcoDeLista();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
	}
}
class MarcoDeLista extends JFrame{
	public MarcoDeLista() {
		setTitle("Prueba de lista");
		setBounds(400,300,400,300);
		String [] meses= {"Enero","Febrero","Abril","Mayo","Junio","Julio","Agosto",
				"Semptiembre","Octubre","Noviembre","Diciembre"};
		
		listaDeMeses=new JList<String> (meses);
		
		listaDeMeses.setVisibleRowCount(4);
		//barra de desplazamiento
		JScrollPane laminaDeDesplazamiento=new JScrollPane(listaDeMeses);
		laminaDeLista=new JPanel();
		laminaDeLista.add(laminaDeDesplazamiento);
		
		//poner a la escucha
		listaDeMeses.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				List<String> valores=listaDeMeses.getSelectedValuesList();
				StringBuilder texto=new StringBuilder("Mes seleccionado: ");
				for(String elemento: valores) {
					String palabra=elemento;
					//agrega la palabra
					texto.append(palabra);
					texto.append(" ");
				}
				rotulo.setText(texto.toString());
			}
			//clase anonima
			
		});
		laminaDeTexto=new JPanel();
		laminaDeTexto=new JPanel();
		rotulo=new JLabel("Mes seleccionado: ");
		laminaDeTexto.add(rotulo);
		add(laminaDeLista, BorderLayout.NORTH);
		add(laminaDeTexto,BorderLayout.SOUTH);
	}
	private JList<String> listaDeMeses;
	private JPanel laminaDeLista, laminaDeTexto;
	private JLabel rotulo;
}
