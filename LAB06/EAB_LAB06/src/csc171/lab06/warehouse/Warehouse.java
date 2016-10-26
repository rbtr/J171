package csc171.lab06.warehouse;

import java.util.ArrayList;
import java.lang.StringBuilder;
import csc171.lab06.products.*;

/**
 * Warehouse.java
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

public class Warehouse {

	ArrayList<Toy> toyList = new ArrayList<>();
	ArrayList<Book> bookList = new ArrayList<>();


	// Default empty constructor

	// No setters, instead, adders
	public void addToy(Toy toy) {
		toyList.add(toy);
	}

	public void addBook(Book book) {
		bookList.add(book);
	}

	// Getters to return the arrayLists
	public ArrayList<Toy> getToyList() {
		return toyList;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}


	// Class methods
	@Override
	public String toString() {
		// Using a StringBuilder for efficiency when iterating over 
		// potentially large sets.

		StringBuilder sb = new StringBuilder();
		sb.append("Products in Warehouse: \n");

		if (toyList.size() > 0) {
			sb.append("Toys: \n");

			for (Toy t : toyList) {
				sb.append("\t");
				sb.append(t);
				sb.append("\n");
			}
		}

		if (bookList.size() > 0) {
			sb.append("Books: \n");

			for (Book b : bookList) {
				sb.append("\t");
				sb.append(b);
				sb.append("\n");
			}
		}

		return sb.toString();
	}
}











