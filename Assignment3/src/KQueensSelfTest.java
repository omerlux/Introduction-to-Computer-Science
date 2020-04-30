
public class KQueensSelfTest {
	private static final String NAME = "kQueens";
	private static int testNum = 1;
	
	public static void runTests() {
		//Test examples:
		//Test #1:
		int n1 = 3;
		int k1 = 3;
		boolean testResult1 = true;
		runTest(n1, k1, testResult1);
		
		
		//Test #2:
		int n2 = 3;
		int k2 = 4;
		boolean testResult2 = false;
		runTest(n2, k2, testResult2);
		
		//add more tests of your own... make sure that all of your tests pass.
		//Test examples:
		//Test #3:
		int n3 = 8;
		int k3 = 10;
		boolean testResult3 = true;
		runTest(n3, k3, testResult3);
		
	}

	private static void runTest(int n, int k, boolean testResult) {
		String myResultDescription = "failed.";
		boolean[][] board = KQueens.kQueens(n, k);
		boolean finalResult;

		if(testResult)
			finalResult = KQueens.isLegalSolution(board, k);
		else finalResult = board.length == 0;

		if(finalResult)
			myResultDescription = "passed.";

		System.out.println("Test # "+testNum+" board " +n+" with "+k+" queens :" + testNum + ": " + myResultDescription);
		if(!finalResult) {
			System.out.println("Wrong solution:");
			KQueens.printBoard(board);
		}
		else{KQueens.printBoard(board);}
		testNum = testNum + 1;

	}
	
	public static void main(String[] args) {
		System.out.println("Running " + NAME + " tests:");
		runTests();
	}
}
