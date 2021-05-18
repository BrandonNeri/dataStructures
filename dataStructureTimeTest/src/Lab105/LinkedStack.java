package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * Code Fragment 6.4
 * 
 * An implementation of a simple LinkedStack Class. A collection of objects 
 * that are inserted and removed according to the last-in first-out 
 * principle using a generic type of array. This class uses the
 * SinglyLinkedList.java class to create a linked list data structure.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty linked list

    /**
     * 
     * A new stack relies on the list to be an initially empty list
     */
    public LinkedStack() { 
    }            

    /**
     * 
     * @return an int of number of elements in the stack
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * 
     * @return a boolean indicating whether the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Stores a new item to the top of the Linked Stack.
     * 
     * @param element new item to be added to top of the stack
     */
    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    /**
     * 
     * @return the top element of the stack, without removing it
     */
    @Override
    public E top() {
        return list.first();
    }

    /**
     * 
     * @return removes and returns the top element from the stack
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }
}
