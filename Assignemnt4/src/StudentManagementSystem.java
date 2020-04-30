import java.io.LineNumberReader;
import java.util.Iterator;

public class StudentManagementSystem {
	private List <Student> Students;
	private	List <Degree> Degrees;
	private List <Course> Courses;
	private int failTreshold;

	public StudentManagementSystem(int failTreshold) { //Initialize
		this.failTreshold=failTreshold;
		Students = new LinkedList <>();
		Degrees = new LinkedList<>();
		Courses = new LinkedList<>();
	}

	public boolean addStudent(Student student){
		boolean CanAdd=true;
		boolean legalDegree=true;
		if(Students!=null & Degrees!=null){ //lists are not null
			Iterator<Student> iter1 = Students.iterator();
			while(CanAdd & iter1.hasNext()){
				if(iter1.next().equals(student))
					CanAdd=false; //the student exists
			}
			if(!Degrees.contains(student.getDegree())) //checks for degree in the list
				legalDegree=false;	
		}
		if(CanAdd & legalDegree) //add
			Students.add(student);
		return CanAdd & legalDegree; //true if been CanAdd
	}

	public boolean addCourse(Course course){
		Iterator<Course> iter = course.getAllPreliminaryCourses().iterator(); //iterator on the list of preliminary
		if(Courses.contains(course) ){
			return false;
		}
		while(iter.hasNext()){
			Course current = iter.next();
			if(!Courses.contains(current)) // not contains that pre course
				return false;; //not added the current preliminary course
		}
		Courses.add(course);
		return true;
	}

	public boolean addDegree(Degree degree) {
		if (!Degrees.contains(degree)){ //there is no such degree - lets add it
			if(Courses.containsAll(degree.getMandatoryCourses())
					& Courses.containsAll(degree.getElectiveCourses())){ //checkes for a valid courses
				Degrees.add(degree);
				return true; //course has been added
			}
		}
		return false; //course exists
	}

	public List<Course> getMissingPreCourses(Course course, int studentId){
		List <Course> preCourses = course.getAllPreliminaryCourses(); //making list of all the pre courses
		//preCourses is already sorted from Course class
		Student current = getStudentClass(studentId);
		Iterator <Course> iter = preCourses.iterator();
		while (iter.hasNext()){
			Course curRegCourse = iter.next();
			if(current.isCompleted(curRegCourse, failTreshold)) //completed course - delte it
				preCourses.remove(curRegCourse);
		}
		return preCourses;
	}
	
	public boolean register(int studentId, Course course){ //adding the course to the list of the student
		//input not null
		Student current = getStudentClass(studentId);
		Degree StudentDegree = current.getDegree();
		if(current==null | !Courses.contains(course)) // no such student or course
			return false;
		else if(!(StudentDegree.getMandatoryCourses().contains(course)) 
				& !(StudentDegree.getElectiveCourses().contains(course))) //checks for a real course in his degree - BY NEGATIVE
			return false;
		else if(current.isCompleted(course, failTreshold)) // student passed the course already
			return false;
		for(Course courseiter: course.getAllPreliminaryCourses())
			if(!current.isCompleted(courseiter, failTreshold))
				return false;
	 //so now the grade is lower, so well add the course to the student
		return current.registerTo(course); // in this while every condition is alright >> adding the course
	}

	public boolean addGrade(Course course, int studentId, int grade){
		Student stud = getStudentClass(studentId); //student = null >> no student in List
		if(stud==null | course==null || grade>100 | grade <0 | !Courses.contains(course) ||
				!stud.isRegisteredTo(course)/* || stud.getCourseGrade(course).getGrade()>=failTreshold*/){
			//no such student - no such course - not registered to course - grade isnt valid
			return false;
		}
		else if(stud.getCourseGrade(course)!=null && stud.getCourseGrade(course).getGrade()>=failTreshold)
			return false;
		else{
			return stud.addGrade(course, grade); //everything is fine go and add the course grade
		}
	}
	private Student getStudentClass(int studentId){ //function to get the student parameter from ID
		for(Student student: Students){
			if(student.getStudentInfo().getIdentityNumber()==studentId)
				return student;
		}
		return null;
	}
	
	public List<Student> closeCourse(Course course, List<Pair<Integer, Integer>> grades) //will return all failures of the course
	{
		List<Student> failures = new LinkedList <>();
		Iterator <Pair<Integer, Integer>> iter = grades.iterator();
		while(iter.hasNext()){
			Pair<Integer, Integer> current = iter.next();
			getStudentClass(current.getFirst()).addGrade(course, current.getSecond()); //updating grade for the student
			if((Integer)current.getSecond() < failTreshold){ //comparing between grade and failTreshold...
				failures.add(getStudentClass((Integer)current.getFirst())); //adding the student to list - by his ID
			}
		}
		return failures;
	}
	
	public boolean closeDegree(int studentId, int year){ //trying to close the degree by 3 rules..
		Student stud = getStudentClass(studentId);
		int sumOfMandatory = 0;
		for(Course course: stud.getDegree().getMandatoryCourses()){
			sumOfMandatory = sumOfMandatory+course.getCredit();
			if(!stud.isCompleted(course, failTreshold)) //did not passed a mandatory course
				return false;
		}
		if(stud.getDegree().getRequiredCredits() - sumOfMandatory > 0){ //not enough to finish the degree! 
			int sumOfElective=0;
			for(Course elective: stud.getDegree().getElectiveCourses()){
				if(stud.isCompleted(elective,0))
					sumOfElective=sumOfElective+elective.getCredit();
			}
			if(stud.getDegree().getRequiredCredits() - sumOfMandatory - sumOfElective >0) //still not enough!!
				return false;
		}	
		for(Course course: stud.getDegree().getMandatoryCourses()){
			if(stud.getRegisteredCourses().contains(course)) //there are more registered courses that need to be done
				return false;
		}
		stud.closeDegree(year);
		return true; //nothing is interfering
	}
	
	public List<Student> getFirstKStudents(Degree degree, int year, int k) //returning first k students
	{
		List<Student> firstK = new LinkedList<>();
		if(degree==null | year<1 | k<1)
			throw new IllegalArgumentException(); //exceptions for null degree and none sense parameters
		Iterator <Student> iter = Students.iterator();
		while (iter.hasNext() & k>0){
			Student stud = iter.next(); 
			if(stud.getDegree().equals(degree) & stud.getFinishYear()==year){ //finished stud with the same degree
				firstK.add(stud);
				k=k-1; //k-1 students to go
			}
		}
		Sorter.bSort(firstK); //sorting by compare to
		return firstK;
	}

	public List<Student> getFailStudents(Course course) //returning all failures in that course
	{
		List<Student> failures = new LinkedList<>();
		Iterator<Student> iter=Students.iterator();
		while(iter.hasNext()){
			Student stud = iter.next();
			if(stud.getCourseGrade(course).getGrade()<failTreshold) // if they had lower than fail Treshold so add them to the list of failures
				failures.add(stud);
		}
		Sorter.bSort(failures); //sort
		return failures;
	}

	public List<Student> getRegisteredStudents(Course course) //returning all students registered to that course
	{
		List<Student> registered = new LinkedList<>();
		Iterator<Student> iter=Students.iterator();
		while(iter.hasNext()){
			Student stud = iter.next();
			if(stud.getRegisteredCourses().contains(course)) // checking for the course in the student info
				registered.add(stud);
		}
		Sorter.bSort(registered); //sort
		return registered;
	}

	public List<Course> nextAvailableCourses(int studentId) //list of courses the student can take in his degree (by pre courses)
	{
		Student stud = getStudentClass(studentId);
		List<Course> DoneCourses = new LinkedList<>(); // a list of all finished courses
		for(Grade iterG: stud.getGrades()){
			if(iterG.getGrade()>=failTreshold)
				DoneCourses.add(iterG.getCourse()); //adding all passed courses of the student
		}
		List<Course> available = new LinkedList<>();
		for(Course DegreeCourse: Courses){
			if(!DoneCourses.contains(DegreeCourse) & !stud.getDegree().getElectiveCourses().contains(DegreeCourse)){ //The course hasnt done yet and not elective
				if(DegreeCourse.getAllPreliminaryCourses().isEmpty())
					available.add(DegreeCourse);
				else{ //checking for DegreeCourse preliminary in Done Courses
					boolean canBeadded=true;
					for(Course pre: DoneCourses){
						if(!DegreeCourse.getAllPreliminaryCourses().contains(pre)) //pre isnt included in the finished courses - he cant take it
							canBeadded=false;
					}
					if(canBeadded)
						available.add(DegreeCourse);
				}
			}
		}
		System.out.println(available);
		Sort(available); //sort function in this class
		return available;
	}
	
	private void Sort (List<Course> newlist){ // function to clear duplicates and sort the list
		if(newlist.size()<2) //for only 2 and more courses in a list
			return;
		for(int i=1; i<newlist.size(); i=i+1)
			insert(newlist, i);
	}
	private void insert(List<Course> newlist, int i){
		if(newlist.get(i).compareTo(newlist.get(i-1))<0){ //i course in the next place bigger than i-1
			Course toRemove=newlist.get(i); //temp course saver
			newlist.remove(toRemove);
			while(newlist.contains(toRemove)){ //removing all duplicated courses
				newlist.remove(toRemove);
			}		
			Iterator <Course> seek= newlist.iterator(); //creating iterator seek
			int addhere=0;
			while(seek.next().compareTo(toRemove)<0){ //seeking for the right place to insertion
				addhere=addhere+1;
			}
			newlist.add(addhere,toRemove); //adding the removed course in the new place.
		}
	}
	

	public List<Course> getMissingCourses(int studentId)
	{
		Student stud = getStudentClass(studentId);
		List <Grade> finished = stud.getGrades(); 
		List <Course> all = stud.getDegree().getMandatoryCourses(); //all mandatory courses
		Iterator <Grade> iterG = finished.iterator();
		while(iterG.hasNext()){
			Grade grade = iterG.next();
			if(all.contains(grade.getCourse())) //checking for duplicates
				all.remove(grade.getCourse()); //deleting it
		}
		return all;
	}

	public List<Student> getStudents() {
		return Students;
	}

	public List<Course> getCourses() {
		return Courses;
	}

	public List<Degree> getDegrees() {
		return Degrees;
	}

	public int getFailTreshold() {
		return failTreshold;
	}
}
