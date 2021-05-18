package Lab105;

/**
 *
 * Data Structures & Algorithms in Java, 6th Edition By: Michael T.
 * Goodruch, Roberto Tamassia, and Michael H. 
 * Goldwasser Wiley 2014
 * 
 * Code Fragments 3.14 & 3.15
 * 
 * @author Brandon Neri (Transcribed)
 *
 * The following code SinglyLinkedList.java is a java class that 
 * uses Code fragments 3.14 and 3.15 that creates a SinglyLinkedList. 
 * It makes use of the linear data structures called linked lists 
 * using different nodes in which data can be stored and modified.
 * 
 * @param <E>
 *
 */
public class SinglyLinkedList<E> {

    //---------------- nested Node class ----------------   
    private static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        /**
         * 
         * @param e element at a node n in a list
         * @param n node at a given position in the list
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        /**
         * 
         * @return the element at a given node in the list
         */
        public E getElement() {
            return element;
        }

        /**
         * 
         * @return the next node in the given list
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * 
         * @param n sets the next node in the list
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }//----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null; // head node of the list
    private Node<E> tail = null; // last node of the list
    private int size = 0; // number of nodes in the list

    /**
     * 
     * Constructs an initially empty list
     */
    public SinglyLinkedList() {
    }

    /**
     * 
     * @return size of linked list
     */
    public int size() {
        return size;
    }

    /**
     * 
     * @return if the list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 
     * @return the first element of the list
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     * 
     * @return the last element of the list
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * 
     * @param e element to be added to front of the list
     */
    public void addFirst(E e) {
        head = new Node<>(e, head); // create and link a new node
        if (size == 0) {
            tail = head; // special case: new node becomes a tail also
        }
        size++;
    }

    /**
     * 
     * @param e element to be added to end of the list
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty()) {
            head = newest; // speical case: previously empty list
        } else {
            tail.setNext(newest); // new node after existing tail
        }
        tail = newest; // new node becomes after the tail
        size++;
    }

    /**
     * 
     * @return removes and returns the first element of list
     */
    public E removeFirst() {
        if (isEmpty()) { // nothing to remove
            return null;
        }
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null; // special case as list is now empty
        }
        return answer;
    }
}
