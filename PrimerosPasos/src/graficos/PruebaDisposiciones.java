/*video 115
 * https://www.youtube.com/watch?v=PyjO2FFLnEo&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=115
 * */
package graficos;
import javax.swing.*;
import java.awt.*;
public class PruebaDisposiciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCaja mimarco=new MarcoCaja();
		mimarco.setVisible(true);

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoCaja extends JFrame{
	public MarcoCaja(){
		setTitle("Marco en la caja");
		setBounds(600,350,200,200);
		
		JLabel rotulo1=new JLabel("nombre");
		JTextField texto1=new JTextField(10);
		
		texto1.setMaximumSize(texto1.getPreferredSize());
		Box cajaH1=Box.createHorizontalBox();
		//etiqueta
		cajaH1.add(rotulo1);
		//espacio
		cajaH1.add(Box.createHorizontalStrut(10));
		//cuadro de texto
		cajaH1.add(texto1);
		
		JLabel rotulo2=new JLabel("Contraseña");
		JTextField texto2=new JTextField(10);
		texto2.setMaximumSize(texto2.getPreferredSize());
		Box cajaH2=Box.createHorizontalBox();
		
		cajaH2.add(rotulo2);
		cajaH2.add(Box.createHorizontalStrut(10));
		cajaH2.add(texto2);
		
		JButton boton1=new JButton("OK");
		JButton boton2=new JButton("Cancelar");
		Box cajaH3=Box.createHorizontalBox();
		
		cajaH3.add(boton1);
		cajaH3.add(Box.createGlue());
		cajaH3.add(boton2);
		
		Box cajaVertical=Box.createVerticalBox();
		cajaVertical.add(cajaH1);
		cajaVertical.add(cajaH2);
		cajaVertical.add(cajaH3);
		add(cajaVertical, BorderLayout.CENTER);
	
	}
}
