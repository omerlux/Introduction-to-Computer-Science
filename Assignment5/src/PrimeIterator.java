/*---------------------------------------
 Genuine author: Omer Lux, I.D.: 205500390
 Date: 6-1-2018 
---------------------------------------*/
import java.util.Iterator;
import java.lang.Math;
public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;
   
	//Complete the following method
    public PrimeIterator(){
    	primes=new LinkedList<>();
    	this.primes.add(2);
    }

	//Complete the following method
    public boolean hasNext(){
        // always will be true because numbers are infinite
    	return true;
    }

	//Complete the following method
    public Integer next(){
    	int prime=nextPrime(primes.get(0));
    	primes.add(0, prime);
        return primes.get(1); 
    }
	private Integer nextPrime(Integer x){ //recursive function to check primes
		x=x+1;
		boolean isPrime=true;
		for(int i=2; i<x & isPrime; i=i+1)
			if(x%i==0)
				isPrime=false;
		if(isPrime)
			return x;	
		else
			return nextPrime(x);
	}
	
	//DO NOT REMOVE OR CHANGE THIS MEHTOD – IT IS REQUIRED 
	public void remove() {
		return;
	}


}
