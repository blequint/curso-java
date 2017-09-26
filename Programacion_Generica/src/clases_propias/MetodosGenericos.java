/*video 166*/
package clases_propias;

import java.util.*;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombres[]={"Zoe", "Maria", "Pepe"};
	
		/*
		String elementos=MisMatrices.getElementos(nombres);
		System.out.println(elementos);
		
		Empleado listaEmpleado[]={new Empleado("Ana",45,2500),
									new Empleado("Ana",45,2500),
									new Empleado("Ana",45,2500),
									new Empleado("Ana",45,2500),
									new Empleado("Ana",45,2500)
									};
	System.out.println(MisMatrices.getElementos(listaEmpleado));
	*/
		
		System.out.println(MisMatrices.getMenor(nombres));
		/*
		Empleado paco=new Empleado("Paco",45,2500);
		Empleado ana=new Empleado("Ana",45,2500);
		Empleado maria=new Empleado("maria",45,2500);
		Empleado[] misEmpleados={paco, ana, maria};
		
		//como no son objetos que implementan la interfaz comparabale marca error, los String si lo implementa
		System.out.print(MisMatrices.getMenor(misEmpleados));
	*/
		Calendar fechas[]={new GregorianCalendar(2015,07,12),
									new GregorianCalendar(2019,10,21),
									new GregorianCalendar(2013,04,12),
									};

			System.out.println(MisMatrices.getMenor(fechas).getTime());
	}

}
class MisMatrices{
/*	public static <T> String getElementos(T[] a){
		
		return "El array tiene " +a.length+" elementos";
	}
	*/
	//metodo para obtener el arreglo menor
		public static <T extends Comparable> T getMenor(T[] a){
			if(a==null || a.length==0) return null;
			
			T elementoMenor=a[0];
			for(int i=1; i<a.length; i++){
				//si el elemento es mayor da 1
				//si es menor es -1
				//si es igual da 0
				//para evitar el error hay que definir que el metodo implementa la interfaz comparable
				if(elementoMenor.compareTo(a[i])>0){
					elementoMenor=a[1];
				}
				
			}
			return elementoMenor;
	}
}
