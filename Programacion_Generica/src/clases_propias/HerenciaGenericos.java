package clases_propias;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Empleado Administrativa=new Empleado("Elena",45,1500);
		//Jefe DirectoraComercial=new Jefe("Ana",27,3500);
		
		//Empleado nuevoEmpleado=DirectoraComercial;
		Pareja<Empleado> Administrativa=new Pareja<Empleado>();
		Pareja<Jefe> DirectoraComercial=new Pareja<Jefe>();
		//la programacion generica no funciona con el principio de sustitucion
		//principio de sustitucion un jefe ES UN  empleado
		//Pareja<Empleado> nuevoEmpleado=DirectoraComercial;
		
		//restriccion de la programacion generica solucion: comodin en la clase pareja
		Pareja.imprimirTrabajador(Administrativa);
		Pareja.imprimirTrabajador(DirectoraComercial);
	}

}
