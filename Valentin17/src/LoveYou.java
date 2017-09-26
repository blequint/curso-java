

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

public class LoveYou {

	public static void main(String[] args) {
		ArrayList <Marco> ventana=new ArrayList <Marco>();
		String[] frase={"Se ha detectado un virus","¡Alerta!","JAJA NTC","Es broma","Hola bebe", "Hoy es un día especial", "Feliz 14 de febrero","Año 2017","Dia del amors..","Y la amistad",
				"Un día","Para expresar","Lo bonito que es el amors", "Nuesto primer 14 <3", "Y aunque no nos veamos", "Quiero decirte", "Que..."};
		JOptionPane.showMessageDialog(null, "Contenido potencialmente peligroso.", "Alerta", JOptionPane.WARNING_MESSAGE);
		for(int i=0; i<frase.length; i++){
			int x=0;
			int y=0;
			Toolkit.getDefaultToolkit().beep();
			ventana.add(new Marco(frase[i],x+(i*15),y+(i*15)));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			}
	/*************************************************************/	
		for(int i=0; i<50; i++){
	
			Toolkit.getDefaultToolkit().beep();
			ventana.add(new Marco("TE AMO",1,1));
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			}
			
	}

}
class Marco extends JFrame{
	public Marco(String frase, int x, int y){
		//setBounds(50,50,350,150);
		setTitle("Brenda & Javier");
		
		///************/

		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		int alturaPantalla=tamanoPantalla.height/2;
		int anchoPantalla=tamanoPantalla.width/2;
		
		setSize(350,150);
		/*
		
		if((x%2)==0){
			alturaPantalla=tamanoPantalla.height/3+(y);
			anchoPantalla=tamanoPantalla.width/3+(x);
		
		}else{
			alturaPantalla=tamanoPantalla.height/3+(y*-1);
			anchoPantalla=tamanoPantalla.width/3+(x*-1);
		
		}
		
		
		System.out.println("Pantalla alto"+tamanoPantalla.height);
		System.out.println("Pantalla ancho"+tamanoPantalla.width+"\n");
		System.out.println("altura ventana"+alturaPantalla/3);
		System.out.println("ancho ventana"+anchoPantalla/3);
		System.out.println("x: "+(int)(Math.random()*tamanoPantalla.width)+" y: "+(int)(Math.random()*tamanoPantalla.height));
		*/
		setLocation((int)(Math.random()*(tamanoPantalla.width-350)),(int)(Math.random()*(tamanoPantalla.height-150)));
		
		URL love=Marco.class.getResource("love.png");
		Image miIcono=mipantalla.getImage(love);
		setIconImage(miIcono);
		/********/
		
		Lamina milamina=new Lamina(frase);
		add(milamina);
		setVisible(true);
		
		
	}

}

class Lamina extends JPanel{
	public Lamina(String frase){
		
		setLayout(new BorderLayout());
		JLabel texto=new JLabel(frase);
		texto.setFont(new Font("Georgia", Font.PLAIN, 20));
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		add(texto,BorderLayout.CENTER);
	}
}
