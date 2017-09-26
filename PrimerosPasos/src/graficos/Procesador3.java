/*
 * video 106 y 107
 * https://www.youtube.com/watch?v=4WmRgXXJaK0&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=103
 * */


package graficos;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

import java.awt.event.*;
import java.awt.*;

public class Procesador3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador3 mimarco=new MenuProcesador3();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MenuProcesador3 extends JFrame{
	public MenuProcesador3(){
		setBounds(500,300,550,400);
		LaminaProcesador3 milamina=new LaminaProcesador3();
		add(milamina);
		setVisible(true);
		
	}
}
class LaminaProcesador3 extends JPanel{
	public LaminaProcesador3(){
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
		configuraMenu("Arial", "fuente", "Arial", 9, 10, "");
		configuraMenu("Courier", "fuente", "Courier", 9, 10, "");
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10, "");
		
		//-------estilo-----
		//no toma en cuenta nada fuera relativo a estilo
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1, "bin/graficos/negrita.png" );
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1, "bin/graficos/cursiva.png");
		
		//no toma en cuenta nada fuera relativo a tamanio
		configuraMenu("12", "tamanio", "", 1, 12, "");
		configuraMenu("16", "tamanio", "", 1, 16, "");
		configuraMenu("20", "tamanio", "", 1, 20, "");
		configuraMenu("24", "tamanio", "", 1, 24, "");
		

		
		laminamenu.add(mibarra);
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
	
		
	}
	//rotulo especifica el elemento del menu, menu especifica el elemento si pertenece a fuente, 
	//estilo o tamanio, tipoLetra es psts modificar la fuente, int estilos para modificar si es negrita cursiva
	//etc y es int porque es una constante,y int tam para el tamaño de letra
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam, String icon){
		//
		
		JMenuItem elemMenu=new JMenuItem(rotulo, new ImageIcon(icon));
		if(menu=="fuente"){
			fuente.add(elemMenu);
			if(tipoLetra=="Arial"){
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaTamaño", "Arial"));

			}else
			if(tipoLetra=="Courier"){
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaTamaño", "Courier"));

			}else if(tipoLetra=="Verdana"){
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaTamaño", "Verdana"));

			}
		}else if(menu=="estilo"){
			estilo.add(elemMenu);
			if(estilos==Font.BOLD)
			elemMenu.addActionListener(new StyledEditorKit.BoldAction());

		}
		if(estilos==Font.ITALIC)
		elemMenu.addActionListener(new StyledEditorKit.ItalicAction());

		else if(menu=="tamanio"){
			tamanio.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", tam));
		}
		
		
	}
	

	
	JTextPane miarea;
	JMenu fuente, estilo, tamanio;
	Font letras;
}
