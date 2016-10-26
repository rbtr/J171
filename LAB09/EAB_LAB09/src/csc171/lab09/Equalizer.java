package csc171.lab09;

/**
 * Equalizer.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 09
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 4/3/15
 *
 * This class is a comparison utility.
 * It simply compares too objects and return true if they are the same.
 */

class Equalizer {
	public static boolean isEqual(Object a, Object b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		if (a == b) {
			return true;
		}
		if (a.equals(b) || b.equals(a)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Logger logger = Logger.getLogger();

		Double a = new Double(1d);
		Double b = new Double(1d);
		Double c = new Double(2d);

		logger.log("\na == b; a,b != c");

		logger.log("null, null: " + isEqual(null, null));
		logger.log("null, objA: " + isEqual(null, a));
		logger.log("objA, null: " + isEqual(a, null));
		logger.log("objA, objA: " + isEqual(a, a));
		logger.log("objA, objB: " + isEqual(a, b));
		logger.log("objA, objC: " + isEqual(a, c));
	}
}