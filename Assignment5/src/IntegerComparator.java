/*---------------------------------------
 Genuine author: Omer Lux, I.D.: 205500390
 Date: 6-1-2018 
---------------------------------------*/
import java.util.Comparator;

//This comparator is used for demonstrations in Test classes.
public class IntegerComparator implements Comparator<Integer>{

	public IntegerComparator() {
		super();
	}

	@Override
	public int compare(Integer number1, Integer number2) {

		return number1.compareTo(number2);
	}
}
