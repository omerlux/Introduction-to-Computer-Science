/*---------------------------------------
 Genuine author: Omer Lux, I.D.: 205500390
 Date: 6-1-2018 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {
		//returning x>0 if 1 bigger than 2
		//returning x<0 if 1 is smaller than 2
		//returning x=0 if they are the same
		return account1.getAccountNumber()-account2.getAccountNumber();
	}

}
