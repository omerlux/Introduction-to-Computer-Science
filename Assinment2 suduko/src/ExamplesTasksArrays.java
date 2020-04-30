
import java.util.Arrays;

public class ExamplesTasksArrays {
	
	public static void main(String[] args) {
		examplesIsAllDiff () ;
		examplesIsMatrixBetween ();
		examplesColumns () ;
		examplesBlocks () ;
	}
	
	public static void examplesIsAllDiff() {
		int[] array1 = {1,9,3,6} ; 
		if (TasksArrays.isAllDiff(array1) == true)
			System.out.println("OK! array: " + Arrays.toString(array1) + " is all diff");
		else
			throw new IllegalStateException("ERROR! array: " + Arrays.toString(array1) + " should be all diff") ;
		
		
		int[] array2 = {1,4,3,5,1,6} ; 
		if (TasksArrays.isAllDiff(array2) == false)
			System.out.println("OK! array: " + Arrays.toString(array2) + " isn't all diff");
		else
			throw new IllegalStateException("ERROR! array: " + Arrays.toString(array2) + " should not be all diff") ;

		int[] array3 = {} ; 
		if (TasksArrays.isAllDiff(array3) == true)
			System.out.println("OK! array: " + Arrays.toString(array3) + " is all diff");
		else
			throw new IllegalStateException("ERROR! array: " + Arrays.toString(array3) + " should be all diff") ;
	}
	
	public static void examplesIsMatrixBetween() {
		int[][] matrix1 = {{1,2,3},
				   		   {1,2,3},
				   		   {1,2,3}};
		
		int[][] matrix2 = {{1,2,3},
						   null, 
						   {1,2,3}};
		
		int[][] matrix3 = {{1,2,3},
				   		   {10,11,12},
				   		   {1,2,3}}; 

		if (TasksArrays.isMatrixBetween(null, 4, 1, 5) == false)
			System.out.println("OK! null isn't a 4x4 matrix between 1 and 5");
		else
			throw new IllegalStateException("ERROR! null is a 4x4 and between 1 and 5") ;
		
		if (TasksArrays.isMatrixBetween(matrix1, 3, -2, 9) == true)
			System.out.println("OK! matrix:" + Arrays.deepToString(matrix1) + " is 3x3 and between -2 and 9");
		else
			throw new IllegalStateException("ERROR! matrix: " + Arrays.deepToString(matrix1) + " should be 3x3 and between -2 and 9") ;
		 
		if (TasksArrays.isMatrixBetween(matrix2, 3, -2, 9) == false)
			System.out.println("OK! matrix: " + Arrays.deepToString(matrix2) + " isn't a 3x3 matrix between -2 and 9");
		else
			throw new IllegalStateException("ERROR! matrix: " + Arrays.deepToString(matrix2) + " is a 3x3 and between -2 and 9") ;
		
		if (TasksArrays.isMatrixBetween(matrix3, 3, -2, 9) == false)
			System.out.println("OK! matrix: " + Arrays.deepToString(matrix3) + " isn't a 3x3 matrix between -2 and 9");
		else
			throw new IllegalStateException("ERROR! matrix: " + Arrays.deepToString(matrix3) + " is a 3x3 and between -2 and 9") ;
	}
	
	public static void examplesColumns () {
		int[][] matrix1 =  {{1,2,3}, 
						    {4,5,6},
						    {7,8,9}};
		int[][] columns1 = {{1,4,7},
							{2,5,8},
							{3,6,9}} ;
		int[][] matCols1 = TasksArrays.columns(matrix1) ;
		
		if (Arrays.deepEquals(columns1, matCols1))
			System.out.println("OK! columns( " + Arrays.deepToString(matrix1) + " ) := "  + 
												 Arrays.deepToString(matCols1));
		else 
			throw new IllegalStateException("columns of " + Arrays.deepToString(matrix1) + 
											" should be " + Arrays.deepToString(columns1) +
											" instead got " + Arrays.deepToString(matCols1)) ;
	}
	
	public static void examplesBlocks() {
		int[][] matrix1 =  {{11,12,13,14},
							{15,16,17,18},
							{19,20,21,22},
							{23,24,25,26}} ;
		
		int[][] blocks1 = {{11, 12, 15, 16}, 
				 		   {13, 14, 17, 18}, 
				 		   {19, 20, 23, 24}, 
				 		   {21, 22, 25, 26}} ; 

		int[][] matBlocks1 = TasksArrays.blocks (matrix1, 2) ;
		
		if (Arrays.deepEquals(blocks1, matBlocks1))
			System.out.println("OK! columns( " + Arrays.deepToString(matrix1) + " ) := "  + 
												 Arrays.deepToString(matBlocks1));
		else 
			throw new IllegalStateException("blocks of " + Arrays.deepToString(matrix1) + 
											" should be " + Arrays.deepToString(blocks1) +
											" instead got " + Arrays.deepToString(matBlocks1)) ;
	}
}
