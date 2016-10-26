package csc171.lab09;

import java.lang.Override;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * GridLayoutEx.java
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
 * This class takes dimensions and draws an example GridLayout
 */

class BorderedGridLayoutEx extends JFrame {

    // Varargs constructor to allow the circle count to be set if desired
    public BorderedGridLayoutEx(int rows, int cols) {
        GridLayout grid = new GridLayout(rows, cols, 5, 5);
        setLayout(grid);

        populateGrid(rows, cols);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void populateGrid(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JLabel label = new JLabel("Item " + i + "x" + j, JLabel.CENTER);

                label.setBorder(new LineBorder(Color.BLACK, 2));
                label.setBackground(Color.BLUE);

                add(label);
            }
        }
    }

    public static void main(String[] args) {
		BorderedGridLayoutEx bgle = new BorderedGridLayoutEx(5,6);
		bgle.pack();
		bgle.setVisible(true);
    }
}