/*---------------------------------------
 Genuine author: Omer Luxembourg, I.D.: 205500390
 Date: 8-12-2017
---------------------------------------*/
public class KQueens {

	/**
	 * Prints a given boolean board. true = "Q" and false = "*"
	 * 
	 * @param board
	 *            A boolean board. true value represents a queen placed on the
	 *            board.
	 */
	public static void printBoard(boolean[][] board) { //Printing the board Q = true ; * =false
		if(board.length==0) //checking if there is a solution = board is empty
			System.out.println("There is no solution");
		else{
			for(int i=0; i<board.length; i=i+1){
				for(int j=0; j<board[i].length; j=j+1){
					if(board[i][j]) //checking for true value
						System.out.print("Q ");
					else
						System.out.print("* ");
				}
				System.out.println(); //new line
			}
			}
		}

	/**
	 * Checks if a queen placed on board in cell board[row][col] is threatened by
	 * more than one queen
	 * 
	 * @param board
	 *            a square boolean board
	 * @param row
	 *            the row index of the queen
	 * @param col
	 *            the column index of the queen
	 * @return true if a queen placed on board in cell board[row][col] is threatened
	 *         by more than one queen
	 */
	public static boolean isQueenThreatened(boolean[][] board, int row, int col) {
		int SumThrts=0;
		boolean search=true;
		for(int i=row; i<board.length & i>=0 & search; i=i+1){ // DOWN
			if(board[i][col] & i!=row){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
		}
		search=true;
		for(int j=col; j<board.length & j>=0 & search; j=j+1){ //RIGHT
			if(board[row][j] & j!=col){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
		}
		search=true;
		for(int i=row; i<board.length & i>=0 & search; i=i-1){ // UP
			if(board[i][col] & i!=row){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
		}
		search=true;
		for(int j=col; j<board.length & j>=0 & search; j=j-1){ //LEFT
			if(board[row][j] & j!=col){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
		}
		
		search=true;
		int i=row; int j=col;
		while(search & i<board.length & i>=0 & j<board.length & j>=0)	//DOWN RIGHT
		{
			if(board[i][j] & j!=col & i!=row){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
			i=i+1; j=j+1;
		}
		
		search=true;
		i=row; j=col;
		while(search & i<board.length & i>=0 & j<board.length & j>=0)	//UP LEFT
		{
			if(board[i][j] & j!=col & i!=row){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
			i=i-1; j=j-1;
		}
		
		search=true;
		i=row; j=col;
		while(search & i<board.length & i>=0 & j<board.length & j>=0)	//DOWN LEFT
		{
			if(board[i][j] & j!=col & i!=row){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
			i=i+1; j=j-1;
		}
		
		search=true;
		i=row; j=col;
		while(search & i<board.length & i>=0 & j<board.length & j>=0)	//UP RIGHT
		{
			if(board[i][j] & j!=col & i!=row){
				SumThrts=SumThrts+1;
				search=false; //for break
			}
			i=i-1; j=j+1;
		}
		
		if(SumThrts>=2) //more than 1 Q is threatening our Q
			return true;
		else
			return false;
	}

	/**
	 * Checks that there are k queens on the board, and that no queen is threatened
	 * by more than one queen
	 * 
	 * @param board
	 *            a boolean board with a solution to the KQueens problem
	 * @param k
	 *            the number of queens that should be on the board
	 * @return true iff the solution is legal
	 */
	public static boolean isLegalSolution(boolean[][] board, int k) { //checking if the board is a legal solution (with the last function of ThreatenedQ
		boolean LegalSol=true;
		for(int i=0; i<board.length & k>=0 & LegalSol; i=i+1){
			for(int j=0; j<board.length & k>=0 & LegalSol; j=j+1){
				if(board[i][j]){
					LegalSol=!isQueenThreatened(board, i, j); //checking for Q that is not threatened - FALSE if its threatened
					k=k-1; //checking for board legal number of Qs
				}		
			}		
		} //if LegalSol = false from checking threatened Q more than 2
		if(k!=0)
			LegalSol=false; //too many / not enough Q
		return LegalSol; // Change or remove according to your needs
	}

	/**
	 * Adds a queen to board[row][col] only if the board obtained after adding the
	 * queen is legal
	 * 
	 * @param board
	 *            a boolean board representing a legal solution for numOfQueens
	 *            queens
	 * @param row
	 *            The row index in which an attempt is made to add a new queen.
	 * @param col
	 *            The column index in which an attempt is made to add a new queen.
	 * @param numOfQueens
	 *            number of queens placed on board
	 * @return true iff queen was added to the board
	 */
	public static boolean addQueen(boolean[][] board, int row, int col, int numOfQueens) {
		boolean added=false;
		if(!board[row][col]){ //cell without Q
			board[row][col]=true; //add a Q
			if(isLegalSolution(board, numOfQueens+1))
				added= true; //if the solution is legal TRUE for added
			else
				board[row][col]=false; //back to normal
		}
		return added; // Change or remove according to your needs
	}

	/**
	 * Solves the k queens problem, for a board of size nxn Placed k queens on board
	 * such that each queen is threatened by no more than one queen Calls recursive
	 * function with the same name
	 * 
	 * @param n
	 *            the size of the board
	 * @param k
	 *            number of queens to be placed on board
	 * @return a boolean array of size nxn that represents a legal solution to the
	 *         problem, an empty array otherwise
	 */
	public static boolean[][] kQueens(int n, int k) { //nXn with k Q's GO!
		boolean[][]board=new boolean [n][n]; //creating a board
		boolean found=kQueens(board, k, 0, 0, 0);
		if(!found)
			board=new boolean[][] {}; //returning empty
		return board; // Change or remove according to your needs
	}

	/**
	 * A recursive function that tries all possible combinations for placing queens
	 * Goes over board row by row from left to right
	 * 
	 * @param board
	 *            a partial solution for numOfQueens
	 * @param row
	 *            current row
	 * @param col
	 *            current column
	 * @param k
	 *            total number of queens to place
	 * @param numOfQueens
	 *            how many queens were placed so far on board
	 * @return true iff a legal solution was found. board will represent a solution
	 *         only if true is returned
	 */
	private static boolean kQueens(boolean[][] board, int k, int row, int col, int numOfQueens) {
		boolean valid=false;
		if(isLegalSolution(board, k)) //finished board !
			valid=true;
		else if(row>=board.length | col>=board.length) //out of the board
			valid=false;
		//add a queen to a new board, and continue. if somehow its not a solution, don't save this solution to board. go to the next col or go to a new line
		else if((addQueen(board, row, col, numOfQueens) && 
				(kQueens(board, k, row, col+1, numOfQueens+1) || kQueens(board, k, row+1, 0, numOfQueens+1)))){
			valid=true;
		}
		else{
			board[row][col]=false;
			valid=kQueens(board, k, row, col+1, numOfQueens) || kQueens(board, k, row+1, 0, numOfQueens);
		}
		return valid;
	}

}
