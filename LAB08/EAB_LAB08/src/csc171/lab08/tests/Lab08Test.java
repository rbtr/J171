package csc171.lab08.tests;

import csc171.lab08.*;

/**
 * Lab08Test.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 08
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/28/15
 * 
 * This class tests the lab08 package
 */

public class Lab08Test {

	private static final String[] TEST_ARRAY_00 = {
		"00",
		"01",
		"02",
		"03",
		"04"
	};

	private static final String[] TEST_ARRAY_01 = {
		"05",
		"06",
		"07",
		"08",
		"09"
	};

	private static final String TEST_INSERTION_00 = "10";
	private static final String TEST_INSERTION_01 = "11";

	public static void main(String[] args) {
		System.out.println("Testing ArrayOfItems");
		testItems(new ArrayOfItems(TEST_ARRAY_00.length + TEST_ARRAY_01.length));

		System.out.println("Testing ListOfItems");
		testItems(new ListOfItems());
	}


	private static void testItems(AbstractItems list) {

		// Testing individual additions
		for (String s : TEST_ARRAY_00) {
			list.add(s);
		}

		printList(list);

		// Testing array additions
		list.addAll(TEST_ARRAY_01);

		printList(list);

		// Testing body insertion
		list.insert(TEST_INSERTION_00, list.size() / 2);

		printList(list);

		// Testing off-end insertion
		list.insert(TEST_INSERTION_01, list.size());

		printList(list);

		// Testing body removal
		list.remove(list.size() / 2 - 1);

		printList(list);

		// Testing tail removal
		list.remove(list.size() - 1);

		printList(list);
	}

	private static void printList(AbstractItems list) {
		System.out.println(list.toString());
	}
}