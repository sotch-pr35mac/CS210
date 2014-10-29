/** The KQueue interface specifies the methods for a <i>queue</i>
 *  data structure.
 *  <ul>
 *    <li>The enqueue method adds an element to the "back" of the
 *        data structure.
 *    <li>The dequeue method acts as follows:
 *        <ul>
 *        <li>If the queue is empty, an exception is thrown.
 *        <li>If the queue contains one element, dequeue returns that element,
 *          leaving the queue empty.
 *        <li>If the queue contains multiple elements, dequeue returns the
 *          element at the "front" of the queue, the one that has been there
 *          longest.
 *        </ul>
 *  </ul>
 **/

public interface KQueue<T>
{
    /** Returns <code>true</code> if this queue is empty;
     *  <code>false</code> otherwise.
     **/
    boolean isEmpty();

    /** Adds a specified object to the "back" of this queue.
     *    @param item - the object to add to the queue
     **/
    void enqueue(T item);

    /** Removes the element at the "front" of this queue.
     *    @returns the removed element
     *    @throws NoSuchElementException if the queue is empty
     **/
    T dequeue();

    /** Returns the element at the "front" of this queue, without
     *  modifying the queue.
     *    @returns the element at the front of the queue
     *    @throws NoSuchElementException if the queue is empty
     **/
    T peekFront();
 
}
