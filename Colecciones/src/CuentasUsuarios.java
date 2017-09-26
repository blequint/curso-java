import java.util.*;


/*video 180
 * coleccion de datos de este video
 * No se permite repetir
 * agregar y borrar
 * solo lectura
 * 
 * Coleccion recomendable: set 
 * caracteristicas:
 * No permite elementos duplicados, uso sencillo add, 
 * 
 * sin embargo no tiene acceso aleatorio
 * poca eficiencia en ordenar
 * 
 * La clase especifica a y usar es la clase HASHSET
 * esta es 
 * rapida
 * no duplicados
 * no ordenacion
 * no acc. aleatorio
 * 
 * */
public class CuentasUsuarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cl1=new Cliente("Antonio Banderas", "00001",200000);
		Cliente cl2=new Cliente("Rafael Nadal","00002",250000);
		Cliente cl3=new Cliente("Penelope Cruz","00003",300000);
		Cliente cl4=new Cliente("Julio Iglesias","00004",500000);
		//prueba de duplicados
		Cliente cl5=new Cliente("Julio Iglesias","00004",500000);

		// Set <Cliente> clientesBanco=new Set<Cliente>();
		//marca un error porque es una interfaz y las interfaces no se pueden instanciar
		Set <Cliente> clientesBanco=new HashSet<Cliente>();
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
//prueba de duplicado, java considera los dos objetos diferentes, se debe redefinir el equals en la clase
		clientesBanco.add(cl5);

		//teclas de acceso rapido
		//fore ctrl+espacio
		/*
		for (Cliente cliente : clientesBanco) {
			//acceso radydo: syso ctrl+espacio
			System.out.println(cliente.getNombre()+" "
					+ cliente.getN_cuenta()+" "+ cliente.getSaldo());
			if(cliente.getNombre().equals("Julio Iglesias")){
				//no se puede eliminar una coleccion mientras se recorre con un iterador si se puede
				clientesBanco.remove(cliente);
			}
		}
		*/
		//usp de iterator para eliminar elementos con algun nombre especificado
		Iterator <Cliente> it=clientesBanco.iterator();
		//mientras haya algo que recorrer hacer:
			while(it.hasNext()){
				String nombre_cliente=it.next().getNombre();
				if(nombre_cliente.equals("Julio Iglesias")){
					it.remove();
				}
			}
		
		for (Cliente cliente : clientesBanco) {
			//acceso radydo: syso ctrl+espacio
			System.out.println(cliente.getNombre()+" "
					+ cliente.getN_cuenta()+" "+ cliente.getSaldo());
		
		}
		
		//otra forma de recorrer mediate iteradores (en este caso es mas complejo que usar un foreach)
		//por convencion a un interaddor se le suele llamar it solo para nombres
	/*
		Iterator <Cliente> it=clientesBanco.iterator();
	//mientras haya algo que recorrer hacer:
		while(it.hasNext()){
			//primero debe saltat a su elemento para leer sus caracteristicas
			String nombre_cliente=it.next().getNombre();
			System.out.println(nombre_cliente);
			//si se usa otro next se comera un elemento
			String n_cuenta=it.next().getN_cuenta();
		}
		*/
	}

}
