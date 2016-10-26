import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * LAB01.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 01 
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 01/22/2015
 */

public class LAB01 {
	// Class constants:
	private static final String MY_NAME = "Evan Baker";
	private static final String CREATION_DATE = "01/19/2015";
	private static final String[] MY_FAVORITE_THINGS = {
		"whiskers on kittens",
		"brown paper packages tied up with strings",
		"cream colored ponies"
		};
	
	// Start LAB01 main method.
	public static void main(String[] args) {
		// Grab a Date object to use later when we print the current date.
		Date date = new Date();
		// Set up a DateFormat to parse and print the above Date.
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		
		// LAB PART 1 - Printing my name and the creation date.
		System.out.println("This program was written by " + MY_NAME + " on " + CREATION_DATE + ".");
		System.out.println("Today is " + dateFormat.format(date) + ".");
		
		// LAB PART 2 - Printing with escapes
		// ** I thought a foreach would be worth some extra points **
		// ** I know that \n is the newline escape in a String and ** 
		// ** I know that I could have gotten newlines by using it.**
		// Leading with two escaped newlines to move this down the page...
		System.out.println("\n\nThese are a few of me \"favorite\" things:");
		for (String str : MY_FAVORITE_THINGS) {
			System.out.println(str);
		}
	} // End LAB01 method.
}
