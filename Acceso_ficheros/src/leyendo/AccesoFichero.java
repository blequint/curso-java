/*video 152 classes reader and writter
 * */
package leyendo;

import java.io.*;

public class AccesoFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeerFichero accediendo=new LeerFichero();
		accediendo.lee();
	}

}
class LeerFichero{
	public void lee(){
		try {
			//lanza una advertencia porque sugiere que cierre la entrada al dejar de utilizarla
			FileReader entrada=new FileReader("C:/Users/BrendaLeticia/Desktop/streams.txt");

			int c=entrada.read();
		
			//un fichero devuelve -1 cuando es leido y llega al final
			while(c!=-1){
				char letra=(char)c;
				System.out.print(letra);
				c=entrada.read();
			}
			entrada.close();
			//IOException es la super clase de todas estas excepciones que nos piden
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
	}
}
