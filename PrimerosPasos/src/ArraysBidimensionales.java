/*video 25 https://www.youtube.com/watch?v=_tUncS0AsNE&index=25&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk*/
public class ArraysBidimensionales {
	public static void main(String[] args){
		
		/*
		 int[][] matrix=new int[4][5];
		matrix[0][0]=15;
		matrix[0][1]=15;
		matrix[0][2]=15;
		matrix[0][3]=15;
		matrix[0][4]=15;
		
		matrix[1][0]=15;
		matrix[1][1]=15;
		matrix[1][2]=15;
		matrix[1][3]=15;
		matrix[1][4]=15;
		
		matrix[2][0]=15;
		matrix[2][1]=15;
		matrix[2][2]=15;
		matrix[2][3]=15;
		matrix[2][4]=15;
		
		matrix[3][0]=15;
		matrix[3][1]=15;
		matrix[3][2]=15;
		matrix[3][3]=15;
		matrix[3][4]=15;
		
				for(int i=0; i<4; i++){
			for(int j=0; j<5; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		*/
		int [][] matrix={
				{10,15,18,19,21},
				{10,15,18,19,21},
				{10,15,18,19,21},
				{10,15,18,19,21},
				{10,15,18,19,21}
		};
		
		for(int[] fila:matrix){
			System.out.println();
			for(int z: fila){
				System.out.print(z + " ");
			}
		}
	
	}

}
