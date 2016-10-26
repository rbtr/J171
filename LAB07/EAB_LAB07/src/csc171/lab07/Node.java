package csc171.lab07;

/**
 * Node.java
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
 * This class defines an entry in a (singly) linked List
 */

public class Node {

	private final Object item; // This node is immutable 
	private Node next; // This points to the next entry in the list

	// Construct a standalone node with no nextNode set
	public Node(Object item) {
		this.item = item;
	}

	// Costruct a node with a nextNode attached
	public Node(Object item, Node next) {
		this.item = item; 
		this.next = next;
	}

	// Get the object at the node
	public Object getItem() {
		return item;
	}

	// Get the nextNode
	// Here is where I wanted to annotate as @Nullable
	public Node getNext() {
		return next;
	}

	// Attach a nextNode to make a List
	public void setNext(Node next) {
		this.next = next;
	} 
}