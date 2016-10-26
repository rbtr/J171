package csc171.lab09;

import java.lang.Override;
import javax.swing.*;
import java.awt.*;

/**
 * Checkerboard.java
 *
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 09
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/4/15
 *
 * This is class that drawes a checkerboard
 */

class Checkerboard extends JFrame {

    private int ROWS = 8;
    private int COLS = 8;

    public Checkerboard() {

        Container content = getContentPane();
        content.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        setBackground(new Color(0, 0, 0)); // Set the background to black
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

        // Get the grid sizes
        int rowHeight = height / ROWS;
        int colWidth = width / COLS;


        g.setColor(new Color(255, 0, 0)); // Set the paint color to red
        // Draw the checkerboard
        // Painting should start below the topPadding
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    g.fillRect(colWidth * j, rowHeight * i + topPadding, colWidth, rowHeight);

                }
            }
        }
    }

    public static void main(String[] args) {
        Checkerboard cb = new Checkerboard();
        cb.setSize(500, 500);
        cb.setVisible(true);
    }
}