/*
 * video 103,104,105
 * https://www.youtube.com/watch?v=4WmRgXXJaK0&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=103
 * */


package graficos;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Procesador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador2 mimarco=new MenuProcesador2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MenuProcesador2 extends JFrame{
	public MenuProcesador2(){
		setBounds(500,300,550,400);
		LaminaProcesador2 milamina=new LaminaProcesador2();
		add(milamina);
		setVisible(true);
		
	}
}
class LaminaProcesador2 extends JPanel{
	public LaminaProcesador2(){
		setLayout(new BorderLayout());
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		estilo=new JMenu("Estilo");
		tamanio=new JMenu("Tamaño");
		
	
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamanio);
		
		
		//fuente------
		//no toma en cuenta nada fuera relativo a fuente
		configuraMenu("Arial", "fuente", "Arial", 9, 10);
		configuraMenu("Courier", "fuente", "Courier", 9, 10);
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10);
		
		//-------estilo-----
		//no toma en cuenta nada fuera relativo a estilo
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
		
		//no toma en cuenta nada fuera relativo a tamanio
		configuraMenu("12", "tamanio", "", 1, 12);
		configuraMenu("16", "tamanio", "", 1, 16);
		configuraMenu("20", "tamanio", "", 1, 20);
		configuraMenu("24", "tamanio", "", 1, 24);
		
		JPanel descripcion=new JPanel();
		 textoDescripcion=new JLabel();

		descripcion.add(textoDescripcion);
		add(descripcion,BorderLayout.EAST);
		
		laminamenu.add(mibarra);
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		
	}
	//rotulo especifica el elemento del menu, menu especifica el elemento si pertenece a fuente, 
	//estilo o tamanio, tipoLetra es psts modificar la fuente, int estilos para modificar si es negrita cursiva
	//etc y es int porque es una constante,y int tam para el tamaño de letra
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam){
		//
		
		JMenuItem elemMenu=new JMenuItem(rotulo);
		if(menu=="fuente"){
			fuente.add(elemMenu);
		}else if(menu=="estilo"){
			estilo.add(elemMenu);
		}
		else if(menu=="tamanio"){
			tamanio.add(elemMenu);
		}
		elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
	}
	
	private class GestionaEventos implements ActionListener{
		String tipoTexto, menu;
		int estiloLetra, tamanioLetra;
		
		
		//el elemento se refiere al elemento que fue pulsado arial, 14 etc
		//texto2 almacena el tipo de fuentess
		//almacena el estilo que se haya pulsado
		//almacena el tamaño de la letra
		public GestionaEventos(String elemento, String texto2, int estilo2, int tamLetra){
			tipoTexto=texto2;
			estiloLetra=estilo2;
			tamanioLetra=tamLetra;
			menu=elemento;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			letras=miarea.getFont();
			
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana"){
				estiloLetra=letras.getStyle();
				tamanioLetra=letras.getSize();
			}
			else if(menu=="Cursiva" || menu=="Negrita"){
				if(letras.getStyle()==1 || letras.getStyle()==2){
					//si ya estaba aplicada la negrita o cursiva se van a sumar las dos
					estiloLetra=3;
				}
				tipoTexto=letras.getFontName();
				tamanioLetra=letras.getSize();
			}
			else if(menu=="12" || menu=="16" || menu=="20" || menu=="24"){
				tipoTexto=letras.getFontName();
				estiloLetra=letras.getStyle();
			}
			miarea.setFont(new Font(tipoTexto, estiloLetra, tamanioLetra));
			
			
			textoDescripcion.setText("Tipo: "+tipoTexto+"\n Estilo: "+estiloLetra+"\nTamaño: "+tamanioLetra);
			System.out.println("Tipo: "+tipoTexto+"\n Estilo: "+estiloLetra+"\nTamaño: "+tamanioLetra);
		}
		
	}
	
	JTextPane miarea;
	JMenu fuente, estilo, tamanio;
	Font letras;
	JLabel textoDescripcion;
}
