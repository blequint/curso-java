/*
 * video 26 https://www.youtube.com/watch?v=xEHkuRApCno&index=26&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk
 * Calculo del 10,11,12,13,14,15 % de interes acumulado de la cantidad de 10,000 en 5 años */
public class Array2D {

	public static void main(String[] args) {
		double acumulado;
		double interes=0.10;
		
		double [][] saldo=new double [6][5];
		
		for(int i=0; i<6; i++){
			saldo[i][0]=10000;
			acumulado=10000;
			for(int j=1; j<5; j++){
				acumulado=acumulado+(acumulado*interes);
				saldo[i][j]=acumulado;
				
			}
			interes=interes+0.01;
		}
		System.out.println("10%\t  11%\t   12%\t    13%\t      14%\t15%\t");
		for(int z=0; z<5; z++){
			System.out.println();
			for(int h=0; h<6; h++){
				System.out.printf("%1.2f", saldo[h][z]);
				System.out.print(" ");
			}
		}
	}

}
