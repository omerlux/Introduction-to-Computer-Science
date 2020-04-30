/*---------------------------------------
 Genuine author: Omer Lux, I.D.: 205500390
 Date: 7-1-2018 
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	//Complete the following method
	public void balance(){
		BankAccountBinarySearchTree tree = new BankAccountBinarySearchTree(this.getComparator());
		LinkedList<BankAccount> list = new LinkedList<>(); //list of bank accounts
		Iterator <BankAccount> iter = this.iterator(); //iterator of bank accounts in the tree
	//	if(!this.isEmpty()){ //while the tree is not empty
			while(iter.hasNext()){ //making the list
				BankAccount curr=iter.next();
				list.add(curr);
			}
			int low=0;
			int high=list.size()-1;
			buildBalancedTree(tree, list, low, high);
			this.root=tree.root; //this tree has a new root >> tree
	//	}
	}
	//divide by 2 everytime
	//Complete the following method
	private void buildBalancedTree(BankAccountBinarySearchTree tree, List<BankAccount> list, int low, int high){
		tree.insert(list.get((high+low)/2)); //middle of the list
		if(high>low){
			buildBalancedTree(tree, list, low, ((high+low)/2)-1);
			buildBalancedTree(tree, list, ((high+low)/2)+1, high);
		}
	}
}
