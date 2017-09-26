/*Recomendado para ordenamientos pequeños*/
package ordenamiento;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A={5,2,4,6,1,3,0};
		
		//ascendente
		for(int j=1; j<A.length; j++){
			int key=A[j];
			//inserta A[j] en el orden secuencial
			int i=j-1;
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i=i-1;
				A[i+1]=key;
			}
		}
		
		//descendente
		/*
		for(int j=1; j<A.length; j++){
			int key=A[j];
			//inserta A[j] en el orden secuencial
			int i=j-1;
			while(i>=0 && A[i]<key){
				A[i+1]=A[i];
				i=i-1;
				A[i+1]=key;
			}
		}
		*/
		for(int x : A){
			System.out.println(x);
		}

	}

}
