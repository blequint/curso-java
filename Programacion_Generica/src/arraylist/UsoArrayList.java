/*video 164 la programacion generica existio apartir de la versio 5 de java */
package arraylist;

import java.io.*;

public class UsoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList2 archivos=new ArrayList2(5);
		
		archivos.add("Juan");
		archivos.add("Maria");
		archivos.add("Ana");
		archivos.add("Sandra");
		//sin la programacion generica genera errores de ejecucion
		//la programacion generia genera errores de tipo de datos de compilacion, los cuales los marca eclipse
		archivos.add(new File("gestion_Pedidos.accdb"));
		//la programacion generica evita el uso de castings 	
		String nombrePersona=(String)archivos.get(4);
		
		
	//	archivos.add(new File("gestion_pedidos.accdb"));
	//	File nombrePersona=(File)archivos.get(0);
		System.out.println(nombrePersona);
	}

}
