/*video 36 y 37 https://www.youtube.com/watch?v=tZekQAcSY8o&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=36*/
package poo;

public class PruebaConstantes {

	public static void main(String[] args) {
		Empleados trabajador1=new Empleados("Brenda");
		Empleados trabajador2=new Empleados("Paco");
		Empleados trabajador3=new Empleados("Maria");
		Empleados trabajador4=new Empleados("Jose");
		
		trabajador1.cambiarSeccion("RH");
		System.out.println(trabajador1.devuelveDatos()
				+"\n"+trabajador2.devuelveDatos()+"\n"
				+trabajador3.devuelveDatos()+"\n"+
				trabajador4.devuelveDatos());
	System.out.println(Empleados.dameIdSiguiente());
	}

}

class Empleados{
	public Empleados(String nombre){
		this.nombre=nombre;
		this.seccion="Administación";
		id=idSiguiente;
		idSiguiente++;
	}
	/*
public void cambiaNombre(String nombre){
	this.nombre=nombre;
}
*/
	public void cambiarSeccion(String seccion){
		this.seccion=seccion;
	}
	public String getSeccion(){
		return this.seccion;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String devuelveDatos(){
		return "El nombe es: "+nombre+" la seccion es "+seccion+" Su id es "+id;
	}
	
	public static String dameIdSiguiente(){
		return "El id siguiente es: "+idSiguiente;
	}
	private final String nombre;
	private String seccion;
	private int id;
	private static int idSiguiente=1;
}
