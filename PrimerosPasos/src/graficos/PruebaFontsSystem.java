package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

import javax.swing.JOptionPane;

public class PruebaFontsSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean estalafuente=false;
		String[] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		String fuente=JOptionPane.showInputDialog("Introduce fuente");
		for(String nombredelafuente: nombresDeFuentes){
			//System.out.println(nombredelafuente);
			if(nombredelafuente.equals(fuente)){
				estalafuente=true;
			}
		}
		if(estalafuente){
			System.out.println("Fuente instalada");
		}else System.out.println("fuente no instalada");
	}
}
