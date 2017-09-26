/*
 * 
 * */

package ordenamiento;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={6,7,8,10};
		int[] B={3,6,7,8,9};
		int[] C=new int[A.length+B.length];
		int k=0;
		int i=0, j=0;
		while(i<A.length && j<B.length ){
			if(A[i]<=B[j]){
				C[k]=A[i]; i++; k++;
			}
			else if(B[j]<=A[i]) {
				C[k]=B[j]; j++;	k++;
			}
		}
		
		while(i<A.length){
			C[k++]=A[i++];	
		}
		
		while(j<B.length){
			C[k++]=B[j++];
			
		}
		
		
		for(int a : C){
			System.out.println(a);
		}
			
			
		}

	}


