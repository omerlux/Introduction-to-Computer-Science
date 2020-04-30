
public class Task1SelfTest {
	public static void main(String[] args) {
		successfulTest1();
		wrongTest1();
		wrongTest2();
		
		// add more tests....
		// try to check the correctness of your program
	}
	
	public static void successfulTest1() {
		//this is the way of how we handle exceptions
		try { //We try to do something that might fail....
			
			//no exceptions should be thrown here
			Student s = new Student("John", "Smith", 11111);
			Course c1 = new Course("someCourse1" ,1234, 2);
			Course c2 = new Course("someCourse2" ,1111, 3);
			s.addCourseGrade(c1, 100);
			s.addCourseGrade(c2, 90);
			System.out.println(s.averageGrade()); // prints 94.0
			StudentInfo studentInfo = s.getStudentInfo();
			System.out.println(studentInfo.getCredit()); //prints 5 
			System.out.println(studentInfo.getRequiredCredits()); //prints 115
			System.out.println(s.isEqualTo(s)); //return true
		} catch(IllegalArgumentException e) { //and here we are catching the exception that has been thrown
			System.out.println("Exception message: " + e.getMessage());
		}
	}
	
	public static void wrongTest1() {
		//this is the way of how we handle exceptions
		try { //We try to do something that might fail....
			Student s = new Student("John", "Smith", -11111); //throws exception
			Course c1 = new Course("someCourse1" ,1234, 2);
			Course c2 = new Course("someCourse2" ,1111, 3);
			s.addCourseGrade(c1, 100);
			s.addCourseGrade(c2, 90);
			System.out.println(s.averageGrade());
			StudentInfo studentInfo = s.getStudentInfo();
			System.out.println(studentInfo.getCredit());
			System.out.println(studentInfo.getRequiredCredits());
		} catch(IllegalArgumentException e) { //and here we are catching the exception that has been thrown
			System.out.println("Exception message: " + e.getMessage());
		}
	}
	
	public static void wrongTest2() {
		//this is the way of how we handle exceptions
		try { //We try to do something that might fail....
			Student s = new Student("John", "Smith", 11111);
			Course c1 = new Course("someCourse1 % " ,1234, 2); //throws exception
			Course c2 = new Course("someCourse2" ,1111, 3);
			s.addCourseGrade(c1, 100);
			s.addCourseGrade(c2, 90);
			System.out.println(s.averageGrade());
			StudentInfo studentInfo = s.getStudentInfo();
			System.out.println(studentInfo.getCredit());
			System.out.println(studentInfo.getRequiredCredits());
		} catch(IllegalArgumentException e) { //and here we are catching the exception that has been thrown
			System.out.println("Exception message: " + e.getMessage());
		}
	}
}
