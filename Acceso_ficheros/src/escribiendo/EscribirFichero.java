package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escribiendo accede_es=new Escribiendo();
		accede_es.escribir();
	}

}
class Escribiendo{
	public void escribir(){
		String frase="Esto es una prueba de escritura";
		
		try {
			//si quiero que sea un archivo nuevo es asi
			FileWriter escritura=new FileWriter("C:/Users/BrendaLeticia/Desktop/streamNuevo.txt");
			//si quiero reutilizar un archivo es
			//FileWriter escritura=new FileWriter("C:/Users/BrendaLeticia/Desktop/streamNuevo.txt",true);

			for(int i=0; i<frase.length(); i++){
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
