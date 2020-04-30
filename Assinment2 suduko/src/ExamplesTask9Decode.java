
import java.util.Arrays;

public class ExamplesTask9Decode {
	
	public static void main(String[] args) {
		int n = 4 ;
		int [][][] map = {{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
		  		  {{17, 18, 19, 20}, {21, 22, 23, 24}, {25, 26, 27, 28}, {29, 30, 31, 32}}, 
		  		  {{33, 34, 35, 36}, {37, 38, 39, 40}, {41, 42, 43, 44}, {45, 46, 47, 48}}, 
		  		  {{49, 50, 51, 52}, {53, 54, 55, 56}, {57, 58, 59, 60}, {61, 62, 63, 64}}} ;
		boolean [] assignment = 
			{true,
			 false, true, false, false, true, false, false, false, false, false, false, true, false, false, true, false,
		  	 false, false, true, false, false, false, false, true, true, false, false, false, false, true, false, false, 
		  	 false, false, false, true, false, true, false, false, false, false, true, false, true, false, false, false, 
		  	 true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true} ;
		int [][] board = {{2,1,4,3},
						  {3,4,1,2},
						  {4,2,3,1},
						  {1,3,2,4}} ;
		
		/*
		 * testCellValue 
		 */
		for (int i=0; i<n; i=i+1)
			for (int j=0; j<n; j=j+1)
					testCellValue(map, i, j, assignment, board [i][j]) ;
		
		/*
		 * testMapToBoard
		 */
		testMapToBoard(map, n, assignment, board) ;
	}
	
	public static void testCellValue(int[][][] map, int i, int j, boolean[] assignment, int expectedValue) {
		int value = Task9Decode.cellValue(map, i, j, assignment) ;
		if (value == expectedValue)
			System.out.println("OK! cellValue(" + i + ", "+ j + ") := " + expectedValue);
		else
			throw new IllegalStateException("ERROR! cellValue(" + i + ", "+ j + ") := " + value  + " != " + expectedValue);
	}
	
	public static void testMapToBoard(int[][][] map, int n, boolean[] assignment, int[][] expectedBoard) {
		int [][] board = Task9Decode.mapToBoard(map, n, assignment) ;
		if (Arrays.deepEquals(board,  expectedBoard)) {
			System.out.println("OK! mapToBoard worked as expected: " );
			printBoard(expectedBoard) ;
		}
		else
			throw new IllegalStateException("ERROR! mapToBoard yielded: " + Arrays.deepToString(board)) ;
	}
	
	public static void printBoard(int[][] board) {
		for (int[] row: board)
			System.out.println(Arrays.toString(row)) ;
	}
}
