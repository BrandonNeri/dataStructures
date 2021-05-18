package Lab105;

/**
 * 
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T. 
 * Goodruch, Roberto Tamassia, and Michael H. Goldwasser Wiley 2014
 * 
 * Code Fragment 6.10
 * 
 * An implementation of a simple ArrayQueue Class. A collection of objects 
 * that are inserted and removed according to the first-in first-out principle. 
 * This implementation of the queue uses a fixed-length array.
 * 
 * @author Brandon Neri (Transcribed)
 * @param <E>
 * 
 */
public class ArrayQueue<E> implements Queue<E> {
    public static final int CAPACITY = 1000;  // default array capacity
    private E[] data;                         // generic array used for storage
    private int frontIndex = 0;               // index of the front element
    private int size = 0;                     // current number of elements

    /**
     * 
     * Constructs queue with default capacity.
     */
    public ArrayQueue() {
        this(CAPACITY);
    }

    /**
     * 
     * Constructs queue with given capacity.
     * 
     * @param capacity size of the queue
     */
    public ArrayQueue(int capacity) {
        // safe cast; compiler may give warning
        data = (E[]) new Object[capacity];
    }

    /**
     * 
     * @return an int giving the number of elements of the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 
     * @return a boolean indicating whether the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Inserts an element at the rear of the queue.
     * 
     * @param e element to be enqueued
     * @throws IllegalStateException
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (frontIndex + size) % data.length;  // use modular arithmetic
        data[avail] = e;
        size++;
    }

    /**
     * 
     * @return  returns, but does not remove, the first element of the queue (null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null; // returns null if no items are in array
        }
        return data[frontIndex];
    }

    /**
     * 
     * @return removes and returns the first element of the queue (null if empty)
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null; // returns null if no items are in array
        }
        E answer = data[frontIndex];
        data[frontIndex] = null; // dereference to help garbage collection
        frontIndex = (frontIndex + 1) % data.length;
        size--;
        return answer;
    }
}
