/*
 * video 106 
 * checky button 108 

https://www.youtube.com/watch?v=2KvnW3fv4xg&index=108&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * */


package graficos;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

import java.awt.event.*;
import java.awt.*;

public class Procesador4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador4 mimarco=new MenuProcesador4();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MenuProcesador4 extends JFrame{
	public MenuProcesador4(){
		setBounds(500,300,550,400);
		LaminaProcesador4 milamina=new LaminaProcesador4();
		add(milamina);
		setVisible(true);
		
	}
}
class LaminaProcesador4 extends JPanel{
	public LaminaProcesador4(){
		setLayout(new BorderLayout());
		JPanel laminamenu=new JPanel();

		JMenuBar mibarra=new JMenuBar();
		
		fuente=new JMenu("Fuente");
		estilo=new JMenu("Estilo");
		tamanio=new JMenu("Tamaņo");
		
	
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
		//configuraMenu("Negrita", "estilo", "", Font.BOLD, 1, "bin/graficos/negrita.png" );
	//	configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1, "bin/graficos/cursiva.png");
		
		JCheckBoxMenuItem negrita= new JCheckBoxMenuItem("Negrita", new ImageIcon("bin/graficos/negrita.png"));
		JCheckBoxMenuItem cursiva= new JCheckBoxMenuItem("Cursiva", new ImageIcon("bin/graficos/cursiva.png"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		estilo.add(negrita);
		estilo.add(cursiva);
		
		//no toma en cuenta nada fuera relativo a tamanio
		/*
		configuraMenu("12", "tamanio", "", 1, 12, "");
		configuraMenu("16", "tamanio", "", 1, 16, "");
		configuraMenu("20", "tamanio", "", 1, 20, "");
		configuraMenu("24", "tamanio", "", 1, 24, "");
		*/
		ButtonGroup tamanioLetra=new ButtonGroup();
		JRadioButtonMenuItem doce=new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis=new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24");
		tamanioLetra.add(doce);
		tamanioLetra.add(dieciseis);
		tamanioLetra.add(veinte);
		tamanioLetra.add(veinticuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaņo", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaņo", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaņo", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaņo", 24));

		tamanio.add(doce);
		tamanio.add(dieciseis);
		tamanio.add(veinte);
		tamanio.add(veinticuatro);

		
		laminamenu.add(mibarra);
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		
	
	
		
	}
	//rotulo especifica el elemento del menu, menu especifica el elemento si pertenece a fuente, 
	//estilo o tamanio, tipoLetra es psts modificar la fuente, int estilos para modificar si es negrita cursiva
	//etc y es int porque es una constante,y int tam para el tamaņo de letra
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam, String icon){
		//
		
		JMenuItem elemMenu=new JMenuItem(rotulo, new ImageIcon(icon));
		if(menu=="fuente"){
			fuente.add(elemMenu);
			if(tipoLetra=="Arial"){
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaTamaņo", "Arial"));

			}else
			if(tipoLetra=="Courier"){
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaTamaņo", "Courier"));

			}else if(tipoLetra=="Verdana"){
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaTamaņo", "Verdana"));

			}
		}/*else if(menu=="estilo"){
			estilo.add(elemMenu);
			if(estilos==Font.BOLD)
			elemMenu.addActionListener(new StyledEditorKit.BoldAction());

		}
		if(estilos==Font.ITALIC)
		elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
*/
		else if(menu=="tamanio"){
			tamanio.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaņo", tam));
		}
		
		
	}
	

	
	JTextPane miarea;
	JMenu fuente, estilo, tamanio;
	Font letras;
}
