/*
 * video 46 https://www.youtube.com/watch?v=LDZUBY0mxv8&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=46
 * */
package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {
	public static void main(String[] args){
		Persona[] lasPersonas=new Persona[2];
		lasPersonas[0]=new Empleado2("Diana",20000,1996,01,25);
		lasPersonas[1]=new Alumno("Brenda","Ingenieria en Sistemas");
		
		for(Persona e: lasPersonas){
			System.out.println(e.getNombre()+", "+e.dameDescripcion());
		}
	}
	
	
}
abstract class Persona{
	
	public Persona(String nombre){
		this.nombre=nombre;
	}
	public abstract String dameDescripcion();
	
	public String getNombre(){
		 return this.nombre;
	 }
	private String nombre; 
}

class Empleado2 extends Persona{

	 
	 public Empleado2(String nombre, double sueldo, int anio, int mes, int dia){
		
		 super(nombre);
		 this.sueldo=sueldo;
		GregorianCalendar calendario=new GregorianCalendar(anio,mes-1,dia);
		 this.fechaAlta=calendario.getTime();	 
		 this.id=idSiguiente;
		idSiguiente++;
	 }
	 public String dameDescripcion(){
		 return "Este empleado tiene un Id "+this.id+" con un sueldo de "
				 +this.sueldo;
	 }
	 

	 public int getId(){
		 return this.id;
	 }

	 public double getSueldo(){
		 return this.sueldo;
	 }
	 public Date getFechaAlta(){
		 return this.fechaAlta;
	 }
	 public void SubirSueldo(double porcentaje){
		 double aumento=this.sueldo*porcentaje/100;
		 this.sueldo+=aumento;
	 }
	 
	 
	 private double sueldo;
	 private Date fechaAlta;
	 private int id;
	 private static int idSiguiente=1;
}
class Alumno extends Persona{
	public Alumno(String nombre, String carrera){
		super(nombre);
		this.carrera=carrera;
	}
	public String dameDescripcion(){
		return "Este alumno esta estudiando la carrera de "+this.carrera;
	}
	private String carrera;
}
