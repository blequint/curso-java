/*video 157 */
package serializacion;
import java.util.*;
import java.io.*;

public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Administrador jefe=new Administrador("Brenda", 80000,2005,12,15);
		jefe.setIncentivo(500);
		
		Empleado[] personal=new Empleado[3];
		personal[0]=jefe;
		personal[1]=new Empleado("Ana", 25000,2008,10,1);
		personal[2]=new Empleado("Luis", 18000,2012,9,15);
		
		try{
			ObjectOutputStream escribiendoFichero=new ObjectOutputStream(new FileOutputStream("C:/Users/BrendaLeticia/Desktop/serializando_java/empleado.dat"));
			escribiendoFichero.writeObject(personal);
			escribiendoFichero.close();
			
			ObjectInputStream recuperandoFichero=new ObjectInputStream(new FileInputStream("C:/Users/BrendaLeticia/Desktop/serializando_java/empleado.dat"));
			//este metodo devuelve un objeto por lo que es necesario aplicar un casting de arreglo especificamente de empleado
			Empleado[] personalRecuperado=(Empleado[]) recuperandoFichero.readObject();
			recuperandoFichero.close();
			
			for(Empleado e : personalRecuperado){
				System.out.println(e);
			}
		}catch(Exception e){
			
		}
	}
}
/**************************/
//la advertencia que lanza es por que no se esta declarando la variable versionUID para que pueda ser compatible
//con otros programas receptores
//el metodo default es automatico el generado es manual
class Empleado implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Empleado(String nombre, double sueldo, int anio, int mes, int dia){
		 this.nombre=nombre;
		 this.sueldo=sueldo;
		 GregorianCalendar calendario=new GregorianCalendar(anio,mes-1,dia);
		 fechaContrato=calendario.getTime();
	 }
	 public String getNombre(){ return nombre; }
	 public double getSueldo(){ return sueldo; }
	 public Date getFechaContrato(){ return fechaContrato; }
	 
	 public void subirSueldo(double porcentaje){
		 double aumento=sueldo*porcentaje/100;
		 sueldo+=aumento;
	 }
	 //este metodo pertenece a la superclase cosmica Object
	 public String toString(){
		 //da una descripcion de la clase
		 return "Nombre="+nombre+", sueldo="+sueldo+", fecha contato="+fechaContrato;
		 
	 }
	 private String nombre;
	 private double sueldo;
	 private Date fechaContrato;
}
/*******/
class Administrador extends Empleado {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Administrador(String nombre, int sueldo, int anio, int mes, int dia){
		super(nombre,sueldo,anio,mes,dia);
		incentivo=0;
	}
	public double getSueldo(){
		double sueldoBase=super.getSueldo();
		return sueldoBase+incentivo;
	}
	public void setIncentivo(int incentivo){
		this.incentivo=incentivo;
	}
	public String toString(){
		return super.toString()+", Incentivo="+incentivo;
	}
	private int incentivo;
}
