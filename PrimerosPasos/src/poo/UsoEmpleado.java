/*video 33 https://www.youtube.com/watch?v=l8NmSp7Dz-0&index=33&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk*/
package poo;

import java.util.*;

public class UsoEmpleado {

	public static void main(String[] args) {
	/*
		Empleado empleado1 =new Empleado("Brenda Quintanilla",500,2000,10,31);
		Empleado empleado2=new Empleado("Ana Lopez",6000,2000,10,31);
		Empleado empleado3 =new Empleado("Maria Martin",8000,2000,10,31);
	
		empleado1.SubirSueldo(5);
		empleado2.SubirSueldo(5);
		empleado3.SubirSueldo(5);
	
		System.out.println("nombre: "+empleado1.getNombre()+"sueldo: "+empleado1.getSueldo()+"fecha de alta: "+empleado1.getFechaAlta());
		System.out.println("nombre: "+empleado2.getNombre()+"sueldo: "+empleado2.getSueldo()+"fecha de alta: "+empleado2.getFechaAlta());
		System.out.println("nombre: "+empleado3.getNombre()+"sueldo: "+empleado3.getSueldo()+"fecha de alta: "+empleado3.getFechaAlta());
	*/
		Jefatura jefe_RH=new Jefatura("Brenda",10000,2013,8,10);
		jefe_RH.setIncentivo(1000);
		
		Empleado[] misEmpleados=new Empleado[5];
		misEmpleados[0]=new Empleado("Paco Gomez",85000,1993,12,17);
		misEmpleados[1]=new Empleado("Ana Lopez",95000,2002,02,15);
		misEmpleados[2]=new Empleado("Maria Martin");
		misEmpleados[3]=jefe_RH; //polimorfismo en accion, principio de sustitucion
		misEmpleados[4]=new Jefatura("Jose",10000,1999,5,6);
		Jefatura jefaFinanzas=(Jefatura) misEmpleados[4];
		jefaFinanzas.setIncentivo(55000);
		Empleado directorComercial=new Jefatura("Sandra",8500,1996,10,02);
		Comparable ejemplo=new Empleado("Elizabeth",9500,1995,10,05);
		
		
		if(directorComercial instanceof Empleado){
			System.out.println("Es de tipo jefatura");
		}if(ejemplo instanceof Comparable){
			System.out.println("Implementa la interfaz comparabale");
		}
		/*	
		for(int i=0; i<3; i++){
			misEmpleados[i].SubirSueldo(5);
		}
	*/
		System.out.println(jefaFinanzas.tomarDecisiones("Dar mas dias de vacasiones a los empleados"));
		System.out.println("El jefe "+jefaFinanzas.getNombre()+" tiene un bonus de "+jefaFinanzas.establece_bonus(500));
		System.out.println(misEmpleados[2].getNombre()+" tiene un bonus de "+misEmpleados[2].establece_bonus(200));
		for(Empleado e: misEmpleados){
		e.SubirSueldo(5);
	}
	/*
		for(int i=0;i<3;i++){
			System.out.println("Nombre"+misEmpleados[i].getNombre()+"Fecha de alta: "+misEmpleados[i].getFechaAlta()+"sueldo: "+misEmpleados[i].getSueldo());
		}
	*/
	Arrays.sort(misEmpleados);
	for(Empleado e:misEmpleados){
		System.out.println("Nombre"+e.getNombre()+"Fecha de alta: "+e.getFechaAlta()+"sueldo: "+""+e.getSueldo()+" id: "+e.getId());
	}
	}

}

class Empleado implements Comparable, Trabajadores{

	 
	 public Empleado(String nombre, double sueldo, int anio, int mes, int dia){
		 this.nombre=nombre;
		 this.sueldo=sueldo;
		GregorianCalendar calendario=new GregorianCalendar(anio,mes-1,dia);
		 this.fechaAlta=calendario.getTime();	 
		 this.id=idSiguiente;
		idSiguiente++;
	 }
	 public Empleado(String nombre){
		 this(nombre,30000,2000,01,01);
		 
	 }
	 public double establece_bonus(double gratificacion){
		 return Trabajadores.bonus_base+gratificacion;
	 }
	 
	 public int getId(){
		 return this.id;
	 }
	 public String getNombre(){
		 return this.nombre;
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
	 public int compareTo(Object miObjeto){
		 Empleado otroEmpleado=(Empleado) miObjeto;
		 if(this.id<otroEmpleado.id){
			 return -1;
		 }
		 if(this.id>otroEmpleado.id){
			 return 1;
		 }
		 else
			 return 0;
	 }
	 private String nombre;
	 private double sueldo;
	 private Date fechaAlta;
	 private int id;
	 private static int idSiguiente=1;
}

final class Jefatura extends Empleado implements Jefes{
	public Jefatura(String nombre, double sueldo, int anio, int mes, int dia){
		super(nombre, sueldo, anio,mes,dia);
		
	}
	public String tomarDecisiones(String decision){
		return "Un miembro de la direccion ha tomado la decision de "+decision;
	}
	public double establece_bonus(double gratificacion){
		double prima=2000;
		
		return Trabajadores.bonus_base+gratificacion+prima;
	}
	public void setIncentivo(double incentivo){
		this.incentivo=incentivo;
	}
	public double getSueldo(){
		double sueldoJefe=super.getSueldo();
		return sueldoJefe+ this.incentivo;
	}
	
	private double incentivo;
	
	
}

/*no puede heredar por ser final*//*
class Director extends Jefatura{
	
}
*/
