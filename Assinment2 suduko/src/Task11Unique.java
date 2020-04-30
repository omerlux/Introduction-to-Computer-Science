import java.util.Arrays;
//omer luxembourg 205500390 30.11.2017
public class Task11Unique {
	
	public static int[][] solveUnique(int sqrtN, int[][] hints) {
		int n=sqrtN*sqrtN;
		Task8Encode.encode(sqrtN, hints, Task7Map.varsMap(n)); //setting SAT
		int[][]board=Task10Solve.solve(sqrtN, hints); //getting answer for sodoku
		int[]noSameSol=new int [n*n]; //nVars arrays for SAT
		for(int i=0; i<n; i=i+1){ //injecting solutions to CNF formula
			for(int j=0; j<n; j=j+1){
				int Sol = Task7Map.varName(i,j,board[i][j]-1,n); //all board solutions to map coordinates
				noSameSol[i*n+j]=-Sol;
			}
		}
		System.out.println(Arrays.toString(noSameSol)); //CHECK
		//setting SAT again
		SATSolver.init(n*n*n);
		Task8Encode.encode(sqrtN, hints, Task7Map.varsMap(n)); //setting SAT	
		SATSolver.addClause(noSameSol); //injecting to SATSolver the current solution.
		boolean[] assignment=SATSolver.getSolution(); //make the SAT run
		if(assignment.length==n*n*n+1){ //if assignment is empty - THERE IS ONLY 1 SOLUTION
			board=null; //returning null if there are more than 1 solutions
		}
		return board ;
	}
}
