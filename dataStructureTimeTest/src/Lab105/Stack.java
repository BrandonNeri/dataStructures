package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 6.1
 * 
 * An implementation of a simple Stack Interface. A collection of objects 
 * that are inserted and removed according to the last-in first-out principle.
 * 
 * Although similar in purpose, this interface differs from java.util.Stack.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public interface Stack<E> {

    /**
     *
     * @return number of elements in the stack
     */
    int size();

    /**
     *
     * @return a boolean indicating whether the queue is empty
     */
    boolean isEmpty();

    /**
     * 
     * Inserts an element at the top of the stack.
     *
     * @param e the element to be inserted
     */
    void push(E e);

    /**
     *
     * @return returns, but does not remove, the element at the top of the stack
     */
    E top();

    /**
     *
     * @return removes and returns the top element from the stack
     */
    E pop();
}
