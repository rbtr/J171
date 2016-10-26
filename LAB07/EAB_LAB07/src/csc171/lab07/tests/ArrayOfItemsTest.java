package csc171.lab07;

/**
 * ArrayOfItemsTest.java
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
 * This class builds and tests an ArrayOfItems to make sure the class functions as expected
 */

public class ArrayOfItemsTest {

	// Define some testing parameters
	private static final int maxSize = 10;
	private static final String testString = "test";

	public static void main(String[] args) {

		// Make an ArrayOfItems with the maxSize constructor, setting the max size to 10
		System.out.println("Making ArrayOfItems with maxSize 10");
		ArrayOfItems aoi = new ArrayOfItems(maxSize);

		// Add 5 items to the AOI
		for (int i = 0; i < maxSize / 2; i++) {
			aoi.add(testString + String.valueOf(i));
		}

		// Make sure there are 5 items in the AOI
		System.out.println("Added 5 items to ArrayOfItems");
		if (aoi.size() != 5) {
			System.out.println("ArrayOfItems.size() != 5");
			return;
		}

		// Add 5 more items to the AOI
		for (int i = 5; i < maxSize; i++) {
			aoi.add(testString + String.valueOf(i));
		}

		// Make sure the AOI has 10 items now
		System.out.println("Added 5 items to ArrayOfItems");
		if (aoi.size() != 10) {
			System.out.println("ArrayOfItems.size() != 10");
			return;
		}

		// Test add(), making sure it's not possible to add more objects than the maxSize
		try {
			aoi.add(testString);
			System.out.println("Succesfully added out of range 11th item. Failed.");
			return;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Adding 11th item failed as designed since maxSize = 10");
		}

		// Test the getter
		try {
			System.out.println("Getting item at 7");
			System.out.println("=> " + aoi.get(7));
		} catch (IndexOutOfBoundsException e) {
		}

		// Test that out of bounds indices are not gettable
		try {
			System.out.println("Getting item at 11");
			System.out.println("=> " + aoi.get(11));
			System.out.println("Succesfully got out of range 11th item. Failed.");
			return;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Getting 11th item failed as designed since maxSize = 10");
		}

		// Test the addAll method
		System.out.println("Testing addAll");

		aoi = new ArrayOfItems(3);
		aoi.addAll(new String[] {"String1", "String2", "String3"});
		String output = aoi.toString();
		if (!output.equals("String1 String2 String3 ")) {
			System.out.println("addAll() or toString failed");
			System.out.println(output);
			return;
		}

		System.out.println("ArrayOfItemsTest passed.");
	}
}