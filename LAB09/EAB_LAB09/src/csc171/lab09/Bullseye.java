package csc171.lab09;

import java.lang.Override;
import javax.swing.*;
import java.awt.*;

/**
 * Bullseye.java
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
 * This is class that drawes a dartboard
 */

class Bullseye extends JFrame {

    private int CIRCLE_COUNT = 6;

    // Varargs constructor to allow the circle count to be set if desired
    public Bullseye(int... ints) {
        if (ints.length > 0) {
            CIRCLE_COUNT = ints[0];
        }
        Container content = getContentPane();
        content.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        setBackground(new Color(255, 255, 255)); // Set the background to white
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

        // Radius spacing
        // Include enough outer padding for 1 more circle so that the board doesn't run all the way to the edge
        int radSpacing = ((height > width ? width : height )/ 2) / (CIRCLE_COUNT + 1);

        // Find the center of the canvas to draw the circles around
        int centerX = width / 2;
        int centerY = (height / 2) + topPadding;

        // Draw the dartboard
        // Painting only in the usable area
        for (int i = 0; i < CIRCLE_COUNT; i++) {
            if (CIRCLE_COUNT % 2 == 0) {
                if (i % 2 == 0) {
                    g.setColor(new Color(0, 0, 0)); // Set the paint color black
                } else {
                    g.setColor(new Color(0, 0, 255)); // Set the paint color to blue
                }
            } else {
                if (i % 2 == 0) {
                    g.setColor(new Color(0, 0, 255)); // Set the paint color to blue
                } else {
                    g.setColor(new Color(0, 0, 0)); // Set the paint color black
                }
            }

            // The second to last circle should be black
            if (i == CIRCLE_COUNT - 2) {
                g.setColor(new Color(0, 0, 0)); // Set the paint color black
            }

            // The final circle should be red
            if (i == CIRCLE_COUNT - 1) {
                g.setColor(new Color(255, 0, 0)); // Set the paint color to red
            }

            // The {x,y} of the circle is the {centerX, centerY} - circleRadius
            // The {width,height} of the circle is the {x,y} + 2 * circleRadius
            // Since I'm painting outer->in, the circleRadius = radSpacing * (CIRCLE_COUNT - i)
            int circleRadius = radSpacing * (CIRCLE_COUNT - i);

            g.fillOval(centerX - circleRadius, centerY - circleRadius, 2 * circleRadius, 2 * circleRadius);
        }
    }

    public static void main(String[] args) {
        Bullseye be = new Bullseye();
        be.setSize(500, 500);
        be.setVisible(true);
    }
}