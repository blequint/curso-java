/*video 15 https://www.youtube.com/watch?v=F_48qh3BcDs&index=15&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk*/

import javax.swing.*;
public class EntradaDeDatos2 {

	public static void main(String[] args) {
		String nombre_usuario=JOptionPane.showInputDialog("Introduce tu nombre: ");
		String edad=JOptionPane.showInputDialog("Introduce la edad");
		int edad_usuario=Integer.parseInt(edad);
		edad_usuario++;
		System.out.println("Hola "+nombre_usuario+". El año que viene tendras "+edad_usuario+" años");
	
	}

}
