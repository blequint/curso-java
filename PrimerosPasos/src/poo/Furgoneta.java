/*video 40 y 41
https://www.youtube.com/watch?v=wqoyQ3BxK4A&index=40&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
*/
package poo;

public class Furgoneta extends Coche {
	private int capacidadCarga;
	private int plazasExtra;
	
	public Furgoneta(int plazasExtra, int capacidadCarga){
		super(); //llama al constructor de la clase padre
		this.capacidadCarga=capacidadCarga;
		this.plazasExtra=plazasExtra;
	}
	public String getDatosFurgoneta(){
		return "La capacidad de carga es "+capacidadCarga+
				"Y las plazas son: "+plazasExtra;
	}
}
