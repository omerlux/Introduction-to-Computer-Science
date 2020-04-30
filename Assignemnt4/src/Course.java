import java.util.Iterator;
public class Course implements Comparable<Course>{

	private String name;
	private int number;
	private int credit;
	private List<Course> preCourses;

	public Course (String name, int credits) {}

	public Course(String name, int number, int credit) {
		if (name == null || name.equals("") | number <=0 | credit <= 0 | credit > 6| !onlyLettersAndSpaces(name))
			throw new IllegalArgumentException();

		this.name = name;
		this.number = number;
		this.credit = credit;
		this.preCourses = new LinkedList<Course>();
	}

	public String getName()
	{
		return name;
	}

	public int getNumber()
	{
		return number;
	}

	public int getCredit()
	{
		return credit;
	}

	public String toString(){
		return "Course: name - " + name + ", number - " + number + ", credit - " + credit + ".";
	}

	public boolean equals(Object other){
		return other instanceof Course && ((Course) other).number == this.number;}


	public List<Course> getPreliminaryCourses()	{
		return preCourses;
	}

	public List<Course> getAllPreliminaryCourses(){
		List <Course> Preliminary = new LinkedList<>();
		Iterator<Course> iterator = this.getPreliminaryCourses().iterator();
		while(iterator.hasNext())
		{
			Course PrevC = iterator.next(); // this is the pre course
			Preliminary.addAll(PrevC.getAllPreliminaryCourses()); //adding all the pre course of the pre course
			Preliminary.add(PrevC); //adding the pre course himself
		}
		Sort(Preliminary); //sort and earsing duplicates function
		Sorter.bSort(Preliminary);
		return Preliminary;
	}


	public void addPreliminaryCourse(Course course){
		this.getPreliminaryCourses().add(course);
	}

	public void addPreliminaryCourses(List<Course> courses){
		this.getPreliminaryCourses().addAll(courses);
	}

	public boolean isPreliminaryCourse(Course other){	
		return other.getAllPreliminaryCourses().contains(this); //checks for list contain this course
	}
		
	private void Sort (List<Course> newlist){ // function to clear duplicates and sort the list
		for(int i=0; i<newlist.size(); i=i+1){
			Course toRemove = newlist.get(0);
			Iterator <Course> iter = newlist.iterator();
			while(iter.hasNext()){
				Course current = iter.next();
				if(current.compareTo(toRemove)==0) //deleting all courses like toRemove
					newlist.remove(current);
			}
			newlist.add(toRemove); // adding it again
		}
	}


	@Override
	public int compareTo(Course other) {
		int x;
		if(isPreliminaryCourse(other)) //other is primary to this course
			x=1;
		else if (other.isPreliminaryCourse(this)) //this course is primary to other
			x=-1;
		else 
			x=this.getNumber()-other.getNumber();	//they are not primary of any of them
		return x;
	}

	private boolean onlyLettersAndSpaces(String str) {
		boolean isLetter = true;
		for (int i = 0; i < str.length() & isLetter ; i++) {
			char c = str.charAt(i);
			isLetter = c == ' ' | (c >= 'a' & c <= 'z') | (c >= 'A' & c <= 'Z') | '0' <= c & c <= '9';
		}
		return isLetter;
	}
}
