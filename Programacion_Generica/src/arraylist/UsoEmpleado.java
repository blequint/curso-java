/*video 161 */
package arraylist;
import java.util.*;
public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Empleado listaEmpleado[]=new Empleado[3];
		
		listaEmpleado[0]=new Empleado("Ana",45,2500);
		listaEmpleado[1]=new Empleado("Ana",45,2500);
		listaEmpleado[2]=new Empleado("Ana",45,2500);
		*/
		//almacena objetos no datos primitivos 
		ArrayList <Empleado> listaEmpleado=new ArrayList <Empleado>();
		//se usa para resrvar un espacio en memoria inicial evitando el gasto de recursos sin embargo aun asi se
		//puede almacenar mas de lo que se define
		listaEmpleado.ensureCapacity(11);
		listaEmpleado.add(new Empleado("Ana",45,2500));
		listaEmpleado.add(new Empleado("Antonio",55,2000));
		listaEmpleado.add(new Empleado("Maria",25,2600));
		//el metodo set puede reemplazar en la posicion de donde queramos que este
		listaEmpleado.set(1,new Empleado("Olga",25,2600));
	//	System.out.println(listaEmpleado.get(2).getDatos());
		//al estar seguro de que ya no se almacenaran mas arreglos se usa el TrimToSize para recortar los espacios que no se usarion
		listaEmpleado.trimToSize();
		//sin embargo aun asi puedo agregar mas elementos
		//para saber cual es el tamaño de mi lista
//		System.out.println(listaEmpleado.size());
		
		/*
		for(Empleado e: listaEmpleado){
			System.out.println(e.getDatos());
		}
		*/
		//otra manera de imprimir 
	/*
		for(int i=0; i<listaEmpleado.size(); i++){
			Empleado e=listaEmpleado.get(i);
			System.out.println(e.getDatos());
		}
	*/ 
		//otra manera de imprimir convirtiendo el array list a un array
		/*
		Empleado arrayEmpleados[]=new Empleado[listaEmpleado.size()];
		listaEmpleado.toArray(arrayEmpleados);
		for (int i=0; i<arrayEmpleados.length; i++){
			System.out.println(arrayEmpleados[i].getDatos());
		}
		*/
		//otra manera de imprimir
		Iterator <Empleado> miIterador=listaEmpleado.iterator();
		while(miIterador.hasNext()){
			System.out.println(miIterador.next().getDatos());
		}
	}

}
class Empleado{
	public Empleado(String nombre, int edad, double salario){
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	public String getDatos(){
		return "El empleado se llama "+nombre+". Tiene "+edad+" años."+" Y un salario de "+salario;
	}
	private String nombre;
	private int edad;
	private double salario;
}