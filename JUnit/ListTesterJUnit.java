import org.junit.*;
import static.org.junit.Assert.*;
import java.util.NoSuchElementException;

/**
* JUnit tests for the List class implementation
* @author Preston Stosur-Bassett
* @Course CS210
**/

public class ListTesterJUnit {
	//no instance variables yet...

	/**
	* This would be the place to include code that should
	* be run before each of the tests... For example
	* setting up instance variables.
	*/
	@Before
	public void setUp()  {

	}

	/**
	* Make sure that size is correctly initialized
	*/
	@Test
	public void testSize() {
		List<String> stringList = new List<String>();
		assertEquals("Initial size of list is not 0. ", 0, stringList.size());
	}

	/**
	* Test to see if exception is thrown when an attempt is made
	* to remove an item after the end of the list.
	*/
	@Test(expected= NoSuchElementException.class)
	public void testRemoveFromEmpty() {
		List<String> stringList = new List<String>();
		String cur = stringList.removeElement(30);
	}
}
