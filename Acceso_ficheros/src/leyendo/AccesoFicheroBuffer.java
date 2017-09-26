/*video 152 classes reader and writter
 * */
package leyendo;

import java.io.*;

public class AccesoFicheroBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeerFichero2 accediendo=new LeerFichero2();
		accediendo.lee();
	}

}
class LeerFichero2{
	public void lee(){
		try {
			//lanza una advertencia porque sugiere que cierre la entrada al dejar de utilizarla
			FileReader entrada=new FileReader("C:/Users/BrendaLeticia/Desktop/streams.txt");
			
			BufferedReader mibuffer=new BufferedReader(entrada);
			String linea="";
		
			//un fichero devuelve -1 cuando es leido y llega al final
			while(linea!=null){
				linea=mibuffer.readLine();
				if(linea!=null)
				System.out.println(linea);
				
			}
			entrada.close();
			//IOException es la super clase de todas estas excepciones que nos piden
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
	}
}
