package csc171.lab06test.products;

import csc171.lab06.products.*;

/**
 * BookTest.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 06
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 2/28/15
 */

public class BookTest {
	private static final String testName = "testBookName";
	private static final String testSerial = "testBookSerial";
	private static final double testPrice = 10.04;
	private static final String testAuthor = "testAuthor";
	private static final int testNumPages = 397;

	public static void main(String[] args) {
		Book testBook = new Book(
			testName,
			testSerial,
			testPrice,
			testAuthor,
			testNumPages);

		test(testBook);
	}

	public static void test(Book book) {
		System.out.println(book);

		if (!book.getName().equals(testName) ||
				!book.getSerial().equals(testSerial) ||
				book.getPrice() != testPrice ||
				!book.getAuthor().equals(testAuthor) ||
				book.getNumPages() != testNumPages) {
			System.out.println("Book failed test!");
			return;
		}

		System.out.println("Book passed test.");
	}
}