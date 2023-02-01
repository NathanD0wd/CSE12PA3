/**
 * Name: Nathan Dowd
 * PID: A17417179
 * Date: 1/30/2023
 * Sources: PA2 writeup, Piazza
 * 
 * This file contains the MyLinkedList class. 
 * Defines our own implementation of the LinkedList class from Java.
 */

import java.util.AbstractList;

/**
 * A class that extends AbstractList<E> and implements necessary methods.
 * Also contains a seperate class, Node, that is used within MyLinkedList.
 */
public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;

    private static final int MIN = 0;
    private static final int INCREMENT = 1;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }

        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        }

        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //  Implementation of the MyLinkedList Class
    /** Only 0-argument constructor is defined */
    public MyLinkedList() {
        size = MIN;
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    /**
     * Returns number of non sentinel nodes in MyLinkedList
     * 
     * @return number of non sentinel nodes in list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the data contained in node at index
     * 
     * @param index of the node we are targeting
     * @return the data stored within the node at index
     */
    @Override
    public E get(int index) {
        return getNth(index).getElement();
    }

    /**
     * Adds a new node holding data at index
     * 
     * @param index we are adding the new node at
     * @param data is the information the new node will hold
     */
    @Override
    public void add(int index, E data) {
        if ( index < MIN || index > size ) {
            throw new IndexOutOfBoundsException();
        }
        if ( data == null ) {
            throw new NullPointerException();
        }
        Node newNode = new Node(data);
        if ( size == MIN ) {
            head.setNext(newNode);
            tail.setPrev(newNode);
            newNode.setPrev(head);
            newNode.setNext(tail);
            size++;
            return;
        }
        Node next;
        if ( index == size ) {
            next = tail;
        } else next = getNth(index);
        Node prev = next.getPrev();
        newNode.setPrev(prev);
        newNode.setNext(next);
        next.setPrev(newNode);
        prev.setNext(newNode);
        size++;
    }

    /**
     * Adds new node at the end of the list holding data
     * 
     * @param data is the info the new node will hold
     * @return true if successful false otherwise 
     */
    public boolean add(E data) {
        if ( data == null ) {
            throw new NullPointerException();
        }
        int newSize = size + INCREMENT;
        add( size , data );
        return ( size == newSize );
    }

    /**
     * Sets the data in the node at index to new data
     * 
     * @param index of the node we are replacing
     * @param data is the new info the node will be holding
     * @return the data that was previously held by the node at index 
     */
    public E set(int index, E data) {
        if ( index < MIN || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        if ( data == null ) {
            throw new NullPointerException();
        }
        Node change = getNth(index);
        E oldData = change.getElement();
        change.setElement(data);
        return oldData;
    }

    /**
     * Removes the node at index
     * 
     * @param index the index of the node we are removing
     * @return the data that was held in the node at index
     */
    public E remove(int index) {
        if ( index < MIN || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        Node remove = getNth(index);
        E data = remove.getElement();
        remove.getPrev().setNext(remove.getNext());
        remove.getNext().setPrev(remove.getPrev());
        size--;
        return data;
    }

    /**
     * Clears the MyLinkedList of all nodes other than sentinel nodes
     */
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        size = MIN;
    }

    /**
     * Checks if the MyLinkedList is empty
     * 
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return ( size == MIN );
    }

    /**
     * Returns the node at specified index
     * 
     * @param index the index of the node we are looking for
     * @return the node at index
     */
    protected Node getNth(int index) {
        if ( index < MIN || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        int cnt = -INCREMENT;
        Node curr = head;
        while( cnt < index ) {
            curr = curr.getNext();
            cnt++;
        }
        return curr;
    }
}
