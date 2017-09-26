/*video 11 https://www.youtube.com/watch?v=YMyJLs22uY4&index=11&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk*/ 
public class ManipulaCadenas {

	public static void main(String[] args) {
		String nombre="Brenda";
		int ultimaLetra=nombre.length();
		
		System.out.println("Mi nombre es "+ nombre +
				"\nMi nombre tiene "+ nombre.length() 
				+ " letras.\n" + "La primera letra de "
				+ nombre+" es la "+nombre.charAt(0)+
				"\nY la ultima letra es la "+ nombre.charAt(ultimaLetra-1));
	
	}

}
