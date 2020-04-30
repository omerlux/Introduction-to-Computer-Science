
import java.util.Arrays;

public class ExamplesTask7Map {
	
	public static void main(String[] args) {
		testVarsMap () ;
		testVarNameIndex (100);
	}
	
	public static void testVarsMap () {
		int [][][] map = {{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
		  		  		  {{17, 18, 19, 20}, {21, 22, 23, 24}, {25, 26, 27, 28}, {29, 30, 31, 32}}, 
		  		  		  {{33, 34, 35, 36}, {37, 38, 39, 40}, {41, 42, 43, 44}, {45, 46, 47, 48}}, 
		  		  		  {{49, 50, 51, 52}, {53, 54, 55, 56}, {57, 58, 59, 60}, {61, 62, 63, 64}}} ;

		int[][][] varsMap = Task7Map.varsMap(4) ;

		if (Arrays.deepEquals(map, varsMap))
			System.out.println("Ok! varsMap(4) verified!");
		else
			throw new IllegalStateException("ERROR! varsMap(4) doesn't match: " + Arrays.deepToString(map)) ;
	}
	
	public static void testVarNameIndex (int n) {
		for (int i=0; i<n; ++i)
			for (int j=0; j<n; ++j)
				for (int k=0; k<n; ++k)
					if (!Arrays.equals(new int[] {i, j, k}, Task7Map.nameToIndex(Task7Map.varName(i,j,k,n), n)))
						throw new IllegalStateException("{" + i + ", " + j + ", " + k + "} != " + 
								"nameToIndex(varName(" + i + ", " + j + ", " + k + ", " + n + ")") ;
		System.out.println("OK! testVarNameIndex passed with n=" + n);
	}

}
