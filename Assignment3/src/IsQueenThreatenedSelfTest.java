
public class IsQueenThreatenedSelfTest {
	private static final boolean Q = true;
	private static final boolean f = false;
	private static final String NAME = "isQueenThreatened";
	private static int testNum = 1;
	
	public static void runTests() {
		//Test examples:
		//Test #1:
		boolean[][] board1 =   {{Q,f,f},
						    	{Q,f,Q},
								{f,f,f}}; //you can add as many square boards as you want.
		int row1 = 0;
		int col1 = 0;
		boolean testResult1 = false;
		runTest(board1, row1, col1, testResult1);
		
		
		//Test #2:
		boolean[][] board2 = board1;
		int row2 = 1;
		int col2 = 0;
		boolean testResult2 = true;
		runTest(board2, row2, col2, testResult2);
		
		//add more tests of your own... make sure that all of your tests pass.
		

	}
		
	private static void runTest(boolean[][] board, int row, int col, boolean testResult) {
		String myResultDescription = "failed.";
		boolean myResult = KQueens.isQueenThreatened(board, row, col) == testResult;

		if(myResult)
			myResultDescription = "passed.";

		System.out.println("Test #" + testNum + ": " + myResultDescription);
		testNum = testNum + 1;
	}
	
	public static void main(String[] args) {
		System.out.println("Running " + NAME + " tests:");
		runTests();
	}
}
