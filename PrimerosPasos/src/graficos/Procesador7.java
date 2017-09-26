/*
 * video 114
 * */


package graficos;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.text.StyledEditorKit.ItalicAction;
import javax.swing.text.StyledEditorKit.UnderlineAction;

import java.awt.event.*;
import java.awt.*;

public class Procesador7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador7 mimarco=new MenuProcesador7();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MenuProcesador7 extends JFrame{
	public MenuProcesador7(){
		setBounds(500,300,550,400);
		LaminaProcesador7 milamina=new LaminaProcesador7();
		add(milamina);
		setVisible(true);
		
	}
}
class LaminaProcesador7 extends JPanel{
	public LaminaProcesador7(){
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

		//por defecto la barra se pone en horizontal esto es para cambiarla en vertical
		//0 es horizontal y 1 es vertical
		barra=new JToolBar();
		configura_barra("bin/graficos/negrita.png").addActionListener(new StyledEditorKit.BoldAction());
		configura_barra("bin/graficos/cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		configura_barra("bin/graficos/subrayado.png").addActionListener(new StyledEditorKit.UnderlineAction());
		
		barra.addSeparator();
		
		configura_barra("bin/graficos/bola_azul.gif").addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.BLUE));
		configura_barra("bin/graficos/bola_amarilla.png").addActionListener(new StyledEditorKit.ForegroundAction("amarillo", Color.YELLOW));
		configura_barra("bin/graficos/rojo.jpg").addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.RED));
		
		barra.addSeparator();
		
		configura_barra("bin/graficos/izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("izq", StyleConstants.ALIGN_LEFT));
		configura_barra("bin/graficos/centrar.png").addActionListener(new StyledEditorKit.AlignmentAction("DERECHA", StyleConstants.ALIGN_CENTER));
		configura_barra("bin/graficos/derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("justificado", StyleConstants.ALIGN_RIGHT));
		configura_barra("bin/graficos/justificado.png").addActionListener(new StyledEditorKit.AlignmentAction("justificado", StyleConstants.ALIGN_JUSTIFIED));
		
		barra.setOrientation(1);
		add(barra,BorderLayout.WEST);
		
	}
	//un metodo que nos regresa un boton
	public JButton configura_barra(String ruta){
		JButton boton=new JButton(new ImageIcon(ruta));
		barra.add(boton);
		return boton;
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
	JButton negritaBarra, cursivaBarra, subraBarra, azulBarra, rojoBarra, amarilloBarra, a_izquierda, a_centrado, a_derecha, a_justificado;
	JToolBar barra;
}
