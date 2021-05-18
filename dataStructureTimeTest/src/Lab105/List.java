package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 7.1
 * 
 * An implementation of a simple List Interface. This interface is a 
 * simplified version of the java.util.List interface.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public interface List<E> {

    /**
     * 
     * @return an int of the number of elements in the list
     */
    int size();

    /**
     * 
     * @return a boolean indicating whether the list is empty
     */
    boolean isEmpty();

    /**
     * 
     * @param i index position of a requested element
     * @return returns (but does not remove) the element at index i
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * 
     * @param i index position of a given element
     * @param e element to replace the current one at index i
     * @return replaces the element at index i with e, and returns the replaced element
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Inserts element e to be at index i, shifting all subsequent elements later.
     * 
     * @param i index position of a given element
     * @param e element to be added at index position i
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * 
     * @param i index position of a given element
     * @return removes/returns the element at index i, shifting subsequent elements earlier
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
