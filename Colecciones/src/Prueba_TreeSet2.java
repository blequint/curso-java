/*video 187
 *Solucion al problema de ordenamiento de la interfaz comparable: interfaz comparator 
 *el problema es que estoy obligada a usar la clase comparable para usar comparator
 **/

import java.util.*;
public class Prueba_TreeSet2 {

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
		Articulo2 primero = new Articulo2(1,"Primer articulo");
		Articulo2 segundo= new Articulo2(2,"A segundo articulo");
		Articulo2 tercer = new Articulo2(3,"tercero articulo");
		TreeSet<Articulo2> ordenaArticulos=new TreeSet<Articulo2>();
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		for (Articulo2 art : ordenaArticulos) {
			System.out.println(art.getDescripcion());
			
		}
		System.out.println();

		
		//este objeto unicamente comparara, por lo cual no necesita parametros
		Articulo2 comparadorArticulos=new Articulo2();
		//esta instruccion define que se ordenaran de acuerdo al objeto que se haya definido
		TreeSet <Articulo2> ordenaArticulos2=new TreeSet<Articulo2>(comparadorArticulos);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercer);
		
		for (Articulo2 art : ordenaArticulos2) {
			System.out.println(art.getDescripcion());
		}

	}

}

class Articulo2 implements Comparable<Articulo2>, Comparator<Articulo2>{
	public Articulo2(int num, String desc){
		numero_articulo=num;
		descripcion=desc; 
	}
	public Articulo2(){

	}
	@Override
	public int compareTo(Articulo2 o) {
		
		// TODO Auto-generated method stub
		//los ordenara por el numero de articulo
		return numero_articulo-o.numero_articulo;
	}
	public String getDescripcion(){
		return descripcion;
	}
	private int numero_articulo;
	private String descripcion;
	
	@Override
	//ordenar alfabeticamente
	public int compare(Articulo2 arg0, Articulo2 arg1) {
		// TODO Auto-generated method stub
		String descripcionA=arg0.getDescripcion();
		String descripcionB=arg1.getDescripcion();
		
			
		return descripcionA.compareTo(descripcionB);
	}
	
}
