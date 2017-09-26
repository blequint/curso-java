package clases_propias;

public class Jefe extends Empleado{
	public Jefe(String nombre, int edad, double salario){
		super(nombre, edad, salario);
	}
	double inventivo(double inc){
		return inc;
	}
}
