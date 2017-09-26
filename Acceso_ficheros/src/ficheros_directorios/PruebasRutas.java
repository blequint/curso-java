/*video 159*/
package ficheros_directorios;
import java.io.*;
public class PruebasRutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//cuando no se especifica ruta toma por defecto la ruta del workspace del eclipse
		//lee tanto archivos como carpetas
		File archivo=new File("bin");
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.exists());
	}

}
