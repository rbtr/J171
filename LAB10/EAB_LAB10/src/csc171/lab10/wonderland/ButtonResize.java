package csc171.lab10.wonderland;

/*
 * ButtonResize.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */


import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class inherits from ButtonLabel and overrides its methods to change the behavior slightly
 */

public class ButtonResize extends ButtonLabel {

    /**
     * Override the makeLabel and prevent it from doing anything in this class
     */
    @Override
    protected void makeLabel() {
        // Do nothing
    }

    /**
     * Handles the onClick of the buttons - resizes the window now
     * @param e is the action indicated from the button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension d = getSize();

        double width = d.getWidth();
        double height = d.getHeight();

        if (e.getActionCommand().equalsIgnoreCase(grow)) {
            // Increase size to 110%
            setSize((int) (1.1d * width), (int) (1.1d * height));
        }
        if (e.getActionCommand().equalsIgnoreCase(shrink)) {
            // Decrease size to 90%
            setSize((int) (0.9d * width), (int) (0.9d * height));
        }
    }
}
