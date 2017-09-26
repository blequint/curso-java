
//video 24 https://www.youtube.com/watch?v=NwztwM_xGgU&index=24&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
import javax.swing.JOptionPane;
public class UsoArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String [] paises=new String[8];
		/*
		paises[0]="España";
		paises[1]="Mexico";
		paises[2]="Colombia";
		paises[3]="Peru";
		paises[4]="Chile";
		paises[5]="Argentina";
		paises[6]="Ecuador";
		paises[7]="Venezuela";
	*/
		//String[] paises={"España","Mexico","Colombia","peru"
		//	+"Chile"+"Argentina"+"Ecuador"+"Venezuela"};
	
	/*for(int i=0; i<8; i++){
		paises[i]=JOptionPane.showInputDialog("Introduce pais");
	}
		
	for(String  elemento:paises){
		System.out.println("Pais: "+ elemento);
	}
	*/
		int[] matriz_aleatorios=new int[150];
		
		for(int i=0; i<matriz_aleatorios.length; i++ ){
			matriz_aleatorios[i]=(int)Math.round(Math.random()*100);
		}
		for(int numeros:matriz_aleatorios){
			System.out.print(numeros + " ");
		}
	}
}
