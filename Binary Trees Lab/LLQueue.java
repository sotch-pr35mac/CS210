/**
*	<code>LLQueue</code> is a class that will implament a queue using <code>LinkedList</code> and <code>KQueue</code> Interface
*	@author Preston Stosur-Bassett
* 	@date October 8th 2014
* 	@assignment Queues Mini-Lab One
*	@course CS210 (Data Structures)
*/

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LLQueue<T> implements KQueue<T> {

	private int size;
	private LinkedList<T> queue;

	public LLQueue() {
		queue = new LinkedList<T>();
		size = 0;
	}

	public LLQueue(T item) {
		queue = new LinkedList<T>();
		size = 0;

		enqueue(item);
	}
	
	/**
	*	@return boolean returns true if empty, false otherwise
	*/
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}

		return false;
	}

	/**
	*	<code>enqueue</code> will take an item of type <code>T</code> and add it to the end of the list.
	*	@param T item element to be added to the end of the list
	*/
	public void enqueue(T item) {
		queue.addLast(item);
		size++;
	}

	/**
	*	<code>dequeue</code> will remove an element from the front of the list and return it
	*	@return T element from the front of the list
	*	@throws NoSuchElementException if the queue is empty
	*/
	public T dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T firstElement = queue.removeFirst();
		size--;
		return firstElement;
	}

	/**
	*	<code>peekFront</code> will return the first element from the queue without removing it.
	*	@return T first element from the queue
	*	@throw NoSuchElementException if the queue is empty
	*/
	public T peekFront() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		T firstElement = queue.getFirst();
		return firstElement;
	}

	/**
	*	<code>toString</code> will return a string showing the current state of the queue
	*	@return String current state of the queue
	*/
	public String toString() {
		if(isEmpty()) {
			String emptyQueue = "The queue is empty.";
			return emptyQueue;
		}

		String currentState = new String();
		for(int i = 0; i < size; i++) {
			T currentElement = queue.get(i);
			String currentElementString = currentElement.toString();
			currentState = currentState + currentElementString + ", ";
		}

		return currentState;
	}
}