import java.util.NoSuchElementException;

/**
 * 
 * A very basic list class.  Elements can only be added at the beginning at
 * the beginning of the list, and can only be removed according to their
 * index.
 * @Author Nathan Sprague
 * @date April 12, 2010
 *
 *@Updated Preston Stosur-Bassett
 *@version October 1, 2014
 *@Course CS210 (Data Structures)
 *@Assignment Lists Mini-Lab
 */
public class List<T> {

	private Node<T> first;
	private int size;
	
	/**
	 * Create an empty list.
	 */
	public List() {
		first = null;
		size = 0;
	}

	/**
	 * Adds a new element AT THE BEGINNING of the list. 
	 * @param element - The element to add
	 */
	public void addElement(T element) 
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

		size++;		//Increase the size reference by 1;
	}
	
	/**
	 * Removes and returns the element at the specified index. Throws
	 * a noSuchElementException if the index is out of bounds.
	 *  
	 * @param index - position of the element to remove
	 * @return the element that was removed
	 * @throws NoSuchElementException
	 */
	public T removeElement(int index) throws NoSuchElementException
	{
		if(size == 0 || index < 0 || index > size) {		//Check to see if the index that was provided is out of bounds
			throw new NoSuchElementException();
		}

		T intermediate = null;		//A variable to store the element of the deleted node in so it can be returned to the user

		if(index == 0) {		//Check to see if the element being removed is the first element
			intermediate = first.getElement();		//Store the element to be returned to the user
			first = first.getNext(); 		//Set a new first element
		}
		else {
			Node<T> current = first; 		//A place holder element to hold the current node while iterating through all the nodes in the list
			Node<T> previous = null; 		//A place holder element to hold the previous node while iterating though all the nodes in the list
			Node<T> next = null;		//A place holder element to hold the next node while iterating through the list

			for(int i = 0; i < index; i++) {
				previous = current;
				current = current.getNext();
				next = current.getNext();
			}

			intermediate = current.getElement();		//Store the element of the node to be returned to the user
			previous.setNext(next); 		//Reorder the list to remove the node that was selected
		}

		size--; 		//Decrease the size of the list by 1
		return intermediate;
	}
	
	/**
	 * Returns the number of elements in the list.
	 */
	public int size()
	{
		return size;
	}
	
}
