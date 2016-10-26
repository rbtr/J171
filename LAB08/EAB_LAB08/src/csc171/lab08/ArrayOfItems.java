package csc171.lab08;

/**
 * ArrayOfItems.java
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
	// It also resizes the array if it is full
	@Override
	public void add(Object o) throws IndexOutOfBoundsException {
		// Check if the array is not full
		if (pointer < arr.length) {
			arr[pointer] = o;
			pointer++;
		} else {
			// The array is full, so grow it and try again
			growArray();
			add(o);
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
	public Object get(int index) {
		if (index < pointer) {
			return arr[index];
		} else {
			throw new IndexOutOfBoundsException("Requested index " + index + ", last entry: " + pointer);
		}
	}

	// Remove the item at the specified index from the list and return it
	// Throws an exception if the index is out of bounds 
	@Override
	public Object remove(int index) {
		// The get method nicely handles pulling the item out
		Object o = get(index);
		// If that didn't throw an error, then the index is valid and 
		// we can proceed with shifting the values over -1
		while (index < pointer - 1) {
			arr[index] = arr[index + 1];
			index++;
		}

		// Remove the item
		arr[index] = null;

		// Decrement the pointer
		pointer--;

		return o;
	}

	// Add the passed Object at the specified index
	@Override
	public void insert(Object o, int index) {

		// Next, check if the index is within the array
		if (index < arr.length) {

			// Then also check that there is empty space at the end of the 
			// array to shift the current objects in to
			if (pointer < arr.length) {
				// Shift the values of the array over +1
				for (int j = pointer; j > index; j--) {
					arr[j] = arr[j - 1];
				}
				// Then put the object in at i
				arr[index] = o;
				// And increment the pointer by +1
				pointer++;
			} else {
				// If there isn't, make room and try again
				growArray();
				// Try again!
				insert(o, index);
			}
		} else {
			// If the index is not within the array, 
			// add the value to the end
			add(o);
		}
	}

	private void growArray() {
		// Grow the array by 1
		Object[] newArr = new Object[arr.length + 1];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
}