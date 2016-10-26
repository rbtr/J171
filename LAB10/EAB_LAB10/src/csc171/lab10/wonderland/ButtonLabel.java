package csc171.lab10.wonderland;

/*
 * ButtonLabel.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class representing a simple Wonderland GUI that holds two buttons and a label. Inherits from DynamicFrame.
 */

public class ButtonLabel extends DynamicFrame implements ActionListener {

    // Class constants - protected so that they can be inherited
    protected static final String button1text = "Drink me!";
    protected static final String button2text = "Eat me!";
    protected static final String grow = "grow";
    protected static final String shrink = "shrink";
    protected static final String grew = "You got bigger!";
    protected static final String shrunk = "You got smaller!";
    protected static final String select = "Make a selection";

    // Label that updates to reflect which button was pressed
    private JLabel label;

    /**
     * Implements the specific Ui details of this class
     */
    @Override
    void specificUi() {
        makeButtons();
        makeLabel();
    }

    /**
     * Adds two buttons
     */
    private void makeButtons() {
        // Make button 1
        JButton button0 = new JButton(button1text);
        button0.setVerticalTextPosition(AbstractButton.CENTER);
        button0.setHorizontalTextPosition(AbstractButton.LEADING);
        button0.setActionCommand(shrink);
        button0.addActionListener(this);

        // Make button 2
        JButton button1 = new JButton(button2text);
        button1.setVerticalTextPosition(AbstractButton.CENTER);
        button1.setHorizontalTextPosition(AbstractButton.LEADING);
        button1.setActionCommand(grow);
        button1.addActionListener(this);

        // Add the buttons
        add(button0);
        add(button1);
    }

    /**
     * Adds a label
     */
    protected void makeLabel() {
        // Make the label
        label = new JLabel(select);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        // Add the label
        add(label);
    }

    /**
     * Handles the onClick of the buttons
     * @param e is the action indicated from the button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (label == null) {
            throw new IllegalStateException("label not initialized");
        }

        if (e.getActionCommand().equalsIgnoreCase(grow)) {
            label.setText(grew);
        }
        if (e.getActionCommand().equalsIgnoreCase(shrink)) {
            label.setText(shrunk);
        }
    }
}
