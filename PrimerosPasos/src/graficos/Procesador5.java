/*
 * video 106 
 * /*112 barra de herramientas
 * checky button 108 
 * menu emergente 109
https://www.youtube.com/watch?v=2KvnW3fv4xg&index=108&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * */


package graficos;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import java.awt.event.*;
import java.awt.*;

public class Procesador5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador5 mimarco=new MenuProcesador5();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MenuProcesador5 extends JFrame{
	public MenuProcesador5(){
		setBounds(500,300,550,400);
		LaminaProcesador5 milamina=new LaminaProcesador5();
		add(milamina);
		setVisible(true);
		
	}
}
class LaminaProcesador5 extends JPanel{
	public LaminaProcesador5(){
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
		/*
		JCheckBoxMenuItem negrita= new JCheckBoxMenuItem("Negrita", new ImageIcon("bin/graficos/negrita.png"));
		JCheckBoxMenuItem cursiva= new JCheckBoxMenuItem("Cursiva", new ImageIcon("bin/graficos/cursiva.png"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		estilo.add(negrita);
		estilo.add(cursiva);
		*/
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
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 24));

		tamanio.add(doce);
		tamanio.add(dieciseis);
		tamanio.add(veinte);
		tamanio.add(veinticuatro);

		
		laminamenu.add(mibarra);
		add(laminamenu,BorderLayout.NORTH);
		
		miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		
		// menu emergente
		JPopupMenu emergente=new JPopupMenu();
		JMenuItem negritaE=new JMenuItem("Negrita");
		emergente.add(negritaE);
		JMenuItem cursivaE=new JMenuItem("Cursiva");
		emergente.add(cursivaE);
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		miarea.setComponentPopupMenu(emergente);
		
		/************************/
		
		JToolBar barra=new JToolBar();
		JButton negritaBarra=new JButton(new ImageIcon("bin/graficos/negrita.png"));
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		barra.add(negritaBarra);
		
		JButton cursivaBarra=new JButton(new ImageIcon("bin/graficos/cursiva.png"));
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());

		barra.add(cursivaBarra);
		
		JButton subraBarra=new JButton(new ImageIcon("bin/graficos/subrayado.png"));
		subraBarra.addActionListener(new StyledEditorKit.UnderlineAction());

		barra.add(subraBarra);
		JButton azulBarra=new JButton(new ImageIcon("src/graficos/bola_azul.gif"));
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.BLUE));

		barra.add(azulBarra);
		JButton amarilloBarra=new JButton(new ImageIcon("bin/graficos/bola_amarilla.png"));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));

		barra.add(amarilloBarra);
		JButton rojoBarra=new JButton(new ImageIcon("bin/graficos/rojo.jpg"));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));

		barra.add(rojoBarra);
		/****************************************/
		JButton a_izquierda=new JButton(new ImageIcon("bin/graficos/izquierda.png"));
		rojoBarra.addActionListener(new StyledEditorKit.AlignmentAction("izquierda", StyleConstants.ALIGN_LEFT));

		barra.add(a_izquierda);

		JButton a_centrado=new JButton(new ImageIcon("bin/graficos/centrar.png"));
		a_centrado.addActionListener(new StyledEditorKit.AlignmentAction("centrado", StyleConstants.ALIGN_CENTER));

		barra.add(a_centrado);
		
		JButton a_derecha=new JButton(new ImageIcon("bin/graficos/derecha.png"));
		a_derecha.addActionListener(new StyledEditorKit.AlignmentAction("derecha", StyleConstants.ALIGN_RIGHT));

		barra.add(a_derecha);
		
		JButton a_justificado=new JButton(new ImageIcon("bin/graficos/justificado.png"));
		a_justificado.addActionListener(new StyledEditorKit.AlignmentAction("justificado", StyleConstants.ALIGN_JUSTIFIED));

		barra.add(a_justificado);
		
		
		
		
		//por defecto la barra se pone en horizontal esto es para cambiarla en vertical
		//0 es horizontal y 1 es vertical
		barra.setOrientation(1);
		add(barra,BorderLayout.WEST);
		
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
