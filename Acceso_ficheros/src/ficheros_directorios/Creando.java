/*video 160 creando directorios*/
package ficheros_directorios;

import java.io.*;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ruta=new File("C:"+File.separator+"Users"+File.separator+"BrendaLeticia"+File.separator+"Desktop"+File.separator+"serializando_java"+File.separator+"nuevo_directorio"+File.separator+"nuevo_archivo.txt");
		//crea directorios
	//	ruta.mkdir();
		
		String archivo_destino=ruta.getAbsolutePath();
		try {
			ruta.createNewFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no se pudo crear el archivo");
		}
		Escribiendo2 accede_es=new Escribiendo2();
		accede_es.escribir(archivo_destino);
		System.out.println(archivo_destino);
	}

}
class Escribiendo2{
	public void escribir(String ruta_archivo){
		String frase="Esto es un ejemplo";
		try{
			FileWriter escritura= new FileWriter(ruta_archivo);
			for(int i=0; i<frase.length();i++){
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		}catch(IOException e){
			System.out.println("no se pudo escribir el archivo");
		}
	}
}