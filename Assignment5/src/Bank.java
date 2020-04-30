import java.util.Comparator;
import java.util.Iterator;

/*---------------------------------------
 Genuine author: Omer Lux, I.D.: 205500390
 Date: 7-1-2018 
---------------------------------------*/
public class Bank {

	private BankAccountBinarySearchTree namesTree;
	private BankAccountBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	public void balance(){
		namesTree.balance();
		accountNumbersTree.balance();
	}
	
	public Object exportNames() {
		return this.namesTree;
	}
	public Object exportAccountNumbers() {
		return this.accountNumbersTree;
	}
	
	// END OF Given code -----------------------------------
	
	//Complete the following method
	public boolean add(BankAccount newAccount) {
		if (namesTree.contains(newAccount) | accountNumbersTree.contains(newAccount))
			return false;
		namesTree.insert(newAccount);	accountNumbersTree.insert(newAccount);
		return true;
	}

	//Complete the following method
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		if(toRemove==null)
			return false;
		else{
			namesTree.remove(toRemove);		accountNumbersTree.remove(toRemove); //delete from the 2 trees
			return true;
		}	
	}
	
	//Complete the following method
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		if(toRemove==null)
			return false;
		else{
			accountNumbersTree.remove(toRemove);	namesTree.remove(toRemove); //delete from the 2 trees
			return true;
		}	
	}
	
	//Complete the following method
	public boolean spendOrDepositMoney(int amount, int accountNumber){
		BankAccount update = lookUp(accountNumber);
		if(update==null)
			return false;
		else{
			return update.spendOrDepositMoney(amount); // true if it was successeful
		}
	}
}
