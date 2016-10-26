package csc171.lab07;

/**
 * ListOfItemsTest.java
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
 * This class builds and tests a ListOfItems to ensure the class functions as expected.
 */

public class ListOfItemsTest {

	// Define some testing parameters
	private static final int maxSize = 10;
	private static final String testString = "test";


	public static void main(String[] args) {
		// The ListOfItems has a varargs constructor so it can be initialized with no params
		System.out.println("Making ListOfItems - passing null to varargs");
		ListOfItems loi = new ListOfItems();

		// Add 5 items
		for (int i = 0; i < maxSize / 2; i++) {
			loi.add(testString + String.valueOf(i));
		}

		// Make sure there are 5 items
		System.out.println("Added 5 items to ListOfItems");
		if (loi.size() != 5) {
			System.out.println("ListOfItems.size() != 5");
			return;
		}

		// Add 5 more items
		for (int i = 5; i < maxSize; i++) {
			loi.add(testString + String.valueOf(i));
		}

		// Make sure there are 10 items now
		System.out.println("Added 5 items to ListOfItems");
		if (loi.size() != 10) {
			System.out.println("ListOfItems.size() != 5");
			return;
		}

		// Make sure the getter works
		try {
			System.out.println("Getting item at 7");
			System.out.println("=> " + loi.get(7));
		} catch (IndexOutOfBoundsException e) {
		}

		// Make sure out of bounds indices are NOT gettable
		try {
			System.out.println("Getting item at 11");
			System.out.println("=> " + loi.get(11));
			System.out.println("Succesfully got nonexistent 11th item. Failed.");
			return;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Getting 11th item failed as designed since size = 10");
		}

		// Test the varargs constructor
		System.out.println("Testing varargs constructor");
		loi = new ListOfItems("String1", "String2", "String3");
		String output = loi.toString();
		if (!output.equals("String1 String2 String3 ")) {
			System.out.println("Varags constructor or toString failed");
			System.out.println(output);
			return;
		}

		// Test the addAll method
		System.out.println("Testing addAll");
		loi = new ListOfItems();
		loi.addAll(new String[] {"String1", "String2", "String3"});
		output = loi.toString();
		if (!output.equals("String1 String2 String3 ")) {
			System.out.println("addAll() or toString failed");
			System.out.println(output);
			return;
		}

		System.out.println("ListOfItemsTest passed.");
	}
}