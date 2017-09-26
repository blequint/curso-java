/*video 188
 *Solucion al problema de estarme obligada a usar la clase comparable para usar comparator
 **/

import java.util.*;
public class Prueba_TreeSet3 {

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
		Articulo3 primero = new Articulo3(1,"Primer articulo");
		Articulo3 segundo= new Articulo3(2,"A segundo articulo");
		Articulo3 tercer = new Articulo3(3,"tercero articulo");
		TreeSet<Articulo3> ordenaArticulos=new TreeSet<Articulo3>();
		ordenaArticulos.add(tercer);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(segundo);
		for (Articulo3 art : ordenaArticulos) {
			System.out.println(art.getDescripcion());
			
		}
		System.out.println();
//utilizando una clase externa
		// ComparadorArticulos compara_ant=new ComparadorArticulos();
	//	 TreeSet<Articulo3> ordenaArticulos2=new TreeSet<Articulo3>(compara_ant);
		//utilizando una clase anonima 
		TreeSet<Articulo3> ordenaArticulos2=new TreeSet<Articulo3>(new Comparator<Articulo3>(){
			public int compare(Articulo3 arg0, Articulo3 arg1) {
				// TODO Auto-generated method stub
				String desc1=arg0.getDescripcion();
				String desc2=arg1.getDescripcion();
				
				return desc1.compareTo(desc2);
			}
		});

		 
		 ordenaArticulos2.add(primero);
		 ordenaArticulos2.add(segundo);
		 ordenaArticulos2.add(tercer);
	
		 for (Articulo3 art : ordenaArticulos2) {
			System.out.println(art.getDescripcion());
		}
	}

}

class Articulo3 implements Comparable<Articulo3>{
	public Articulo3(int num, String desc){
		numero_articulo=num;
		descripcion=desc; 
	}

	@Override
	public int compareTo(Articulo3 o) {
		
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
/*
//se crea una clase independiente
class ComparadorArticulos implements Comparator<Articulo3>{

	@Override
	public int compare(Articulo3 arg0, Articulo3 arg1) {
		// TODO Auto-generated method stub
		String desc1=arg0.getDescripcion();
		String desc2=arg1.getDescripcion();
		
		return desc1.compareTo(desc2);
	}
	
}
*/
	
