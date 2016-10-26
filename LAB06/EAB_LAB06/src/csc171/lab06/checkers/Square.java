package csc171.lab06.checkers;

import java.lang.StringBuilder;

/**
 * Square.java
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

public class Square {

	private final boolean isSquareRed;
	private boolean isSquareOccupied;

	// Protected constructor - this shouldn't be called outside of 
	// the checkers package for now.
	protected Square(boolean isSquareRed) {
		this.isSquareRed = isSquareRed;
	}

	// Setter for occupation state only
	public void setOccupied(boolean isSquareOccupied) {
		this.isSquareOccupied = isSquareOccupied;
	}

	// Getters for all states
	public boolean isRed() {
		return isSquareRed;
	}

	public boolean isOccupied() {
		return isSquareOccupied;
	}


	// Class methods
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("|");
		sb.append(isRed() ? "R" : "B");
		sb.append(isOccupied() ? "*" : " ");
		sb.append("|");
		return sb.toString();
	}
}