//omer luxembourg 205500390 30.11.2017
public class TasksArrays {

	public static boolean isAllDiff(int[] array) {
		boolean distinct = true; //while I didn't find the same value its all distinct.
		for(int i=0; i<array.length & distinct; i=i+1){ //i stands for the cell i'm checking
			for(int j=0; j<array.length & distinct; j=j+1){ //j stands for the other cells im comparing to
				if(i!=j & array[i]==array[j]) //if i=j its the same cell > pass it. if not and the same > its not distinct.
					distinct = false;
			}
		}			
		return distinct ;
	}
	
	public static boolean isMatrixBetween(int[][] matrix, int n, int min, int max) { //check if matrix is nXn and min<=[i][j]<=max. null in one of the arrays is fine.
		boolean valid = true;
		if(matrix==null) //check if matrix is full
			valid=false;
		else if(matrix.length!=n) //check if matrix is with n rows
			valid=false;
		for (int i=0; valid && i<matrix.length; i=i+1){ //i is for the line ***valid comes before to avoid error of .length from null!
			if(matrix[i]==null || matrix.length!=n) //if the row is empty or (|| to avoid error from null) if the row is not n length
				valid=false;
			else{
				for(int j=0; j<n & valid; j=j+1) //j is for the rows
					if(matrix[i][j]>max | matrix[i][j]<min) //checks if min is minimum and max is maximum
						valid=false;
			}
		}	
		return valid;
	}
	
	public static int[][] columns (int[][] matrix) {
		int [][] MatrixCols = new int [matrix.length][matrix.length]; //new matrix of columns
		for (int j=0; j<matrix.length; j=j+1) //j = old matrix columns
			for(int i=0; i<matrix.length; i=i+1) // i = old matrix rows
				MatrixCols[j][i]=matrix[i][j]; // i will move down in the old matrix, and i will move "right" in the new one.
		return MatrixCols;
	}
	
	public static int[][] blocks(int[][] matrix, int sqrtN) { //sqrtN >=2 matrix isn't null and is nXn
		int [][] Blox = new int [matrix.length][matrix.length];// creating the block matrix
		int BloxRows=0;
		int BloxCols=0; //where i put the values in the Blox matrix.
		for(int i=0; i<matrix.length; i=i+sqrtN){ 
			for(int j=0; j<matrix.length; j=j+sqrtN){ // 2 fors that jumps from block to block
				for(int matRow=0; matRow<sqrtN; matRow=matRow+1){
					for(int matCol=0; matCol<sqrtN; matCol=matCol+1){
						Blox[BloxRows][BloxCols]=matrix[matRow+i][matCol+j]; //original matrix rows and columns
						BloxCols=BloxCols+1; //counter Blox columns
					}
				}
				BloxCols=0; // reset the Cols counter for a new block
				BloxRows=BloxRows+1; //next row for Blox
			}
		}
		return Blox;
	}
}
