
import java.util.Arrays;

public class ExamplesTask5Verify {
	
	public static void main(String[] args) {
		example1 () ;
		example2 () ;
	}
	
	public static void example1() {
		int[][] hints1 = {{0,0,2}, {1,2,1}, {2,1,2}, {3,3,4}} ;
		int[][] board1 = {{2, 1, 4, 3},
						  {3, 4, 1, 2},
						  {4, 2, 3, 1},
						  {1, 3, 2, 4}} ;
		
		if (Task5Verify.isSolution(2, hints1, board1))
			System.out.println("OK! " + Arrays.deepToString(board1) + 
								" is a solution to (2, " + Arrays.deepToString(hints1) + ")");
		else
			throw new IllegalStateException("ERROR! " + Arrays.deepToString(board1) + 
					" should be a solution to instance (2, " + Arrays.deepToString(hints1) + ")") ;

		boolean caught = false ;
		try {
			Task5Verify.isSolution(3, hints1, board1) ;
		} catch (RuntimeException e) {
			caught = true ;
		}
		
		if (caught)
			System.out.println("OK! isSolution(2, " + Arrays.deepToString(hints1) + 
					", " + Arrays.deepToString(board1) + ") threw exception") ;
		else
			throw new IllegalStateException("ERROR! " + Arrays.deepToString(board1) + 
					" should throw exception for instance (3, " + Arrays.deepToString(hints1) + ")");
	}
	
	public static void example2 () {
		int[][] hints2 = {{0,0,2}, {1,2,1}, {2,1,2} } ;
		int[][] board2 = {{2, 1, 1, 3},
						  {3, 4, 1, 2},
						  {4, 3, 2, 1},
						  {1, 3, 2, 1}} ;
		
		if (!Task5Verify.isSolution(2, hints2 , board2 ))
			System.out.println("OK! " + Arrays.deepToString(board2) + 
					" not a solution to (2, " + Arrays.deepToString(hints2) + ")");
		else
			throw new IllegalStateException("ERROR! " + Arrays.deepToString(board2) + 
					" shouldn't be a solution to instance (2, " + Arrays.deepToString(hints2) + ")") ;
	}

}
