package ordenamiento;

public class Pilas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]=new int[10];
		int max=A.length-1;
		int base=0, tope=-1;
		
		tope=push(A,max,tope,5,base);
		tope=push(A,max,tope,8,base);
		tope=push(A,max,tope,4,base);

		tope=pop(A, tope, 0, base);
		
		
		for(int i=base; i<=tope; i++){
			System.out.println(A[i]);
		}
		System.out.println("\nEl tope es:"+tope);
	}
	
	public static int push(int[] pila, int max, int tope, int dato, int base){
		if(tope == max && base==0){
			System.out.println("Pila llena");
			return 0;
			
		}else {pila[++tope]=dato;
			return tope;
		}
		
	}
	public static int pop(int []pila, int tope, int dato, int base){
		if(tope>0){
			dato=pila[tope--];
			return tope;
		}else { System.out.println("Pila vacia"); return 0; }
	}

}

