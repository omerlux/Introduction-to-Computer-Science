import java.security.acl.LastOwnerException;

/*---------------------------------------
 Genuine author: Omer Luxembourg, I.D.: 205500390
 Date: 1-12-2017
---------------------------------------*/

/* Administrative information of a student */
public class StudentInfo {
	// ---------------------- fields ---------- setting the fields
	private String firstName; 
	private String familyName; 
	private int identityNumber; 
	private String address; 
	private int maxCredit; //max credits till degree
	private int earned; //earned credits since the beginning 
	// ---------------------- constructors ----	
    public StudentInfo(String firstName, String familyName, int identityNumber, int maxCredit) {
    	if(familyName==null | firstName==null | maxCredit<1 | identityNumber<1)
    		throw new IllegalArgumentException("Invalid student info! Some of the fields are wrong.");
    	StringCheck(familyName); //checking familyName validation
    	StringCheck(firstName); //checking firstName validation
    	this.firstName=firstName;
    	this.familyName=familyName;
    	this.identityNumber=identityNumber;
    	this.maxCredit=maxCredit;
    	earned=0; //earned is 0 because it will be null if not.
    }
    private void StringCheck(String S){ //function to check the Strings validation ('A' / 'a' / ' ')
    	if(S==null | S=="")
    		throw new IllegalArgumentException (S+" is invalid!");
    	for(int i=0; i<S.length(); i=i+1){ //checking for S chars validation
    		if(!((S.charAt(i)==(' ') | (S.charAt(i)<='Z' & S.charAt(i)>='A') | (S.charAt(i)<='z' & S.charAt(i)>='a')))){
    			throw new IllegalArgumentException (S+" is invalid!");
    		}
    	}
    }
    // ---------------------- Methods ---------
    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getIdentityNumber() {
        return identityNumber;
    }

    public int getRequiredCredits() {
        return maxCredit-earned;
    }
   
    public void addCredit(int credit) {
        if(credit<0) //credit must be positive or 0
        	throw new IllegalArgumentException ("Credit is invalid!");
        earned=getCredit()+credit; //using the getCredity() function and adding to it

    }

    public int getCredit() {
        return earned;
    }

    public void setAddress(String address){ //Setting address, if its not ('a' / 'A' / ' ') >> exception
    	StringCheck(address);
    	this.address=address;
    }

    public String getAddress(){
    	String tmp=address; //I used tmp string to change it to empty if the address is null
    	if(address==null)
    		tmp="";
    	return tmp;          
    }
	
	public String toString(){ //will return: "Omer Lux 12345680 address. 0/160 Credits.
		return ("Student info: "+getFirstName()+" "+getFamilyName()+" "+getIdentityNumber()+
				" "+getAddress()+". "+getCredit()+"/"+maxCredit+" Credits.");
	}
	
	public boolean isEqualTo(StudentInfo other){
		return (this.getIdentityNumber()==other.getIdentityNumber()); //checking for the same ID
	}

}
