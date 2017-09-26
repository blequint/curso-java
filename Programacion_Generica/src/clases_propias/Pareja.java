/*video 165*/
package clases_propias;

//La T es un generico por convension se usa T, U o K
public class Pareja<T>{
	public Pareja(){
		primero=null;
	}
	public void setPrimero(T nuevoValor){
		primero=nuevoValor;
	}
	public T getPrimero(){
		return primero;
	}
	
	//comodin para reerire a todos los tipos de empleado y pueda aplicar herencia
	public static void imprimirTrabajador(Pareja <? extends Empleado> p){
		Empleado primero=p.getPrimero();
	}
	private T primero;
}
