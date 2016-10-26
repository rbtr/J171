package csc171.lab06test.warehouse;

import csc171.lab06.products.*;
import csc171.lab06.warehouse.*;

/**
 * WarehouseTest.java
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

public class WarehouseTest {
	// Test toy params
	private static final String testToyName = "testToyName";
	private static final String testToySerial = "testToySerial";
	private static final double testToyPrice = 10.04;
	private static final int testMinAge = 3;
	private static final int testMaxAge = 99;

	// Test book params
	private static final String testBookName = "testBookName";
	private static final String testBookSerial = "testBookSerial";
	private static final double testBookPrice = 10.04;
	private static final String testAuthor = "testAuthor";
	private static final int testNumPages = 397;


	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();

		System.out.println(warehouse);

		warehouse = addTestProducts(warehouse);
		test(warehouse);
	}

	private static Warehouse addTestProducts(Warehouse warehouse) {
		warehouse.addToy(new Toy(
			testToyName,
			testToySerial,
			testToyPrice,
			testMinAge,
			testMaxAge));

		warehouse.addBook(new Book(
			testBookName,
			testBookSerial,
			testBookPrice,
			testAuthor,
			testNumPages));

		warehouse.addToy(new Toy(
			testToyName,
			testToySerial,
			testToyPrice,
			testMinAge,
			testMaxAge));

		return warehouse;
	}

	private static void test(Warehouse warehouse) {
		if (warehouse.getToyList().size() != 2 || warehouse.getBookList().size() != 1) {
			System.out.println("Warehouse failed test!");
			return;
		}

		System.out.println("Warehouse passed test.");
		System.out.println(warehouse);
	}
}