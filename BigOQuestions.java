import java.util.LinkedList;
/**
 *  Some practice questions for the COMP210 Midterm.  What is the big O 
 *  running time for the following methods?  
 *  @author Nathan Sprague
 */

public class BigOQuestions<T> {
	/**
	 * O(n) because there is one loop that loops through every element in the list. As the lists size increases, so does the 
	 * 	time complexity for the loop. Therefore the loop is O(n);
	 */
	public boolean BigOWhat1(LinkedList<T> list, T item)
	{
	
		for (int i = 0; i< list.size(); i+= 2) 		// *list.size();
		{
			T cur = list.get(i);  					// +1
			if (cur.equals(item))  					// +1
				return true;						// +1
		}
		
		return false;								// +1
	
	}
	
	/**
	 * O(1) because the time it takes to execute this statement does not depend on anything and will be constant everytime. 
	 */
	public boolean BigOWhat2(LinkedList<T> list1, LinkedList<T> list2)
	{
		return list1.equals(list2);		// +1
	}
	
	
	/**
	 *  O(n) because the for-each statement loops through each element in the list, so the time complexity depends on how many elements are in the list.
	 *  Although there is another loop (the for statement), it isn't nested, which means that our complexity would be O(n+n) or O(2n), but since we eliminate 
	 *		constants, we come out with O(n);
	 */
	public void BigOWhat3(LinkedList<T> list, T item)
	{
	
		boolean found = false; 						// +1
		for (T cur : list) 							// * Number of Elements in List
		{
			if (cur.equals(item))					// +1
				found = true; 						// +1
		}
		
		if (found){ 								// +1
			int numElements = list.size(); 			// +1
			for (int i = 0; i < numElements; i++) 	// *list.size()
			{
				list.add(list.size()/2, item); 		// +1
			}
		}
	
	
	}
}
