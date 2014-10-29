import java.util.NoSuchElementException;


/**
 * This is a driver class for testing a simple List implementation
 * 
 * @author Nathan Sprague
 * @version April 12, 2010
 */
public class ListTester {

	/**
	 * Runs a series of tests.
	 */
	public static void main(String[] args) {

		//ListTester.testSize();
		//ListTester.testAddRemove();
		ListTester.testRemoveFromEmpty();
		ListTester.testRemoveNegativeIndex();
		ListTester.testRemoveTooLargeIndex();
				
	}
	
	
	/**
	 * A helper function that creates a list containing all of the letters in the
	 * alphabet.  Letters are added to the beginning of the list, starting with A.
	 * Items should end up in reverse alphabetical order
	 * 
	 * @return list of letters
	 */
	public static List<String> buildTestList()
	{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		List<String> stringList = new List<String>();

		for (int i = 0; i< alphabet.length(); i++)
		{
			stringList.addElement(alphabet.substring(i, i+1));
		}
		return stringList;

	}

	
	/**
	 * Run tests to see if size() is calculated correctly by the List class.
	 */
	public void testSize() {
		List<String> stringList = new List<String>();
		System.out.println("Initial size of list should be 0, it is: " + stringList.size());

		stringList = buildTestList();
		
		System.out.println("Size of the list after all elements are added should be 26, it is: " + stringList.size());
		stringList.removeElement(0);
		System.out.println("Size after removing first element should be 25, it is: " + stringList.size());
		stringList.removeElement(stringList.size()-1);
		System.out.println("Size after removing last element should be 24, it is: " + stringList.size());
	}
	
	/**
	 * Run tests to see if items are added and removed correctly by the List class
	 */
	public void testAddRemove()
	{
		
		List<String> stringList = buildTestList();
		
		String cur = stringList.removeElement(0);
		System.out.println("First element should be Z, it is: " + cur);
		
		cur = stringList.removeElement(0);
		System.out.println("New first element should be Y, it is: " + cur);

		
		cur = stringList.removeElement(stringList.size()-1);
		System.out.println("Last element should be A, it is: " + cur);
		
		cur = stringList.removeElement(stringList.size()-1);
		System.out.println("New last element should be B, it is: " + cur);
	}
	
	/**
	 * Test to see if the appropriate exception is thrown if there is an 
	 * attempt to remove an item from an empty list.
	 */
	public static void testRemoveFromEmpty()
	{
		List<String> stringList = new List<String>();
		System.out.println("Removing element from an empty list should cause an exception: ");

		try {
			String cur = stringList.removeElement(30);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("   Caught: " + e);
		}					
		
	}
	
	/**
	 * Test to see if the appropriate exception is thrown if there is an 
	 * attempt to remove an item at a negative index.
	 */
	public static void testRemoveNegativeIndex()
	{
		List<String> stringList = buildTestList();
		System.out.println("Removing element at negative index should cause an exception: ");

		try {
			String cur = stringList.removeElement(-1);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("   Caught: " + e);
		}					
		
	}
	
	/**
	 * Test to see if the appropriate exception is thrown if there is an 
	 * attempt to remove an item at an index beyond the end of the list.
	 */
	public static void testRemoveTooLargeIndex()
	{
		List<String> stringList = buildTestList();
		System.out.println("Removing element at index 30 should cause an exception: ");

		try {
			String cur = stringList.removeElement(30);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("   Caught: " + e);
		}					
		
	}
	
}	


