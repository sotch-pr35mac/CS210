/**
*	<code>TestDriver</code> will test the LLQueue class and make sure that it functions properly.
* 	@author Preston Stosur-Bassett
*	@date October 8th 2014
*	@assignment KQueue Mini-Lab
*	@course CS210 (Data Structures)
*/

public class TestDriver {
	public static void main(String[] args) {
		//Create a new LLQueue
		KQueue testQueue = new LLQueue<String>();

		//Add three strings to the queue
		String first = "First";
		String second = "Second";
		String third = "Third";
		testQueue.enqueue(first);
		testQueue.enqueue(second);
		testQueue.enqueue(third);
		System.out.println(" ");

		//Report to the user what the current state of the queue is.
		System.out.println("The contents of this queue should be first, second, and third, respectively.");
		System.out.println("The contents of this queue are: ");
		System.out.print(testQueue.toString());
		System.out.println(" ");

		//Dequeue an element from the queue
		Object dequeuedElement = testQueue.dequeue();

		//Report to the user what the dequed element is, and what it should be.
		System.out.println("The dequeued element should be "+first);
		System.out.println("The actual dequeued element: "+dequeuedElement.toString());
		System.out.println(" ");

		//Remove all remaining items from the queue
		System.out.println("Removing the remaining elements from the queue...");
		System.out.println("Removing: ");
		while(!testQueue.isEmpty()) {
			dequeuedElement = testQueue.dequeue();
			System.out.print("-"+dequeuedElement.toString());
			System.out.println(" ");
		}

		//Then add new items to the queue
		String fourth  = "Fourth";
		String fifth = "Fifth";
		String sixth = "Sixth";
		testQueue.enqueue(fourth);
		testQueue.enqueue(fifth);
		testQueue.enqueue(sixth);
		System.out.println(" ");

		//Verify and report to the user the current state of the queue
		System.out.println("The contents of this queue should be: Fourth, Fifth, Sixth.");
		System.out.println("The actual contents of this queue are: ");
		System.out.print(testQueue.toString());
		System.out.println(" ");
	}
}