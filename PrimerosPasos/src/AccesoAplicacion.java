/*
 * video 18 https://www.youtube.com/watch?v=HQz8xwAjCsI&index=18&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * metodo de acceso de una aplicacion con contrase�a*/

import javax.swing.*;
public class AccesoAplicacion {

	public static void main(String[] args) {
		String clave="Brenda";
		String pass="";
		
		while(clave.equals(pass)==false){
			pass=JOptionPane.showInputDialog("Introduce la contrase�a");
			
			if(clave.equals(pass)==false)
				System.out.println("Contrase�a incorrecta");
		}
		System.out.println("Contrase�a correcta. Acceso permitido");

	}

}
