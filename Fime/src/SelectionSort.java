public class SelectionSort {
 
    public static void main(String a[]){
    	
    	int[] lista={11,4,1,5,10,1}; 
    	 int i,j,k,temp,menor;
         
        for ( i = 0; i <lista.length; i++)
        {
            menor = lista[i];
            for ( j = i, k=i; j < lista.length; j++){
                if (menor > lista[j]){
                    menor = lista[j];
            		k=j;
                }
      
           
        }
        temp= lista[i]; 
        lista[i] = lista[k];
        lista[k] = temp;
     
    }
        for(int a1 : lista){
			System.out.println(a1);
		}
    }
}
     
   

