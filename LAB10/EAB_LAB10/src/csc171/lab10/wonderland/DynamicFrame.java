package csc171.lab10.wonderland;

/*
 * DynamicFrame.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/18/15
 */

import javax.swing.*;
import java.awt.*;

/**
 * This class is a parent for problems 3 through 6. It defines behavior common to all of them where possible and forces
 * the children to implement the specific details of the questions.
 * This seemed like a more elegant way to handle having several questions using similar GUI components with single
 * action/view differences and repeating all the setup boilerplate.
 */

public abstract class DynamicFrame extends JFrame {

    /**
     * Constructs a DynamicFrame parent for the children to build on top of
     */
    DynamicFrame() {
        Container content = getContentPane();
        content.setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(HIDE_ON_CLOSE); // Don't want to kill the JVM, only get rid of the focused window
        specificUi();
    }

    /**
     * Children must implement this method to draw and set up their specific Ui components
     */
    abstract void specificUi();


    /**
     * Helper method to handle displaying this JFrame
     * @param pack is whether to pack
     */
    public void display(boolean pack) {
        if (pack) {
            pack();
        }
        setVisible(true);
    }
}
