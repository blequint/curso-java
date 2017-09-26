/*video 28 y 29 y 30 y 31 41
 * https://www.youtube.com/watch?v=ZY5pwm92cWQ&index=28&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk*/
package poo;

//import javax.swing.*;
public class UsoVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Coche renault=new Coche(); //instanciar una clase
		Coche miCoche1=new Coche();
		miCoche1.setColor("Rojo");
		
		Furgoneta furgoneta1=new Furgoneta(5,580);
		furgoneta1.setColor("Verde");
		furgoneta1.setAsientosCuero("si");
		furgoneta1.setClimatizador("Si");
		
		System.out.println(miCoche1.getDatosGenerales()+"\n"+miCoche1.getColor());
		System.out.println(furgoneta1.getDatosFurgoneta()+"\n"+furgoneta1.getDatosGenerales()
				+"\nColor: "+furgoneta1.getColor());
		/*
		renault.setColor(JOptionPane.showInputDialog("Introduce color"));
		System.out.println(renault.getColor());
		renault.setAsientosCuero(JOptionPane.showInputDialog("Tiene asientos de cuero?"));
		System.out.println(renault.getAsientosCuero());
		System.out.println(renault.CalculaPesoTotal());
		System.out.println(renault.CalculaPrecio());
		System.out.println(renault.getDatosGenerales());
	
	*/
	}	

}
