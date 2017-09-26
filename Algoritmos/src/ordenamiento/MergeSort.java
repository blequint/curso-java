//mezclar dos barajas ordenadas en una sola
//baraja left: 2,4,5,6,7,8
//baraja derecha: 1,2,3,4,6,7

package ordenamiento;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={2,4,5,6,7,8,1,2,3,4,6,7};

		int n1,n2,p,q,r;
		
		p=0;
		q=((A.length-1)/2); 
		r=A.length-1;
		n1=q-p+1;
		n2=r-q;
		
		//System.out.println(n2);
		
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		
		for(int i=0; i<(n1+1); i++){
			L[i]=A[p+(i+1)-1];
			if(i==n1){
				L[i]=9999;
			}
		}
		
		
		for(int j=0; j<n2; j++){
			R[j]=A[q+1+j];
			
		}
	R[n2]=9999;
	
	int i=0, j=0;
	for(int k=p; k<=r; k++){
		if(L[i]<=R[j]){
			A[k]=L[i];
			i++;
		}
		else{
			A[k] = R[j];
			j++;
		
		}
		
	}
	
		
		
		for(int z: A){
			System.out.println(z);
		}
	}

}
