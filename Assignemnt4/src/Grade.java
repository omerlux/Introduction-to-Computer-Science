public class Grade {
	private Course course;
	private int grade; //0-100
    public Grade(Course course, int grade) {
		if (course == null || grade <0 | grade >100) //checking for legal arguments
			throw new IllegalArgumentException();
		this.course=course;
		this.grade=grade;
    }

    public Course getCourse() {
    	return course;
    }

    public int getGrade() {
    	return grade;
    }

    public int setGrade(int grade) { // returning current grade, and updating
    	if(grade <0 | grade >100) //illegal grade
    		throw new IllegalArgumentException();
    	int tmp=this.grade;
    	this.grade=grade;
    	return tmp;
    }
    
    public String toString() { //returning String of "In course CS the grade is: 56"
    	return "In course "+getCourse()+" the grade is: "+getGrade();
    }

    public boolean equals(Object other){ //true if other is a 'Grade' and equals this parameter
    	boolean isEqual = false;
    	if((other instanceof Grade) && this.getCourse().equals(((Grade)other).getCourse()) 
    			& this.getGrade()==((Grade)other).getGrade())//other is 'Grade', other has the same course, other has the same grade
    		isEqual = true;;
    	return isEqual;
    }
}
