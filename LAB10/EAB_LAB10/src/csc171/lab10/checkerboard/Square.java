package csc171.lab10.checkerboard;

/*
 * Square.java
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 06
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 2/28/15
 *
 * This class is copy and pasted exactly form Lab06. It already had the isSquareRed field modified as final and so no
 * changes were necessary to fulfill the requirements of the problem.
 */

import java.lang.StringBuilder;

/**
 * A class representing a square on a checkerboard
 */

public class Square {

	/**
	 * Denotes whether the square is red or black. Will not change over the life of the square.
	 */
	private final boolean isSquareRed;

	/**
	 * Denotes whether the square is currently occupied by a checker. Will change over the life of the square.
	 */
	private boolean isSquareOccupied;

	/**
	 * Creates a square object.
	 * @param isSquareRed indicates whether the square is red or not red (black).
	 */
	protected Square(boolean isSquareRed) {
		this.isSquareRed = isSquareRed;
	}

	/**
	 * Sets whether this square is occupied by a checker
	 * @param isSquareOccupied whether the square is occupied by a checker
	 */
	public void setOccupied(boolean isSquareOccupied) {
		this.isSquareOccupied = isSquareOccupied;
	}

	/**
	 * @return if the square is red
	 */
	public boolean isRed() {
		return isSquareRed;
	}

	/**
	 * @return if the square is occupied
	 */
	public boolean isOccupied() {
		return isSquareOccupied;
	}

	/**
	 * Creates a String representation of the square suitable for printing to the commandline to visually represent the
	 * square and indicating color and occupation state.
	 * @return the String representing the square
	 */
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