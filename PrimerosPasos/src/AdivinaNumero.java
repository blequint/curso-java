/*
 * video 19 y 20 https://www.youtube.com/watch?v=TMIoxn4nMtA&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=19
 * adivinacion de un numero*/

import java.util.*;
public class AdivinaNumero {

	public static void main(String[] args) {
		int aleatorio=(int)(Math.random()*100);
		Scanner entrada= new Scanner(System.in);
		int numero=0;
		int intentos=0;
		
		do{
			System.out.println("Introduce un numero: ");
			numero=entrada.nextInt();
			if(aleatorio < numero){
				System.out.println("Mas bajo");
			}
			else if(aleatorio > numero){
				System.out.println("Mas alto");
			}
		
			intentos++;
		}while(numero!=aleatorio);
		System.out.println("Correcto");
		System.out.println("Numero de intentos: "+intentos);

	}

}
