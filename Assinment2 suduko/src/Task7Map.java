import java.util.Arrays;
//omer luxembourg 205500390 30.11.2017
public class Task7Map {
	
	public static int varName(int i, int j, int k, int n) {
		int whereamI=n*n*i+n*j+k+1; //calculating by the formula the place of the specific option
		return whereamI ; 
	}
	
	public static int[] nameToIndex(int x, int n) {
		int[] triplet = new int[3]; //x=n*n*i+n*j+k+1
		int k;
		if((x-1)%n!=0){ //if no modulu, there is k that is not 0
			k=(x-1)%n; //calculate it and update X with it+1.
			x=x-k-1;
		}
		else{
			k=0; //if modulu is 0, x will be calculated without 0+1
			x=x-1;
		}
		int j=(x%(n*n))/n; //finding j and i by the formula
		int i=x/(n*n);
		triplet[0]=i;triplet[1]=j;triplet[2]=k;
		return triplet;		
	}
	
	public static int[][][] varsMap(int n) {
		int [][][] varsMap = new int [n][n][n];
		for(int i=0; i<n; i=i+1){
			for(int j=0; j<n; j=j+1){
				for(int k=0; k<n; k=k+1){
					varsMap[i][j][k]=n*n*i+n*j+k+1;
				}
			}
		}
		return varsMap;
	}
}
