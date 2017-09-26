/*video 186
 * interfaz set
 * clase: TreeSet
 * tiene en su interior la clase comparable con el metodo compareTo
 * 
 * el problema es que no se puede redefinir la interface comparable para que te ordene por otro criterio
 * */

import java.util.*;
public class Prueba_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		TreeSet<String> ordenaPersonas=new TreeSet<String>();
		ordenaPersonas.add("Sandra");
		ordenaPersonas.add("Amanda");
		ordenaPersonas.add("Diana");

		//orden ascendente por defecto
		for(String s: ordenaPersonas){
			System.out.println(s);
		}
		*/
		Articulo primero = new Articulo(1,"Primer articulo");
		Articulo segundo= new Articulo(2,"segundo articulo");
		Articulo tercer = new Articulo(3,"tercero articulo");
		
		TreeSet<Articulo> ordenaArticulos=new TreeSet<Articulo>();
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		for (Articulo art : ordenaArticulos) {
			System.out.println(art.getDescripcion());
			
		}
	}

}

class Articulo implements Comparable<Articulo>{
	public Articulo(int num, String desc){
		numero_articulo=num;
		descripcion=desc; 
	}
	@Override
	public int compareTo(Articulo o) {
		
		// TODO Auto-generated method stub
		//los ordenara por el numero de articulo
		return numero_articulo-o.numero_articulo;
	}
	public String getDescripcion(){
		return descripcion;
	}
	private int numero_articulo;
	private String descripcion;
	
}
