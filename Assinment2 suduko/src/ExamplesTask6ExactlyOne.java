
public class ExamplesTask6ExactlyOne {
	
	public static void main(String[] args) {
		exactlyOneExample1() ;
		exactlyOneExample2() ;
	}
	
	public static void exactlyOneExample1() {
		int nVars = 7 ;
		SATSolver.init(nVars);
		
		int[] vars1 = {1,2} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars1));
		
		int[] vars2 = {-1, 3} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars2));
		
		int[] vars3 = {2, 3} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars3));
		
		int[] vars4 = {3, 5, 6} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars4));
		
		int[] vars5 = {5, 6, -7} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars5));
		
		boolean[] assignment = SATSolver.getSolution() ;
		if (assignment == null)
			System.out.println("time limit exceeded") ;
		else if (assignment.length == 0)
			System.out.println("can't assign exactly one");
		else {
			System.out.println("exactly one assignment:");
			printAssignment(assignment) ;
		}	

		/*
		 * possible output:
		 * -----------------
		 * 
		 * exactly one assignment:
		 * x_1 = false
		 * x_2 = true
		 * x_3 = false
		 * x_4 = false
		 * x_5 = true
		 * x_6 = false
		 * x_7 = true
		 */
	}
	
	public static void exactlyOneExample2() {
		int nVars = 7 ;
		SATSolver.init(nVars);
		
		int[] vars1 = {1, 2} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars1));
		
		int[] vars2 = {-1, 3} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars2));
		
		int[] vars3 = {2, -3} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars3));
		
		int[] vars4 = {3, 5, 6} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars4));
		
		int[] vars5 = {5, 6, -7} ;
		SATSolver.addClauses(Task6Cnf.exactlyOne(vars5));
		
		boolean[] assignment = SATSolver.getSolution() ;
		if (assignment == null)
			System.out.println("time limit exceeded") ;
		else if (assignment.length == 0)
			System.out.println("can't assign exactly one");
		else {
			System.out.println("exactly one assignment:");
			printAssignment(assignment) ;
		}
		
		/*
		 * output:
		 * --------
		 * 
		 * can't assign exactly one
		 */
	}
	
	public static void printAssignment (boolean[] assignment) {
		for (int i=1; i<assignment.length; i=i+1)
			System.out.println("x_" + i + " = " + assignment [i]);
	}

}
