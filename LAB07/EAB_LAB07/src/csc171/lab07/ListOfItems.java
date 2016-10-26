package csc171.lab07;

/**
 * ListOfItems.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 07
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/21/15
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

			Node pointer = head;

			for (int i = 0; i < index + 1; i++) {
				pointer = pointer.getNext();
			}

			return pointer.getItem();
		} else {
			throw new IndexOutOfBoundsException("Index " + index + ", size: " + size);
		}
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
}