package csc171.lab06.products;

/**
 * Book.java
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

public class Book extends Product {

	// The author and num pages should not change
	private final String author;
	private final int numPages;


	public Book(String name, String serial, double price, String author, int numPages) {
		super(name, serial, price);
		this.author = author;
		this.numPages = numPages;
	}

	// No setters because the private fields are immutable

	// Getters
	public String getAuthor() {
		return author;
	}

	public int getNumPages() {
		return numPages;
	}


	// Class methods
 	@Override
 	public String toString() {
 		return (super.toString() + "; By " + author + "; " + numPages + " pages");
 	}
}