import javax.swing.*;
public class EntradaDeNumeros {

	public static void main(String[] args) {
		double x=1000;
		System.out.println(x);
		System.out.printf("%1.2f", x/3);
		
		String num1=JOptionPane.showInputDialog("Introduce un numero");
		Double num2=Double.parseDouble(num1);
		System.out.print("\n\nLa raiz de "+num2+" es");
		System.out.printf("%1.2f", Math.sqrt(num2));
	}

}
