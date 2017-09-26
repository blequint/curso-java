
public class UsoFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={5,4,2,3,5,8};
		
		System.out.println("Factorial: "+factorial(3));
		System.out.println("Multiplicacion: "+mult(4,3));
		System.out.println("Exponente:"+exp(5,3));
		System.out.println("Suma de arreglo: "+ sumaArreglo(num, num.length));
		System.out.println("Suma digitos: "+ sumaEntero(1255));
	}
	
	public static int factorial(int n){
		if(n==0){
			return 1;
		}
		return n*factorial(n-1);
	}
	public static int mult(int a, int b){
		//a+(a*b-1)
		if(b==0){
			return 0;
		}else{
		return a+mult(a,b-1);
		}
	}
	public static int exp(int a, int b){
		//a*a^b-1
		if(b==0) return 1;
		else return a*exp(a,b-1);
	}
	public static int sumaArreglo(int[] a, int n){
		if(n-1==0){
			return a[0];
		}else return a[n-1]+ sumaArreglo(a,n-1);
		
	}
	public static int sumaEntero(int n){
		if(n<10){
			return n;
		}else
			return n%10 +sumaEntero(n/10);
		
	}

}
	


