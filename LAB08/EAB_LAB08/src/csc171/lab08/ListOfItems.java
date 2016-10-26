package csc171.lab08;

/**
 * ListOfItems.java
 * 
 * Version 2.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 07 / LAB 08
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/25/15
 *
 * A singly linked List of Nodes and associated methods
 */

public class ListOfItems extends AbstractItems {

	// The head (start of list) and tail (last entry in list)
	private Node head;
	private Node tail;

	// List starts empty
	private int size = 0;

	// Varargs constructor lets this object be created with no params,
	// an array of objects, or n number of objects passed simultaneously
	public ListOfItems(Object... objects) {
		for (Object o : objects) {
			add(o);
		}
	}

	// Attaches a new node to the tail of the list or, if the list is
	// empty, creates a new head node
	@Override
	public void add(Object o) {
		if (head == null) {
			head = new Node(o);
			tail = head;
		} else {
			Node next = new Node(o);
			tail.setNext(next);
			tail = next;
		}
		size++;
	}

	// Adds an array of items to the tail of the list
	@Override
	public void addAll(Object[] items) {
		for (Object o : items) {
			add(o);
		}
	}

	// Gets an object at the specified index in the list
	// If the requested index is outside of the list, throws an exception
	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < size) {
			Node n = getNode(index);
			return n.getItem();
		} else {
			throw new IndexOutOfBoundsException("Index " + index + ", size: " + size);
		}
	}

	// Gets the node at the requested index
	// Calling methods MUST implement their own bounds check, or this will crash
	private Node getNode(int index) {
		Node pointer = head;

		for (int i = 0; i < index + 1; i++) {
			pointer = pointer.getNext();
		}

		return pointer;
	}

	// Gets the size of the list
	@Override
	public int size() {
		return size;
	}

	// Returns a string representing the toString of all of the objects in the list
	@Override
	public String toString() {
		String s = "";

		Node pointer = head;
		
		for (int i = 0; i < size; i++) {
			s += pointer.getItem().toString() + " ";
			pointer = pointer.getNext();
		}

		return s;
	}

	// Remove the item at the specified index from the list and return it
	@Override
	public Object remove(int index) {
		// Index correction
		index--;

		Object o = get(index);
		// If that doesn't throw an exception, then it's a valid index 
		// and we can proceed to remove it

		// Remove the Node in an edge-safe way
		if (index > 0 && index < size - 1) {
			// Node is within list
			// Get the node before the one of interest
			Node before = getNode(index - 1);

			// Set that nodes next to the one after the one of interest
			before.setNext(getNode(index + 1));

		} else if (index == size - 1) {
			// Node is tail
			// Get the node before the one of interest
			Node before = getNode(index - 1);

			// Remove its next
			before.setNext(null);
			tail = before;

		} else if (index == 0) {
			// Node is head
			// Get the node after tho one of interest
			Node after = getNode(index + 1);

			// Set the head to that node
			head = after;
		}

		// Decrement the size so that it stays accurate
		size--;
		return o;
	}

	// Add the passed Object at the specified index
	// Throws an exception if the requested index is out of the new bounds of the list
	@Override
	public void insert(Object o, int index) {
		// Index correction
		index--;
		// We're not allowing insertion past the length + 1 because null nodes are messy
		if (index >= size) {
			// The index is the tail, add a new node 
			add(o);
		} else if (index < size && index > 0) {
			// The index is within the list, do an insertion
			Node before = getNode(index - 1);
			Node obj = new Node(o);

			// Set the obj's next to the before's next
			obj.setNext(before.getNext());

			// Set the before's next to the obj
			before.setNext(obj);

			// All linked up
		} else if (index == 0) {
			// The index is the head
			// Make a new node
			Node obj = new Node(o);
			
			// Make the old head its next
			obj.setNext(head);

			// Set it to the head
			head = obj;
		}

		// Increment the size so it stays accurate
		size++;
	}
}