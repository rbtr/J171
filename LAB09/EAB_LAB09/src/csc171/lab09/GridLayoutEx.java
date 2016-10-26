package csc171.lab09;

import java.lang.Override;
import javax.swing.*;
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

class GridLayoutEx extends JFrame {

    // Varargs constructor to allow the circle count to be set if desired
    public GridLayoutEx(int rows, int cols) {
        Container content = getContentPane();
        content.setLayout(new GridLayout(rows, cols));

        populateGrid(rows, cols, content);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void populateGrid(int rows, int cols, Container container) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                container.add(new JLabel("Item " + i + "x" + j));
            }
        }
    }

    public static void main(String[] args) {
        GridLayoutEx gle = new GridLayoutEx(5, 6);
        gle.setSize(600, 500);
        gle.setVisible(true);
    }
}