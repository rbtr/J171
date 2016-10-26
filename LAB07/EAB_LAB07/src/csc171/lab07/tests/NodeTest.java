package csc171.lab07;

/**
 * NodeTest.java
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
 * This class performs some tests to ensure that the Node class works as expected.
 */

public class NodeTest {
	public static void main(String[] args) {
		// String objects to use a base of comparison
		String string1 = "Node 1";
		String string2 = "Next";

		// Make a node using the single object constructor
		Node node1 = new Node(string1);

		// Make a node using the (object, nextNode) constructor
		Node node2 = new Node(string2, node1);

		// Modify the first node to have the second node as its nextNode
		node1.setNext(node2);

		
		// Tests

		if (!node1.getItem().toString().equals(string1)) {
			System.out.println("Node 1 failed test: wrong item.");
			return;
		}

		if (!node1.getNext().getItem().toString().equals(string2)) {
			System.out.println("Node 1 failed test: wrong next.");
			return;
		}

		if (!node2.getItem().toString().equals(string2)) {
			System.out.println("Node 2 failed test: wrong item.");
			return;
		}

		if (!node2.getNext().getItem().toString().equals(string1)) {
			System.out.println("Node 2 failed test: wrong next.");
			return;
		}

		System.out.println("Node passed test.");
	}
}
