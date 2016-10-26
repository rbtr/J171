package csc171.lab10.checkerboard;

import java.lang.StringBuilder;

/*
 * Checkerboard.java
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 06
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 2/28/15
 *
 * This is copy and pasted exactly from Lab 06 with a single modification - adding final to the Square[][] field.
 */

/**
 * A class representing a checkerboard.
 */
public class Checkerboard {

    /**
     * The matrix of squares representing the Checkerboard
     */
	private final Square[][] squares;

    /**
     * Constructs a checkerboard of the specified number of rows and columns
     * @param rows the number of rows in the board
     * @param columns the number of columns in the board
     */
	public Checkerboard(int rows, int columns) {
		squares = new Square[rows][columns];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				
				// Determine if this square is black or red
				boolean isRed = true;
				if (c % 2 == 0 && r % 2 == 0) {
					isRed = false;
				}
				if (c % 2 != 0 && r % 2 != 0) {
					isRed = false;
				}
				squares[r][c] = new Square(isRed);

				// Set if the square is occupied
				squares[r][c].setOccupied((!squares[r][c].isRed()) && (r < 3 || (r >= 5)));
			}
		}
	}

	// No Getters or Setters


	// Class methods

    /**
     * Turns a Square[] designated as a 'row' in to a String suitable for printing to the commandline
     * @param row the row to parse
     * @return the printable String of the row
     */
	private String rowToString(Square[] row) {
		// Using a StringBuilder for efficiency for iterating over a 
		// potentially large set.
		StringBuilder sb = new StringBuilder();

		for (Square s : row) {
			sb.append(s.toString());
		}

		return sb.toString();
	}

    /**
     * Custom toString method that turns the board (the Square[][]) into a String suitable for printing on the
     * commandline to visually represent the board
     * @return the printable String of the board
     */
	@Override
	public String toString() {
		// Using a StringBuilder for efficiency for iterating over a 
		// potentially large set.
		StringBuilder sb = new StringBuilder();

		for (Square[] row : squares) {
			sb.append(rowToString(row));
			sb.append("\n");
		}

		return sb.toString();
	}
}