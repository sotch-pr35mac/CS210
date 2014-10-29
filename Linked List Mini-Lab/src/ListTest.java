import org.junit.*;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

/**
 * JUnit tests for the List class implementation
 *
 */
public class ListTest {
	/**
	 * This would be the place to include code that should
	 * be run before each of the tests... For example
	 * setting up instance variables. 
	 */
	@Before 
	public void setUp() { 
		
     }

	
	/**
	 * Make sure that size is correctly initialized
	 */
	@Test
	public static void testSize() {
		List<Integer> intList = new List<Integer>();	//Create a new List of Integers
		assertEquals("Initial size of list is not 0. ", 0, intList.size()); 

		//Populate the List of Integers with Integer Objects from 1 to 26.
		for(int i = 1; i <= 26; i++) {
			Integer valueToAdd = new Integer(i);
			intList.addElement(valueToAdd);
		}

		//Check to see if the size of the list is 26 right out of the box.
		Integer valueToCheck = new Integer(26);
		Integer valueFromList = new Integer(intList.size());
		assertEquals("The size of the list should be 26.", valueToCheck, valueFromList);

		//When an element is removed front the front of the list, check to confirm that the list size shrinks to 25.
		intList.removeElement(0);
		valueToCheck = new Integer(25);
		valueFromList = new Integer(intList.size());
		assertEquals("The size of the list should be 25.", valueToCheck, valueFromList);

		//Remove an element from the end of the list, check to confirm that the list size shrinks to 24.
		int indexToRemove = (intList.size() - 1);
		intList.removeElement(indexToRemove);
		valueToCheck = new Integer(24);
		valueFromList = new Integer(intList.size());
		assertEquals("The size of the list should be 24.", valueToCheck, valueFromList);
	}
	
	/**
	 * Make sure that the addition and removal of element to the list works
	 */
	@Test
	public static void testAddAndRemove() {
		//Set up new list, add elements 1 to 26.
		List<Integer> intList = new List<Integer>();
		for(int i = 1; i <= 26; i++) {
			Integer valueToAdd = new Integer(i);
			intList.addElement(valueToAdd);
		}

		Integer valueToCheck;

		//Check to make sure that the first element on the list is 26.
		Integer firstListElement = new Integer(intList.removeElement(0));
		valueToCheck = new Integer(26);
		assertEquals("The first element should be 26.", valueToCheck, firstListElement);

		//Check to make sure that the first element on the list after removing 26, is 25.
		Integer afterFirstRemove = new Integer(intList.removeElement(0));
		valueToCheck = new Integer(25);
		assertEquals("The first element should be 25.", valueToCheck, afterFirstRemove);

		//Check to confirm that the last element on the list is 1.
		int indexToRemove = (intList.size() - 1);
		Integer lastListElement = new Integer(intList.removeElement(indexToRemove));
		valueToCheck = new Integer(1);
		assertEquals("The last element should be 1.", valueToCheck, lastListElement);

		//Check to confirm that after removing 1 from the list, the last element is 2.
		indexToRemove = (intList.size() - 1);
		Integer afterLastRemove = new Integer(intList.removeElement(indexToRemove));
		valueToCheck = new Integer(2);
		assertEquals("The new last element should be 2.", valueToCheck, afterLastRemove);
	}
	
	/**
	 * Test to see if exception is thrown when an attempt is made
	 * to remove an item after the end of the list. 
	 */
	@Test(expected= NoSuchElementException.class)
	public void testRemoveFromEmpty()
	{
		List<String> stringList = new List<String>();	//Create an empty List of Strings

		//Try and remove element at index 30 from empty List of Strings
			//Should throw a NoSuchElementException
		String cur = stringList.removeElement(30);
	}

	/**
	*	Test to see if exception is thrown when an attempt is made to remove an item with a negative index value;
	*/
	@Test(expected = NoSuchElementException.class)
	public void testRemoveFromNegative() {
		List<Integer> intList = new List<Integer>(); //Create a List of Integer Objects
		//Populate that list with Integer objects from 1 to 26.
		for(int i = 1; i <= 26; i++) {
			Integer valueToAdd = new Integer(i);
			intList.addElement(valueToAdd);
		}

		//Try and remove from list at index -3
			//Should throw a NoSuchElementException
		Integer currentValue = intList.removeElement(-3);
	}

	/**
	*	Test to see if exception is thrown when an attempt is made to remove an element with an index that is way out of bounds
	*/
	@Test(expected = NoSuchElementException.class)
	public void testRemoveFromTooLargeIndex() {
		List<Integer> intList = new List<Integer>();	//Create a List of Integer Objects
		//Populate that List with Integer Objects from 1 to 26.
		for(int i = 1; i <= 26; i++) {
			Integer valueToAdd = new Integer(i);
			intList.addElement(valueToAdd);
		}

		//Try and remove index value of 100 when list index only goes up to 25.
			//Should throw a NoSuchElementException
		Integer currentValue = intList.removeElement(100);
	}
}		