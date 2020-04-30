//omer luxembourg 205500390 30.11.2017
public class Task5Verify {

	public static boolean isSolution(int sqrtN, int[][] hints, int[][] board) {
		//check that board is sqrtN x sqrtN and has sqrtN nums in every row and column
		boolean valid=true; // if valid is false - exception - board is illeagal
		boolean filledOK=true; //if filledOK is false - FALSE - board is not filled as demand
		if(board.length!=sqrtN*sqrtN) //checks for a matching row length
			valid=false;
		for(int i=0; i<board.length & valid; i=i+1){
			if(board[i].length!=sqrtN*sqrtN) // checks for a normal board size
				valid=false;
			for(int j=0; valid & j<board[i].length; j=j+1){
				if(board[i][j]<1 | board[i][j]>sqrtN*sqrtN) // the numbers are between 1~sqrtN^2 (a)
					valid=false;
				for(int n=0; valid & n<board.length; n=n+1){
					for(int m=0; valid & m<board[n].length; m=m+1){	
						if(m!=j & n!=i & board[i][j]==board[i][m] & board[i][j]==board[n][j]){ //checks for columns and rows distinct  (b)(c)
							filledOK=false;
						}
					}	
				}
				for(int blockR=((i/sqrtN)*sqrtN); blockR<(i/sqrtN+sqrtN) & valid; blockR=blockR+1){ //checks that in every block there is only 1 kind of a number (d)
					for(int blockC=((j/sqrtN)*sqrtN); blockC<(j/sqrtN+sqrtN) & valid; blockC=blockC+1){
						if(i!=blockR & j!=blockC){
							if(board[i][j]==board[blockR][blockC])
								filledOK=false;
						}
					}
				}			
				for(int k=0; valid & k<hints.length;k=k+1){ //checks on the hints matrix for the same value at the same indexs (e)
					if(hints[k][0]==i & hints[k][1]==j) //is the hints [k] array points the indexs as the board is now checking?
					{
						if(hints[k][2]!=board[i][j]) //hints are alright? if not valid is false
							filledOK=false;
					}
				}
			}	
		}
		if(!valid)
			throw new IllegalArgumentException("Board not valid.");
		return filledOK;
	}

}
