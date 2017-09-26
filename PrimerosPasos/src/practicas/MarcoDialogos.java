package practicas;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

public class MarcoDialogos extends JFrame{
	
	public MarcoDialogos(){
		setTitle("Prueba de diálogos");
		setBounds(500,300,600,450);
		
		JPanel laminaCuadricula=new JPanel();
		laminaCuadricula.setLayout(new GridLayout(2,3));
		
		String primero[]={"Mensaje","Confirmar","Opcion", "Entrada"};

	
		
		laminaTipo=new LaminaBotones("Tipo", primero);
		laminaTipoMensaje=new LaminaBotones("Tipo de Mensaje",new String[]{"ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE"});
		laminaMensaje=new LaminaBotones("Mensaje", new String[] { "Cadena","Icono","Componente","Otros","Object[]"});
		laminaConfirmar=new LaminaBotones("Confirmar", new String[]{"DEFAULT_OPTION","YES_NO_OPTION","OK_CANCEL_OPTION"});
		laminaOpcion=new LaminaBotones("Opcion", new String[]{"String[]","Icon[]","Object[]"});
		laminaEntrada=new LaminaBotones("Entrada", new String[]{"Campo de texto","Combo"});

		setLayout(new BorderLayout());
		laminaCuadricula.add(laminaTipo);
		laminaCuadricula.add(laminaTipoMensaje);
		laminaCuadricula.add(laminaMensaje);
		laminaCuadricula.add(laminaConfirmar);
		laminaCuadricula.add(laminaOpcion);
		laminaCuadricula.add(laminaEntrada);
		
		
		add(laminaCuadricula, BorderLayout.CENTER);
		
		
		JPanel laminaMostrar=new JPanel();
		mostrar=new JButton("Mostrar");
		mostrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(laminaTipo.dameSeleccion());
				
				
				if(laminaTipo.dameSeleccion().equals("Mensaje")){
					JOptionPane.showMessageDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensaje));
				}else if(laminaTipo.dameSeleccion().equals("Confirmar")){
					JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaConfirmar),dameTipo(laminaTipoMensaje));
				}else if(laminaTipo.dameSeleccion().equals("Entrada")){
					if(laminaEntrada.dameSeleccion().equals("Campo de texto")){
						JOptionPane.showInputDialog(MarcoDialogos.this,dameMensaje(), "Titulo", dameTipo(laminaTipoMensaje));
						}else{
							JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaTipoMensaje),null, new String[]{"Amarillo","Azul","Rojo"},null);
							
						}
				}else if(laminaTipo.dameSeleccion().equals("Opcion")){
					JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(), "Titulo", dameTipo(laminaConfirmar), dameTipo(laminaTipoMensaje), null, dameOpciones(laminaOpcion), null);
				}
			}});
		laminaMostrar.add(mostrar);
		add(laminaMostrar, BorderLayout.SOUTH);
	
		
	}
	/********PROPORCIONA MENSAJE****/
	public Object dameMensaje(){
		String s=laminaMensaje.dameSeleccion();
		
		if(s.equals("Cadena")){
			return cadenaMensaje;
		}else if(s.equals("Icono")){
			return iconoMensaje;
		}else if(s.equals("Componente")){
			return componenteMensaje;
		}else if(s.equals("Otros")){
			return objetoMensaje;
		}else if(s.equals("Object[]")){
			return new Object[]{cadenaMensaje,iconoMensaje,componenteMensaje,objetoMensaje};
		}else
			return null;
	}
	
	/************/
	//proporciona icono y numero de botones en confirmar
	public int dameTipo(LaminaBotones lamina){
		String s=lamina.dameSeleccion();
		if(s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")){
			return 0;
		}
		if(s.equals("INFORMATION_MESSAGE") || s.equals("OK_CANCEL_OPTION")){
			return 1;
		}
		if(s.equals("WARNING_MESSAGE")){
			return 2;
		}
		if(s.equals("QUESTION_MESSAGE")){
			return 3;
		}
		if(s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")){
			return -1;
		}
		else
		return 0;
	}
	/*********da opciones a la lamina opcion*/
	public Object[] dameOpciones(LaminaBotones lamina){
		String s=lamina.dameSeleccion();
		if(s.equals("String[]")){
			return new String[] {"Amarillo","Azul","Rojo"};
		}else if(s.equals("Icon[]")){
			return new Object[]{new ImageIcon("src/graficos/bola_azul.gif"), new ImageIcon("src/graficos/bola_amarilla.png"), new ImageIcon("src/graficos/rojo.jpg")};
		}else if(s.equals("Object[]")){
			return new Object[]{cadenaMensaje,iconoMensaje,componenteMensaje,objetoMensaje};
		}
		else
		return null;
	}
	
	private LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje, laminaConfirmar, laminaOpcion,laminaEntrada;
	private JButton mostrar;
	private String cadenaMensaje="Mensaje";
	private Icon iconoMensaje=new ImageIcon("src/graficos/bola_azul.gif");
	private Object objetoMensaje=new Date();
	private Component componenteMensaje=new LaminaEjemplo();
}

class LaminaEjemplo extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle2D rectangulo=new Rectangle2D.Double(0,0,getWidth(),getHeight());
		g2.setPaint(Color.BLUE);
		g2.fill(rectangulo);
	}
	
}
