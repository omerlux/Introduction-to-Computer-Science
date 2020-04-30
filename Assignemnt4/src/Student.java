import java.util.Iterator;

public class Student implements Comparable<Student>{
	private StudentInfo studentInfo;
	private Degree degree;
	private List<Course> registeredCourses;
	private List<Grade> grades;
	private int currentYear;
	private int finishAt;

	//constructors
	public Student(StudentInfo studentInfo, Degree degree) {
		if (studentInfo == null | degree == null)
			throw new IllegalArgumentException();
		this.studentInfo = studentInfo;
		this.degree = degree;
		this.registeredCourses = new LinkedList<Course>();
		this.grades = new LinkedList<Grade>();
		this.currentYear = 1;
		this.finishAt = 0;	
	}
	
	//methods
	public StudentInfo getStudentInfo(){
		return studentInfo;
	}
	
	public Degree getDegree() {
		return degree;
	}
	
	public int getCurrentYear() {
		return currentYear;
	}
	
	public int getFinishYear() {
		return finishAt; 
	}

	public List<Grade> getGrades() {
		return grades;
	}
	public void increaseYear() { //increasing year by 1!
		currentYear=getCurrentYear()+1;
	}
	
	public void closeDegree(int year) { //current year will be 0, the finished year will be year.
		this.finishAt=year;
		this.currentYear=0;
	}
	
	public boolean isRegisteredTo(Course course){ //checks if course is in registered courses of the student
		boolean registered=false;
		if(this.getRegisteredCourses()!=null && this.getRegisteredCourses().contains(course)) //the list is not null and has course >> registered!
			registered=true;
		return registered;
	}
	
	public boolean isCompleted(Course course, int passGrade){
		boolean completed=false;
		if(this.getGrades()!=null && !this.getGrades().isEmpty()){ //the list is not null and empty
			Iterator <Grade> iterator = getGrades().iterator();
			while(iterator.hasNext() &!completed){ //searching in the grades list
				Grade current = iterator.next();
				if(current.getCourse().equals(course) & current.getGrade()>=passGrade) //the Grade has the same course and enough grade to pass
					completed=true;
			}
		}
		return completed;
	}
	
	public boolean registerTo(Course course){ // true if the course added to registered courses.
		boolean registered = false;
		if(!isRegisteredTo(course)) // checks for a legal list without course
			registered=getRegisteredCourses().add(course);
		return registered;
	}
	
	public double averageGrade() {
		double average=0;
		double CreditsSum=0;
		double gradesSum=0;
		if(getGrades()!=null){
			Iterator <Grade> iterator = getGrades().iterator();
			while(iterator.hasNext()){ //iteration on the Grades list
				Grade current=iterator.next();
				CreditsSum=CreditsSum	+current.getCourse().getCredit(); //summing up the credits
				gradesSum=gradesSum		+current.getGrade()*current.getCourse().getCredit(); //summing up the grades* credits
			}
			average=gradesSum/CreditsSum;
		}
		return average;
	}

	public boolean addGrade(Course course, int grade) { //adding a grade of course and removing it from registered list
		boolean added=false;
		if (grade<0 | grade>100) //grade is not legal
			throw new IllegalArgumentException();
		else if(getRegisteredCourses()!=null && getRegisteredCourses().contains(course)){ //the course is in the list of registered
			Grade newCourse = new Grade (course,grade); 
			grades.add(newCourse); //added the new course to the grades list
			registeredCourses.remove(course); //removing the finished course
			added=true; //been added
		}
		return added;
	}
	
	public int setGrade(Course course, int grade) { //returning old grade and updating a new one
		int oldgrade=-1;
		if (grade<0 | grade>100 | getGrades()==null) //grade is not legal or Grades is null
			throw new IllegalArgumentException();
		else{
			Iterator <Grade> iterator = getGrades().iterator();
			while(iterator.hasNext() & oldgrade==-1){ //iteration on the Grades list
				Grade current=iterator.next();
				if(current.getCourse().compareTo(course)==0){ //checkes for the same course
					oldgrade=current.getGrade(); //saving the old grade
					current.setGrade(grade); //setting the new grade
				}
			}
		}
		if(oldgrade==-1)//no such course - didnt updated the grade
			throw new IllegalArgumentException();
		return oldgrade; //returning oldgrade if its different from -1 == updated.
	}
	
	public String toString() {
		return null;
	}
	
	public boolean equals(Object other) {
		return other instanceof Student && studentInfo.getIdentityNumber() == ((Student) other).studentInfo.getIdentityNumber();
	}

	public List<Course> getRegisteredCourses() {
		return registeredCourses;
	}

	public Grade getCourseGrade(Course c)
	{
		Iterator <Grade> iterator = getGrades().iterator();
		while(iterator.hasNext()){ //iteration on the Grades list
			Grade current=iterator.next();
			if(current.getCourse().compareTo(c)==0) //checks for the same course
				return current; //returning the Grade element with the course 'c'
		}
		return null; //did not found the course c >> null
	}

	@Override
	public int compareTo(Student o) { // this next to o by grades / id
		double compared = this.averageGrade()- o.averageGrade(); //positive if this > o
		if(compared==0) //same grade!
			compared= this.getStudentInfo().getIdentityNumber()-o.getStudentInfo().getIdentityNumber(); //positive if this>o
		if(compared>0)
			return 1;
		if(compared<0)
			return -1;
		return 0; //they are the same!
	}
}
