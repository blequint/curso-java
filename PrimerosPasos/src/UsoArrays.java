/*video 23 https://www.youtube.com/watch?v=UID_EKKfpcE&index=23&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk*/
public class UsoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mi_matriz=new int[5];
		
		mi_matriz[0]=5;
		mi_matriz[1]=38;
		mi_matriz[2]=-15;
		mi_matriz[3]=92;
		mi_matriz[4]=71;
		 int [] mi_matriz2={5,38,-15,92,71,95,85,65,25,14,75};
		for(int i=0; i<5;i++){
			System.out.println("Valor del indice "+i+"="
					+mi_matriz[i]);
		}
		for(int k=0; k<mi_matriz2.length; k++){
			System.out.println("Valor del indice "+k+"="
					+mi_matriz2[k]);
		}
	}

}
