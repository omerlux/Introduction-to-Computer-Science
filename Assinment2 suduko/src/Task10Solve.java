import java.util.Arrays;
//omer luxembourg 205500390 30.11.2017
public class Task10Solve {
	
	public static int[][] solve(int sqrtN, int[][] hints) {
		int n=sqrtN*sqrtN;
		SATSolver.init(n*n*n); //initial the SATSolver
		int[][][]map=Task7Map.varsMap(n); //creating a map
		Task8Encode.encode(sqrtN, hints, map); //encoding to sat
		boolean[] assignment=SATSolver.getSolution(); //make the SAT run
		int[][]board =null;
		
		if (assignment.length == n*n*n+1){ //if its SAT
			board=Task9Decode.mapToBoard(map, n, assignment); //making the board
			boolean valid=Task5Verify.isSolution(sqrtN, hints, board); //checking for validation of the board
			if(!valid )
				throw new IllegalArgumentException("Board isn't valid.");	
		}
		else if(assignment==null){
			throw new IllegalArgumentException("Timeout!");
		}
		//if its not in the length of n+1 / null = UNSAT & board will be null			
		return board ;
	}
	public static void main (String[]args){
		int [][] hints = {{2,4,1},{1,0,7},{2,5,8},{4,5,6}};
		int [][] solved = solve(3,hints);
		System.out.println(Arrays.deepToString(solved));
	}
}

