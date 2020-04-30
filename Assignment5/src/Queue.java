/*---------------------------------------
 Genuine author: Omer Lux, I.D.: 205500390
 Date: 6-1-2018  
---------------------------------------*/
public interface Queue <T>{
	
	//Returns true iff this queue is empty.
	public boolean isEmpty();
	
	//Removes the object at the front of this queue and returns that object.
	public T dequeue();
	
	//Insert an item into the back of this queue.
	public void enqueue(T element);


}
