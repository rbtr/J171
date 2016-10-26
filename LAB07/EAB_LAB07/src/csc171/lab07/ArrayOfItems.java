package csc171.lab07;

/**
 * ArrayOfItems.java
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
 * This class defines an array backed List
 * It's essentially an incomplete ArrayList implementation
 */

public class ArrayOfItems extends AbstractItems {
	// The objects in the list
	// The size of this is defined in the constructor
	Object[] arr;

	// This keeps track of where in the list we are as items are added
	// This prevents us from being able to add 11 items to a 10 item list
	// it is also used to get the current populated size of the list (not the max size!)
	int pointer;

	// Constructor taking the max size of the list
	public ArrayOfItems(int maximumSize) {
		arr = new Object[maximumSize];
		pointer = 0;
	}

	// Adds an item to the list at the current pointer position, then advances the pointer
	// Throws an exception if the list is full
	@Override
	public void add(Object o) throws IndexOutOfBoundsException {
		if (pointer < arr.length) {
			arr[pointer] = o;
			pointer++;
		} else {
			throw new IndexOutOfBoundsException("Index " + pointer + ", size: " + arr.length);
		}
	}

	// Gets the populated size of the list
	@Override
	public int size() {
		return pointer;
	}

	// Gets the object at the specified index of the list
	// Throws an exception if the requested index is out of the bounds of the list
	@Override
	public Object get(int i) {
		if (i < pointer) {
			return arr[i];
		} else {
			throw new IndexOutOfBoundsException("Requested index " + i + ", last entry: " + pointer);
		}
	}
}