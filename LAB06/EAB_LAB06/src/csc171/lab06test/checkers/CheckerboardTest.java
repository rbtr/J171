package csc171.lab06test.checkers;

import csc171.lab06.checkers.*;

/**
 * Checkerboard.java
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

public class CheckerboardTest {
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;

	public static void main(String[] args) {
		Checkerboard checkerboard = new Checkerboard(ROWS, COLUMNS); 
		test(checkerboard);
	}

	private static void test(Checkerboard checkerboard) {
		System.out.println("Does this checkerboard look ok?");
		System.out.println(checkerboard);
	}
}