package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 6.9
 * 
 * An implementation of a simple Queue Interface. A collection of objects 
 * that are inserted and removed according to the first-in first-out principle.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public interface Queue<E> {

    /**
     * 
     * @return an int giving the size of the queue
     */
    int size();

    /**
     * 
     * @return a boolean indicating whether the queue is empty
     */
    boolean isEmpty();

    /**
     * 
     * Inserts an element at the rear of the queue.
     * 
     * @param e element to be enqueued
     */
    void enqueue(E e);

    /**
     * 
     * @return returns, but does not remove, the first element of the queue (null if empty)
     */
    E first();

    /**
     * 
     * @return removes and returns the first element of the queue (null if empty)
     */
    E dequeue();
}
