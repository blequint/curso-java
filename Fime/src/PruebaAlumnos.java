import java.awt.*;
import javax.swing.*;

public class PruebaAlumnos{
public static void main(String [] args){
	Alumnos a1=new Alumnos("AlumnoA");
	Alumnos a2=new Alumnos("AlumboB","ITS");
	Alumnos a3=new Alumnos();
	
	System.out.println("El alumno: "+a2.getNombre());
	System.out.println("Carrera"+ a2.getCarrera());
	a1.Inscripcion(a1.getDigito());
	
}
}

class Alumnos {

	private String nombre, carrera;
	private int digito=(int)(Math.random()*10);
	
	public Alumnos(){
		this.nombre="";
		this.carrera="";
	}
	public Alumnos(String nombre, String carrera){
		this.nombre=nombre;
		this.carrera=carrera;
	}
	public Alumnos(String nombre){
		this.nombre=nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setCarrera(){
		this.carrera=carrera;
	}
	public String getCarrera(){
		return this.carrera;
	}
	public int getDigito(){
		return this.digito;
	}
	public void Inscripcion(int num){
		System.out.println("Ultimo digito ="+ num);
		switch(num){
			case 0: case 1: System.out.println("Le toca inscribirse en lunes"); break;
			case 2: case 3: System.out.println("Le toca inscribirse en martes"); break;
			case 4: case 5: System.out.println("Le toca inscribirse en miercoles"); break;
			case 6: case 7: System.out.println("Le toca inscribirse en jueves"); break;
			case 8: case 9: System.out.println("Le toca inscribirse en viernes"); break;
				default: break;
		}
		
	}
}
