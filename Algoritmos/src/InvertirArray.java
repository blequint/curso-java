
public class InvertirArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arreglo={1,2,3,4,5,6,7,8};
		int aux;
		int n=arreglo.length-1;
		for(int i=0; i<n; i++){
			
			
			aux=arreglo[i];
			arreglo[i]=arreglo[n-i];
			arreglo[n-i]=aux; 
			
		}
		for(int k=0; k<arreglo.length; k++){
			System.out.println(arreglo[k]);
		}
	}

}
