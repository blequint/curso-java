/*video 155*/
package leyendo_escribiendo_bytes;
import java.io.*;
public class LecturaEscritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador=0;
		//numero que dio el contador
		int datosEntrada[]=new int[5249918];
		try{
			FileInputStream archivoLectura=new FileInputStream("C:/Users/BrendaLeticia/Desktop/leyendoimgjava/imagen.jpg");
			boolean final_ar=false;
			
			//cuando es true
			while(!final_ar){
				
				//lee byte abyte la imagen
				int byte_entrada=archivoLectura.read();
				//cuando es -1 ya termino de leer 
				if(byte_entrada!=-1){
					datosEntrada[contador]=byte_entrada;
				}
				else final_ar=true;
				
				System.out.println(byte_entrada);
				contador++;
			}
			archivoLectura.close();
		}catch(IOException e){ System.out.println("Error al acceder a la imagen");}
		System.out.println(contador);
		
		creaFichero(datosEntrada);
	}
	//tiene que ser estatico porque sera llamado desde el main y no devuelve valores
	static void creaFichero(int datos_nuevo_fichero[]){
		try{
			FileOutputStream ficheroNuevo=new FileOutputStream("C:/Users/BrendaLeticia/Desktop/leyendoimgjava/imagen_copia.jpg");
			for(int i=0; i<datos_nuevo_fichero.length; i++){
				ficheroNuevo.write(datos_nuevo_fichero[i]);;
			}
			ficheroNuevo.close();
			
		}catch(IOException e){
			System.out.println("No se a podido crear el archivo");
		}
	}
}
