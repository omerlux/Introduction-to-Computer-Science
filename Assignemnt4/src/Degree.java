import java.util.Iterator;

public abstract class Degree {
	// ---------------------- fields ---------- setting the fields
	private String name;
	private int degreeCode;
	private int requiredCredits;
	private List<Course> mandatory;
	private List<Course> choice;
	//----------------------- builders ---------
    public Degree(String name, int degreeCode, int requiredCredits) {
		if (name == null || name.equals("") | degreeCode <=0 | requiredCredits <= 0 | !onlyLettersAndSpaces(name)) //checking for legal arguments
			throw new IllegalArgumentException();
		this.name=name;
		this.degreeCode=degreeCode;
		this.requiredCredits=requiredCredits;
		mandatory =new LinkedList<>();
		choice = new LinkedList<>();
    }
	private boolean onlyLettersAndSpaces(String str) { //checking for a clear name.
		boolean isLetter = true;
		for (int i = 0; i < str.length() & isLetter ; i++) {
			char c = str.charAt(i);
			isLetter = c == ' ' | (c >= 'a' & c <= 'z') | (c >= 'A' & c <= 'Z') | '0' <= c & c <= '9';
		}
		return isLetter;
	}
    public Degree() {
    	

    }
    //----------------------- Methods ------------------
    public String getDegreeName(){
    	return name; 
    }

    public int getDegreeCode(){
    	return degreeCode;
    }

    public List<Course> getMandatoryCourses() {
    	return mandatory;
    }

    public List<Course> getElectiveCourses() {
    	return choice;
    }

    public boolean addCourse(Course course,boolean mandatory){

    	if(course==null)
    		throw new IllegalArgumentException();
    	else if(!mandatory){
    		if(getElectiveCourses().contains(course))
    			return false;
    		getElectiveCourses().add(course); //adding the elective course
    		return true;
    	}
    	else if(getMandatoryCourses()!=null && getMandatoryCourses().contains(course)) //checking if its already included
			return false; //it already included inside
    	else{ //adding mandatory course by credits number
    		int sumCredits=course.getCredit(); //summing the current course
    		Iterator <Course> iterator = course.getAllPreliminaryCourses().iterator(); //iterator for the preliminary courses
    		while(iterator.hasNext()){ //iteration on the list
    			Course Current = iterator.next();
    			if(!getMandatoryCourses().contains(Current)) //a new course!!!
    				sumCredits=sumCredits+Current.getCredit(); //summing the credits
    		}
    		int MandCred=0;
    		for(int i=0; i<this.mandatory.size(); i=i+1){
    			MandCred = getMandatoryCourses().get(i).getCredit()+MandCred;
    		}
    		
    		if(sumCredits+MandCred>requiredCredits)
    			return false; //too much credits - course did not added	
    		//if its not too much, add them!
    		
    		getMandatoryCourses().add(course);
    		iterator = course.getAllPreliminaryCourses().iterator(); //Initialize the iterator again
    		while(iterator.hasNext()){
    			Course Current = iterator.next();
    			if(!getMandatoryCourses().contains(Current)){ // a new course
    				getMandatoryCourses().add(Current);
    			}
    		}
    		return true; //success!
    	}
    }

    public int getRequiredCredits(){
    	return requiredCredits;
    }

    public int getMandatoryCredits(){ //returning only mandatory credits with iterator
    	Iterator <Course> iter = getMandatoryCourses().iterator();
    	int mancredits=0;
    	while(iter.hasNext()){ //summing the list - courses' credits
    		mancredits=mancredits+iter.next().getCredit();
    	}
    	return mancredits;
    }

}
