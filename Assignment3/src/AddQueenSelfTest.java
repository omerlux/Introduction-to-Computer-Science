import java.util.Arrays;

public class AddQueenSelfTest {
	private static final boolean Q = true;
	private static final boolean f = false;
	private static final String NAME = "addQueen";
	private static int testNum = 1;

	public static void runTests() {
		//Test examples:
		//Test #1:
		boolean[][] board1 = {{Q,Q,f},
							  {f,f,f},
							  {f,f,f}}; //you can add as many square boards as you want.

		int row1 = 1;
		int col1 = 1;
		int numOfQueens1 = 2;
		boolean testResult1 = false;
		runTest(board1, row1, col1, numOfQueens1, testResult1);

		//Test #2:
		boolean[][] board2 = {{Q,f,f},
							  {f,f,f},
							  {f,f,f}};
		int row2 = 0;
		int col2 = 1;
		int numOfQueens2 = 1;
		boolean testResult2 = true;
		runTest(board2, row2, col2, numOfQueens2, testResult2);

		//add more tests of your own... make sure that all of your tests pass.
		
		
	}

	private static void runTest(boolean[][] board, int row, int col, int numOfQueens, boolean testResult) {
		boolean[][] originalBoard = duplicateBoard(board); //we need to clone the board because this task changes it.
		boolean[][] testedBoard = duplicateBoard(board); //we need to clone the board because this task changes it.

		String myResultDescription = "failed.";

		boolean myAddQueenResult = KQueens.addQueen(testedBoard, row, col, numOfQueens);

		boolean isBoradOK;
		if(!myAddQueenResult) { //can't add a queen on to the board
			isBoradOK = compareBoards(originalBoard, testedBoard); //the board should be unchanged.
		} else {
			originalBoard[row][col] = Q;
			isBoradOK = compareBoards(originalBoard, testedBoard);
		}

		boolean finalResult = isBoradOK & (myAddQueenResult == testResult);	

		if(finalResult)
			myResultDescription = "passed.";

		System.out.println("Test #" + testNum + ": " + myResultDescription);
		testNum = testNum + 1;
	}

	private static boolean[][] duplicateBoard(boolean[][] board) {
		boolean[][] ans = new boolean[board.length][0];

		for(int i = 0; i < board.length; i = i + 1)
			ans[i] = Arrays.copyOf(board[i], board[i].length);

		return ans;
	}

	private static boolean compareBoards(boolean[][] originalBoard, boolean[][] testedBoard) {
		for(int i = 0; i < originalBoard.length; i = i + 1)
			for(int j = 0; j < originalBoard[i].length; j = j + 1)
				if(originalBoard[i][j] != testedBoard[i][j])
					return false;

		return true;
	}

	public static void main(String[] args) {
		System.out.println("Running " + NAME + " tests:");
		runTests();
	}
}
