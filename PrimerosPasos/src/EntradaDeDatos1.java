/*video 14 https://www.youtube.com/watch?v=Ng0_7uZyIoA&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=14*/

import java.util.*;


public class EntradaDeDatos1 {

	public static void main(String[] args) {
		Scanner entrada= new Scanner(System.in);
		
		System.out.println("Introduce tu nombre: ");
		String nombre_usuario=entrada.nextLine();
		System.out.println("Introduce edad: ");
		int edad=entrada.nextInt();
		
		System.out.println("Hola "+nombre_usuario+" El año que viene tendras "+
		(edad + 1) + " años");
	}

}
