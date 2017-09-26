package ficheros_directorios;
import java.io.*;
public class Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ruta=new File("C:"+File.separator+"Users"+File.separator+"BrendaLeticia"+File.separator+"Desktop"+File.separator+"serializando_java"+File.separator+"nuevo_directorio"+File.separator+"nuevo_archivo.txt");
		ruta.delete();
	}

}
