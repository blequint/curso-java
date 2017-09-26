package excepciones_I;
import javax.swing.*;
import java.awt.*; //para las imagenes y el panel
import javax.imageio.*; //para leer la imagenes
import java.io.*; //para acceder a una ruta relativa
public class Imagenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoImagen mimarco= new MarcoImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoImagen extends JFrame{
	public MarcoImagen(){
		setTitle("Marco con imagen");
		setBounds(750,300,500,500);
		LaminaConImagen milamina=new LaminaConImagen();
		add(milamina);
		
	}
}

class LaminaConImagen extends JPanel{
	public LaminaConImagen(){
		try{
			//imagen=ImageIO.read(new File("src/graficos/carro.png"));
				imagen=ImageIO.read(new File("src/bola.gif"));
			}
			catch(IOException e){
				System.out.println("La imagen no se encuentra");
			}
	}
	public void paintComponent(Graphics g){
		
	super.paintComponent(g);
	//File miimagen=new File("src/graficos/carro.png");
	
	if(imagen==null){
		g.drawString("No podemos cargar la imagen", 10, 10);
	}else{
		
			int anchuraImagen=imagen.getWidth(this);
			int alturaImagen=imagen.getHeight(this);
			g.drawImage(imagen, 0, 0, null);
			for(int i=0; i<300; i++){
				for(int j=0; j<200; j++){
					
					if(i+j>0){
						g.copyArea(0, 0, anchuraImagen, alturaImagen, i*15, j*15);
					}
				
					
				}
			}
		}
	}
	private Image imagen;
}