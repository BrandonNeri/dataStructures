package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 6.11
 *
 * An implementation of a simple LinkedQueue Class. A collection of objects 
 * that are inserted and removed according to the first-in first-out principle.
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    /**
     * 
     * A new queue relies on the list to be an initially empty list
     */
    public LinkedQueue() {
    }

    /**
     * 
     * @return an int giving the number of elements of the queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * 
     * @return a boolean indicating whether the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Inserts an element at the rear of the queue.
     * 
     * @param element to be enqueued
     */
    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    /**
     * 
     * @return returns, but does not remove, the first element of the queue (null if empty)
     */
    @Override
    public E first() {
        return list.first();
    }

    /**
     * 
     * @return removes and returns the first element of the queue (null if empty)
     */
    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
