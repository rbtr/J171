package csc171.lab08;

/**
 * AbstractItems.java
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
 * This abstract class implements the Items interface for communication with a list 
 * and provides a concrete implementation of two of the Items methods: 
 * addAll() simply loops through a passed array and calls the childs add() method on every item
 * toString() calls the child get() methods to retrieve every entry in the child list and calls the entry's toString
 * 		to create a one line representation of the list 
 */

public abstract class AbstractItems implements EnhancedItems {
	
	// Add every item in the passed array to the list by calling the child's add()
	@Override 
	public void addAll(Object[] objects) {
		for (Object o : objects) {
			add(o);
		}
	}

	// Get a string for every item in the list by calling the child's get()
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < size(); i++) {
			Object o = get(i);
			s += o + " ";
		}
		return s;
	}
}