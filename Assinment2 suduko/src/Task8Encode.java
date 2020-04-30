import java.util.Arrays;
//omer luxembourg 205500390 30.11.2017
public class Task8Encode {
	
	public static void encode(int sqrtN, int[][] hints, int[][][] map) {
		int n=sqrtN*sqrtN;
		SATSolver.init(n*n*n);
		//1 num in a cell
		for(int a=0; a<n; a=a+1){
			for(int b=0; b<n; b=b+1){ 
				SATSolver.addClauses(Task6Cnf.exactlyOne(map[a][b])); //only 1 num in a cell
			}
		}
		//rows - separate numbers in a row
		int [][][]rows=new int [n][n][n];
		for(int a=0; a<n; a=a+1){
			rows[a]=TasksArrays.columns(map[a]); //creating map to check the rows, in every array there are all the same number from the row
		}
		for(int a=0; a<n; a=a+1){
			for(int b=0; b<n; b=b+1){
				SATSolver.addClauses(Task6Cnf.exactlyOne(rows[a][b])); //insert to CNF - not the same num in the row.
			}
		}
		//columns - separate numbers in a column
		int [][][]columns=new int [n][n][n];
		for(int a=0;a<n;a=a+1){ //map num of column
			for(int b=0;b<n;b=b+1){ //map num of number in cell
				for(int c=0;c<n;c=c+1){ //map num of row
					columns[a][b][c]=map[c][a][b];
				}
				SATSolver.addClause(columns[a][b]);
			}	
		}	
		//Block
		int[][]blox=new int[n][n];
		for(int i=0;i<n;i=i+1){ //the number in the cell
			for(int j=0; j<n;j=j+1){
				for(int k=0; k<n;k=k+1){
					blox[j][k]=map[j][k][i]; //block of the i num int he cel
				}
			}
			int [][] blockarray = TasksArrays.blocks(blox, sqrtN);
			for(int a=0; a<n;a=a+1){
				SATSolver.addClauses(Task6Cnf.exactlyOne(blockarray[a]));
			}	
		}
		//hints verified trough CNF
		int [] k =new int [1];//it will be the hints clause
		for (int i=0; i<hints.length; i=i+1){
			k[0]=(Task7Map.varName(hints[i][0], hints[i][1], hints[i][2]-1, n));
			SATSolver.addClause(k);
		}
	}
}
