//omer luxembourg 205500390 30.11.2017
public class Task9Decode {
	
	public static int cellValue(int[][][] map, int i, int j, boolean[] assignment) {
		int num=0;
		boolean NOTfound=true;
		for(int a=0; a<map.length & NOTfound; a=a+1){ //searching for a TRUE value of a number in a cell
			if(assignment[map[i][j][a]]){
				NOTfound=false;
				num=a+1; //num is from 0 so we need to add 1
			}				
		}
		if(NOTfound) //the cell is empty
			throw new IllegalArgumentException("There is no given nubmer for cell number: ["+i+"]["+j+"]");
		return num;
	}
	
	public static int[][] mapToBoard(int[][][] map, int n, boolean[] assignment) {
		int [][] compBoard = new int [n][n];
		for (int i=0; i<n; i=i+1){
			for(int j=0; j<n; j=j+1){
				compBoard[i][j]=cellValue(map,i,j,assignment);
			}
		}
		return compBoard ;
	}
}
