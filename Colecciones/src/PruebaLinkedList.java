/*video 184*/
/*inteface list
 * linkedlist
 * son mejores que los arraylist en cuanto a eficiencia
 * 
 * un iterator sirve para definir donde queremos agregar nuestro elemento 
 *
 * */
import java.util.*;
public class PruebaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList <String> personas=new LinkedList<String>();
		personas.add("Pepe");
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		
		System.out.println(personas.size());
		//siempre se agrega al ultimo
		// un listIterator tiene mas metodos que el iterator
		ListIterator <String> it=personas.listIterator();
		//al darle un next se regresa al principio y da un salto para el segundo elemento y entre ese espacio agregaria el elemento indicado
		it.next();
		it.add("Brenda");
		personas.add("Juan");
		for(String persona : personas){
			System.out.println(persona);
		}

	}

}
