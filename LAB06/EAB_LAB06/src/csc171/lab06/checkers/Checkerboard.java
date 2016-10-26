package csc171.lab06.checkers;

import java.lang.StringBuilder;

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

public class Checkerboard {

	private Square[][] squares;


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

	private String rowToString(Square[] row) {
		// Using a StringBuilder for efficiency for iterating over a 
		// potentially large dataset.
		StringBuilder sb = new StringBuilder();

		for (Square s : row) {
			sb.append(s.toString());
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		// Using a StringBuilder for efficiency for iterating over a 
		// potentially large dataset.
		StringBuilder sb = new StringBuilder();

		for (Square[] row : squares) {
			sb.append(rowToString(row));
			sb.append("\n");
		}

		return sb.toString();
	}
}