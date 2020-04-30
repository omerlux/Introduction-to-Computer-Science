/*---------------------------------------
 Genuine author: Omer Luxembourg, I.D.: 205500390
 Date: 1-12-2017
---------------------------------------*/

public class Course {
	// ---------------------- fields ---------- setting the fields
	private String name; 
	private int number;
	private int credits;
	// ---------------------- constructors ----	
    public Course(String name, int number, int credits){
    	if(name==null | name.length()==0 |credits<=0 | number<=0) //check for name!=null or empty credits and number are a number greater than 0
    		throw new IllegalArgumentException ("Course info is invalid!");
    	for(int i=0; i<name.length(); i=i+1){ //checking for name chars validation
    		if(!((name.charAt(i)==(' ') | (name.charAt(i)<='9' & name.charAt(i)>='0') | 
    				(name.charAt(i)<='Z' & name.charAt(i)>='A') | (name.charAt(i)<='z' & name.charAt(i)>='a'))))
    			throw new IllegalArgumentException ("Course name is invalid!");
    	}
    	this.name=name;
    	this.number=number;
    	this.credits=credits;
    }
    // ---------------------- Methods ---------
    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getNumber() {
        return number;
    }
	
	public String toString(){ //will return: 'The course: CS ~ 1234 = 5 Credits'
		return ("The course: "+name+" ~ "+number+" = "+credits+" Credits.");
	}
	
	public boolean isEqualTo(Course other){
		return number==other.number;
	}

}
