/*---------------------------------------
 Genuine author: Omer Luxembourg, I.D.: 205500390
 Date: 2-12-2017
---------------------------------------*/

public class Student {
	// ---------------------- fields ---------- setting the fields
	private StudentInfo Student;
	private int GradesSum=0; //sum of grades
	private int Counter=0; //number of grades inserted
	// ---------------------- constructors ----	
    public Student(String firstName, String familyName, int identityNumber) {
        this.Student = new StudentInfo (firstName, familyName, identityNumber, 120);
    }
    // ---------------------- Methods ---------
    public StudentInfo getStudentInfo(){
    	return Student;
    }

    public void addCourseGrade(Course course, int grade) {
    	if(grade>55) //if the student passed the test, the credits will update for him
    		Student.addCredit(course.getCredits());
    	this.Counter=Counter+course.getCredits(); 		//adding the grade to a sum and adding counter
    	this.GradesSum=GradesSum+grade*course.getCredits();
    }

    public double averageGrade() {
        return (double)GradesSum/Counter;
    }
	
	public String toString(){ // The student Omer Lux has average of 56.0
		return "The student "+Student.getFirstName()+" "+Student.getFamilyName()+" has average of "+averageGrade();
	}
	
	public boolean isEqualTo(Student other){
		return this.Student.isEqualTo(other.getStudentInfo());
	}

}
