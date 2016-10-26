package csc171.lab09;

import java.lang.Override;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * MyLayout.java
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
 * This class is a custom layout implementing the following:
 * a. Use of three different colors
 * c. A non-default layout manager
 * d. An overridden paint method that draws custom shapes/lines/fonts
 */

class MyLayout extends JFrame {

    private int SHAPE_COUNT = 5;

    // Varargs constructor to allow the circle count to be set if desired
    public MyLayout() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        content.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        // Get the window dimensions
        Dimension dims = getSize();
        int height = (int) dims.getHeight();
        int width = (int) dims.getWidth();

        // Get the window inset to compensate for the window title bar
        Insets insets = getInsets();
        int topPadding = insets.top;

        // Blank the canvas
        g.setColor(new Color(0, 255, 255));
        g.fillRect(0, 0, width, height);

        // Subtract the window inset from the window height to get only the usable height
        height -= topPadding;

        // Get the shape spacing
        int shapeSpacing = ((height > width ? width : height )/ 2) / (SHAPE_COUNT + 1);

        // Find the center of the canvas to draw the shapes around
        int centerX = width / 2;
        int centerY = (height / 2) + topPadding;

        // Draw some different concentric shapes
        // Painting only in the usable area
        for (int i = 0; i < SHAPE_COUNT; i++) {
            if (i % 2 == 0) {
                g.setColor(new Color(0, 0, 255)); // Set the paint color to blue
            } else {
                g.setColor(new Color(0, 0, 0)); // Set the paint color black
            }

            int halfShapeWidth = shapeSpacing * (SHAPE_COUNT - i);

            switch (i) {
                case 0:
                    g.fillRect(centerX - halfShapeWidth, centerY - halfShapeWidth, 2 * halfShapeWidth, 2 * halfShapeWidth);
                    break;
                case 1:
                    g.fillOval(centerX - halfShapeWidth, centerY - halfShapeWidth, 2 * halfShapeWidth, 2 * halfShapeWidth);
                    break;
                case 2:
                    g.fillRoundRect(centerX - halfShapeWidth, centerY - halfShapeWidth, 2 * halfShapeWidth, 2 * halfShapeWidth, 50, 25);
                    break;
                case 3:
                    g.fillRect(centerX - halfShapeWidth, centerY - halfShapeWidth, 2 * halfShapeWidth, 2 * halfShapeWidth);
                    break;
                case 4:
                    g.fillOval(centerX - halfShapeWidth, centerY - halfShapeWidth, 2 * halfShapeWidth, 2 * halfShapeWidth);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MyLayout ml = new MyLayout();
        ml.setSize(500, 500);
        ml.setVisible(true);
    }
}