/**
 *@Updated Preston Stosur-Bassett
 *@version October 6, 2014
 *@Course CS210 (Data Structures)
 *@Assignment Stacks Mini-Lab
 */
public class Stack<T> {

	private Node<T> first;
	
	/**
	 * Create an empty stack.
	 */
	public Stack() {
		first = null;
	}

	/**
	 * Adds a new element AT THE BEGINNING of the list. 
	 * @param element - The element to add
	 */
	public void push(T element) 
	{
		if(first == null) {		//Check if this is the first element being added to the list. 
			first = new Node<T>(element);		//Create the first node in the list with the element provided
			Node<T> next = null;		
			first.setNext(next);		//Set the first node's next to null
		}
		else { 
			Node<T> next = first;		//Store the current first element to reference later
			first = new Node<T>(element);		//Make the first variable point to the newly added element
			first.setNext(next);		//Set the newly added element's next to the old 'first' element that was stored
		}
	}
	
	/**
	 * Removes and returns the element at the specified index.
	 *  
	 * @return the element that was removed
	 */
	public T pop() 
	{
		T intermediate = null;		//A variable to store the element of the deleted node in so it can be returned to the user

		if(first != null) {
			intermediate = first.getElement();
			first = first.getNext();
		}

		return intermediate;
	}

	/**
	* Returns true if first == null
	* @return boolean true if first == null, false otherwise
	*/
	public boolean isEmpty() {
		if(first == null) {
			return true;
		}

		return false;
	}
}
