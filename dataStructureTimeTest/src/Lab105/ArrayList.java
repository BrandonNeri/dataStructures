package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragments 7.2 to 7.5
 *
 * An implementation of a simple ArrayList Class.
 *
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public class ArrayList<E> implements List<E> {

    public static final int CAPACITY = 16;  // default array capacity
    private E[] data;                       // generic array used for storage
    private int size = 0;                   // current number of elements

    /**
     * 
     * Constructs a list with default capacity.
     */
    public ArrayList() {
        this(CAPACITY);
    }

    /**
     * 
     * Constructs a list with given capacity.
     *
     * @param capacity creates a list with a given size
     */
    public ArrayList(int capacity) {
        // safe cast; compiler may give warning
        data = (E[]) new Object[capacity];
    }

    /**
     *
     * @return an int of the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return a boolean: true if empty, false if not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param i index position of a requested element
     * @return an element at index position i
     */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * Replaces the element at index i with e, and returns the replaced element.
     *
     * @param i index position of a given element
     * @param e element to replace the current one at index i
     * @return the replaced element at index position i
     */
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Inserts element e to be at index i, shifting all subsequent elements later.
     *
     * @param i index position of a given element
     * @param e element to be added at index position i
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length) { // not enough capacity
            resize(2 * data.length);
        }
        for (int k = size - 1; k >= i; k--) { // start by shifting rightmost
            data[k + 1] = data[k];
        }
        data[i] = e; // ready to place the new element
        size++;
    }

    /**
     *
     * @param i index position of a given element
     * @return the removed element at index position i
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) { // shift elements to fill hole
            data[k] = data[k + 1];
        }
        data[size - 1] = null; // help garbage collection                 
        size--;
        return temp;
    }

    /**
     * 
     * Checks whether the given index is in the range [0, n−1].
     *
     * @param i given index
     * @param n size of the array
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * 
     * Resizes internal array to have given capacity >= size.
     *
     * @param capacity new size of the ArrayList
     */
    protected void resize(int capacity) {
        // safe cast; compiler may give warning
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp; // start using the new array                            
    }
}
