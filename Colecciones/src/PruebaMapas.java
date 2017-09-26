/*video 189 
interface map
clase: hashmap
son parecidos a los arreglos asociativos

las interfaces tambien pueden tener interfaces internas
*/
import java.util.*;
public class PruebaMapas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//clave y valor
		HashMap<String,Empleado> personal=new HashMap<String, Empleado>();
		
		personal.put("145", new Empleado("Juan"));
		personal.put("146", new Empleado("Ana"));
		personal.put("147", new Empleado("Antonio"));
		personal.put("148", new Empleado("Sandra"));
		
		
		System.out.println(personal);
		
		//si quiero eliminar alguno por su clave
		personal.remove("147");
		System.out.println(personal);
		//si quiero reemplazar algun elemento debo usar la misma clave
		personal.put("148", new Empleado("Natala"));
		System.out.println(personal);
		
		//entruset() nos devuelve una coleccion de tipo set y nos la imprime
		//System.out.println(personal.entrySet());
		
		//para hacer el formato que queramos
		for(Map.Entry<String, Empleado> entrada : personal.entrySet()){
			//almacena en una variable String la clave y valor
			String clave=entrada.getKey();
			Empleado valor=entrada.getValue();
			System.out.println("Clave= "+clave+", valor="+valor);
			
		}

	}

}

class Empleado{
	public Empleado(String n){
		nombre=n;
		sueldo=2000;
	}
	public String toString(){
		return "[Nombre= "+nombre+", sueldo="+sueldo+"]";
	}
	private String nombre;
	private double sueldo;
}
