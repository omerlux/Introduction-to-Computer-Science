
public class IsLegalSolutionSelfTest {
	private static final boolean Q = true;
	private static final boolean f = false;
	private static final String NAME = "isLegalSolution";
	private static int testNum = 1;
	
	public static void runTests() {
		//Test examples:
		//Test #1:
		boolean[][] board1 = {{Q,f,f},
							  {Q,f,Q},
							  {f,f,f}}; //you can add as many square boards as you want.
		int k1 = 3;
		boolean testResult1 = false;
		runTest(board1, k1, testResult1); 
		
		//Test #2:
		boolean[][] board2 = board1;
		int k2 = 3;
		boolean testResult2 = false;
		runTest(board2, k2, testResult2);
		
		//add more tests of your own... make sure that all of your tests pass.
		
	}
	
	private static void runTest(boolean[][] board, int k, boolean testResult) {
		String myResultDescription = "failed.";
		
		boolean myResult = KQueens.isLegalSolution(board, k) == testResult;

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
