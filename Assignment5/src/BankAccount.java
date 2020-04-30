/*---------------------------------------
 Genuine author: Omer Lux, I.D.: 205500390
 Date: 6-1-2018 
---------------------------------------*/
public class BankAccount {
	
	private String name;
	private int accountNumber;
	private int balance;
	
	public BankAccount(String name, int accountNumber, int balance) {
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException();
		}
		if(accountNumber <= 0){
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public String getName(){
		return name;
	}

	public int getBalance(){
		return balance;
	}

	public int getAccountNumber(){
		return accountNumber;
	}
	
	public String toString(){
		//return "Name: "+name+", AccountNumber: "+accountNumber;
		
		//use the following string to easily test your answers
		return ""+accountNumber;
	}

	//Complete the following method
	public boolean spendOrDepositMoney(int amount){
		if(getBalance()+amount<0)
			return false;
		this.balance=getBalance()+amount;
		return true;
	}
}
