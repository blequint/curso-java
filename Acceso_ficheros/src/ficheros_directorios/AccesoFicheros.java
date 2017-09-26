package ficheros_directorios;
import java.io.*;

/*imprime en consola los directorios y subdirectorios de una ruta especifica*/
public class AccesoFicheros {
	public static void main(String [] args){
	//para asegurar la compatibilidad de la interpretacion de la ruta en todos los SO se usa .separator
	File ruta=new File("C:"+File.separator+"Users"+File.separator+"BrendaLeticia"+File.separator+"Desktop"+File.separator+"serializando_java");
	System.out.println(ruta.getAbsolutePath());
	
	String[] nombresArchivos=ruta.list();
	for(String a : nombresArchivos){
		File f=new File(ruta.getAbsoluteFile(),a);
		if(f.isDirectory()){
			String[] archivos_subcarpeta=f.list();
			for(String b: archivos_subcarpeta){
				System.out.println(b);
			}
		}
		System.out.println(a);
		
	}
	}
}
