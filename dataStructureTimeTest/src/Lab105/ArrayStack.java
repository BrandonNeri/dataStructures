package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 6.2
 * 
 * An implementation of a simple ArrayStack Class. A collection of objects 
 * that are inserted and removed according to the last-in first-out 
 * principle using a generic type of array.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;  // default array capacity
    private E[] data;                         // generic array used for storage
    private int t = -1;                       // index of the top element in stack

    /**
     * 
     * Constructs a stack with default capacity
     */
    public ArrayStack() {
        this(CAPACITY);
    }

    /**
     * 
     * Constructs a stack with given capacity.
     * 
     * @param capacity a designated size for the stack array
     */
    public ArrayStack(int capacity) {
        // safe cast; compiler may give warning
        data = (E[]) new Object[capacity];
    }

    /**
     * 
     * @return an int of number of elements in the stack
     */
    @Override
    public int size() { 
        return (t + 1); // t starts at -1 so add 1 to get size
    }

    /**
     * 
     * @return a boolean indicating whether the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return (t == -1); // -1 is empty value
    }

    /**
     * Stores a new item to the top of the Array Stack.
     * 
     * @param e new item to be added to top of the stack
     * @throws IllegalStateException 
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e; // increment t before storing new item
    }

    /**
     * 
     * @return the top element of the stack, without removing it
     */
    @Override
    public E top() {
        if (isEmpty()) { 
            return null; // returns null if no items are in array
        }
        return data[t]; // returns first item in array
    }

    /**
     * 
     * @return removes and returns the top element from the stack
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null; // returns null if no items are in array
        }
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer;
    }
}
