//es recomendable llamar a los paquetes con el nombre del dominio

package pildorasinformaticas.com.CalculosMatematicos;

public class Calculos {
	private static int resultado;
	
	//los metodos staticos forzadamente requiere variables estaticas

	public static int metodoSuma(int num1, int num2){
		resultado=num1+num2;
		return resultado;
	}
	public static int metodoResta(int num1, int num2){
		resultado=num1-num2;
		return resultado;
	}
	public static int metodoMultiplica(int num1, int num2){
		resultado=num1*num2;
		return resultado;
	}

}
