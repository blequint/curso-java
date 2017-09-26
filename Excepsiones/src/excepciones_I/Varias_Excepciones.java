/*exception aritmetica 5/0
 * y de formato osea toma letras en lugr de numeros
 * */
package excepciones_I;

import javax.swing.*;

public class Varias_Excepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		division();
		}catch(ArithmeticException e){
			System.out.println("No existe un numero entre 0");
			System.out.println(e.getMessage());
			System.out.println("Se ha generado un error de este tipo"+e.getClass());
		}catch(NumberFormatException e){
			System.out.println("No estas introduciendo numeros");
		}
	}
	static void division(){
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
		System.out.println("El resultado es "+num1/num2);
	}

}
