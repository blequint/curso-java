
public class UsoLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libro libro1=new Libro("P en Java", "Juan",25);
		Libro libro2=new Libro("P en Java", "Juan",5);
		
		//libro1=libro2;
		
		//prueba de equals, equals se debe redefinir para que funcione en CLASES PROPIAS 
		//redefinido en la clase
		if(libro1.equals(libro2)){
			System.out.println("Mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}else {
			//al ser dos objetos diferentes tienen un hashcode diferentes el hashcode es una ubicacion de la memoria heap en referencia al objeto
			System.out.println("No es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());

		}
		

	}

}
