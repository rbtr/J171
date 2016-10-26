package csc171.lab09;

import java.lang.Override;
import javax.swing.*;
import java.awt.*;

/**
 * Grid.java
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
 * This is a Grid class
 */

class Grid extends JFrame {

	private int mRows;
	private int mCols;

	public Grid(int rows, int cols) {
		this.mRows = rows;
		this.mCols = cols;

		Container content = getContentPane();
		content.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		content.add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// Get the window dimensions
		Dimension dims = getSize();
		int height = (int) dims.getHeight();
		int width = (int) dims.getWidth();

		// Get the window inset to compensate for the window title bar
		Insets insets = getInsets();
		int topPadding = insets.top;

		// Subtract the window inset from the window height to get only the usable height
		height -= topPadding;

		// Get the grid line spacings
		int rowSpacing = height / mRows;
		int colSpacing = width / mCols;


		// Draw the rows
		g.setColor(Color.BLUE);
		for (int i = 1; i < mRows; i++) {
			g.drawLine(0, i * rowSpacing + topPadding, width, i * rowSpacing + topPadding);
		}
		// Draw the columns
		for (int i = 1; i < mCols; i++) {
			g.drawLine(i * colSpacing, topPadding, i * colSpacing, height + topPadding);
		}

		Logger.getLogger().log("Painting");
	}

	public static void main(String[] args) {
		Grid grid = new Grid(5, 5);
		grid.setSize(500, 500);
		grid.setVisible(true);
	}
}