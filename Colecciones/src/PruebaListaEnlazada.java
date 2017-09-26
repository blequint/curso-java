/*video 185*/
/*ligando paises con capitales
 * los elementos se enlazan con los que estan al siguiente  de estos
 * despues, eliminar las capitales pares */
import java.util.*;

public class PruebaListaEnlazada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> paises=new LinkedList<String>();
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Peru");
		
		LinkedList<String> capitales=new LinkedList<String>();
		capitales.add("Madrid");
		capitales.add("Bogota");
		capitales.add("DF");
		capitales.add("Lima");
		
	//	System.out.println(paises);
	//	System.out.println(capitales);

		ListIterator<String> iterA=paises.listIterator();
		ListIterator<String> iterB=capitales.listIterator();
		//para ligar un pais con su capital:
		
		//mientras alla un siguiente elemento en capitales
		while(iterA.hasNext()){
			//si iter de paises tiene un siguiente elemento
			if(iterA.hasNext()){
				iterA.next();
				
			}
			iterA.add(iterB.next());
		}
System.out.println(paises);
//instruccion que hace que vuelva el it a su posicion inicial
		iterB=capitales.listIterator();
		//mientras alla un segundo elemento
		while(iterB.hasNext()){
			iterB.next();
			if(iterB.hasNext()){
				//mientras alla un segundo elemento vuelve a saltar, saltando en numeros pares
				iterB.next();
				iterB.remove();
			}
		}
		System.out.println(capitales);
		//eliminara madrid y mexico
		paises.removeAll(capitales);
		System.out.println(paises);
	}

}
