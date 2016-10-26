package csc171.lab10.bullseye;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Override;
import javax.swing.*;
import java.awt.*;

/*
 * Bullseye.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 09
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/4/15
 */

/**
 * This is class that draws a dartboard and responds to clicks in the dartboard. It is pulled almost exactly from lab09.
 */

public class Bullseye extends JFrame implements MouseListener {

    private static final String missed = "Missed!";
    private static final String bullseye = "Bullseye!";

    private int CIRCLE_COUNT = 6;

    private int topPadding = 0;
    private Point center = null;
    private int centerRadius = -1;

    private JLabel label;

    /**
     * Varargs constructor to allow the circle count to be set if desired
     * @param ints an array of the number of circles to draw per bullseye
     */
     public Bullseye(int... ints) {
         if (ints.length > 0) {
             CIRCLE_COUNT = ints[0];
         }
         Container content = getContentPane();
         content.setLayout(new BorderLayout());

         JPanel panel = new JPanel();
         panel.addMouseListener(this); // Listen for mouse events on the panel
         setBackground(new Color(255, 255, 255)); // Set the background to white
         content.add(panel, BorderLayout.CENTER);

         makeLabel();
         content.add(label, BorderLayout.PAGE_END);

         setDefaultCloseOperation(HIDE_ON_CLOSE); // Don't want to kill the JVM, only get rid of the focused window
    }

    /**
     * Makes the JLabel
     */
    private void makeLabel() {
        label = new JLabel();
    }

    /**
     * Paints the bullseye
     * @param g the Graphics to paint with
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Get the window dimensions
        Dimension dims = getSize();
        int height = (int) dims.getHeight();
        int width = (int) dims.getWidth();

        // Get the window inset to compensate for the window title bar
        Insets insets = getInsets();
        topPadding = insets.top;

        // Subtract the window inset from the window height to get only the usable height
        height -= topPadding;

        // Radius spacing
        // Include enough outer padding for 1 more circle so that the board doesn't run all the way to the edge
        int radSpacing = ((height > width ? width : height )/ 2) / (CIRCLE_COUNT + 1);

        // Find the center of the canvas to draw the circles around
        int centerX = width / 2;
        int centerY = (height / 2) + topPadding;

        // Set the center Point to these coordinates
        center = new Point(centerX, centerY);
        centerRadius = radSpacing;

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

    /**
     * Handles Mouse Events on this Class. Specifically, updates the Label to reflect a click in or out of the bullseye.
     * @param e is the MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickLocation = e.getLocationOnScreen();
        clickLocation.setLocation(clickLocation.getX(), clickLocation.getY() - topPadding);

        if (center == null || label == null || centerRadius < 0) {
            throw new IllegalStateException("Bullseye not drawn or has been dereferenced...");
        }

        // Get the click distance from the (adjusted) center of the display window
        double distanceFromCenter = distanceBetweenPoints(clickLocation, center);

        // If the click is within the bullseye, update the label to reflect that
        if (distanceFromCenter < centerRadius) {
            label.setText(bullseye);
        } else {
            label.setText(missed);
        }

        // Repaint the bullseye
        repaint();
    }

    /**
     * Helper method to get the distance between two points. Used for determining in which circle the user is clicking
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the points
     */
    private double distanceBetweenPoints(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();

        double x2 = p2.getX();
        double y2 = p2.getY();

        double diffX = x2 - x1;
        double diffY = y2 - y1;

        double diffSquared = Math.pow(diffX, 2) + Math.pow(diffY, 2);

        return Math.sqrt(diffSquared);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void display() {
        setSize(500, 500);
        setVisible(true);
    }
}