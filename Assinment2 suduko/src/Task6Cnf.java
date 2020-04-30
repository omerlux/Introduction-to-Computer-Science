//omer luxembourg 205500390 30.11.2017
public class Task6Cnf {
	
	public static int[][] atLeastOne(int[] vars) {
		int [][] CNFmin1=new int[1][vars.length];
		for(int i=0; i<vars.length; i=i+1) //matrix with all true values. 
			CNFmin1[0][i]=vars[i];
		return CNFmin1 ; //tested - for nVars=7 CNFmin1 will bring back [[1, 2, 3, 4, 5, 6, 7]] 
	}

	public static int[][] atMostOne(int[] vars) {
		int n=vars.length;
		int[][]CNFmost1 = new int[n*(n-1)/2][2];
		int count=1;
		int arraynum=0;
		for(int i=1; i<=n;i=i+1){
			for(int j=count; j<=n; j=j+1){
				if(i!=j){
					CNFmost1[arraynum][0]=-vars[i-1];
					CNFmost1[arraynum][1]=-vars[j-1];
					arraynum=arraynum+1;
				}
			}
			count=i+1;
		}
		
		return CNFmost1;
	}
	
	public static int[][] exactlyOne(int[] vars) {
		int[][]CNFonly1=new int [vars.length*(vars.length-1)/2+1][2];
		int[][]CNFmin1=atLeastOne(vars);
		int[][]CNFmost1=atMostOne(vars);
		CNFonly1[0]=new int[CNFmin1[0].length]; //making only the first line to be longer than 2 cells
		for(int j=0; j<CNFmin1[0].length; j=j+1){
			CNFonly1[0][j]=CNFmin1[0][j];
		}
		
		
		for(int i=1; i<=CNFmost1.length; i=i+1){
			CNFonly1[i][0]=CNFmost1[i-1][0];
			CNFonly1[i][1]=CNFmost1[i-1][1];
		}
		return CNFonly1 ;
	}
}
