/*video 16 https://www.youtube.com/watch?v=b2ZtZndiT1Y&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=16*/
import java.util.*;

public class CondicionalIf_EvaluaEdad {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce tu edad:");
		int edad=entrada.nextInt();
		
		if(edad < 18){
			System.out.print("Eres un adolescente");
		}
		else if(edad < 40){
			System.out.print("Eres joven");
		}
		else if(edad <65){
			System.out.print("Eres maduro");
		}
		else{
			System.out.print("Cuidate");
		}
	}

}
