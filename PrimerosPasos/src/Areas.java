/*video 17 https://www.youtube.com/watch?v=8t5-D5dZu5Y&index=17&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * 
 * Calculo del area de figuras*/
import java.util.*;
import javax.swing.*;
public class Areas {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Elige una opcion: \n1: Cuadrado"
				+ "\n2: Rectangulo\n3:Triangulo \n4: Circulo");
		int figura=entrada.nextInt();
		
		switch(figura){
		case 1:
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			System.out.println("El area del cuadrado es: "+ Math.pow(lado,2));
			break;
		
		case 2:
			int b=Integer.parseInt(JOptionPane.showInputDialog("Introduce base:"));
			int h=Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));
			System.out.println("El area del rectangulo es "+(b*h));
			break;
		
		case 3:
			 b=Integer.parseInt(JOptionPane.showInputDialog("Introduce base:"));
			h=Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));
			System.out.println("El area del rectangulo es "+(b*h/2));
		
		case 4:
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce radio:"));
			System.out.printf("El area del circulo es: %1.2f ", Math.PI*Math.pow(radio,2));
			
		default:
			System.out.println("La opcion no es correcta");
		}
	}

}
