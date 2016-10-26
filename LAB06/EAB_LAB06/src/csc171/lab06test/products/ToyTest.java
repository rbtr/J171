package csc171.lab06test.products;

import csc171.lab06.products.*;

/**
 * ToyTest.java
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

public class ToyTest {
	private static final String testName = "testToyName";
	private static final String testSerial = "testToySerial";
	private static final double testPrice = 10.04;
	private static final int testMinAge = 3;
	private static final int testMaxAge = 99;

	public static void main(String[] args) {
		Toy testToy = new Toy(
			testName,
			testSerial,
			testPrice,
			testMinAge,
			testMaxAge);

		test(testToy);
	}

	public static void test(Toy toy) {
		System.out.println(toy);

		if (!toy.getName().equals(testName) ||
				!toy.getSerial().equals(testSerial) ||
				toy.getPrice() != testPrice ||
				toy.getMinAge() != testMinAge ||
				toy.getMaxAge() != testMaxAge) {
			System.out.println("Toy failed test!");
			return;
		}

		System.out.println("Toy passed test.");
	}
}