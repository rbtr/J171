package csc171.lab10.wonderland;

/*
 * EAB_LAB10.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 01
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class inherits from the DynamicFrame. It contains a text field, a button, and a label. The text from the field
 * is copied to the label when the button is pressed.
 */

public class Cloner extends DynamicFrame implements ActionListener {

    private static final String enterText = "Enter text";
    private static final String clone = "Clone";
    private static final String noText = "No Text";

    private JTextArea textArea;
    private JLabel label;

    /**
     * Provides this child's specific UI implementation
     */
    @Override
    void specificUi() {
        makeTextArea();
        makeButton();
        makeLabel();
    }

    /**
     * Adds a text entry field
     */
    private void makeTextArea() {
        // Make a text input area
        textArea = new JTextArea(enterText);

        // Add the textArea
        add(textArea);
    }

    /**
     * Adds a button
     */
    private void makeButton() {
        // Make a clone button
        JButton button = new JButton(clone);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.LEADING);
        button.setActionCommand(clone);
        button.addActionListener(this);

        // Add the button
        add(button);
    }

    /**
     * Adds a label
     */
    protected void makeLabel() {
        // Make the label
        label = new JLabel(noText);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        // Add the label
        add(label);
    }

    /**
     * Handle the button onClick event
     *
     * @param e is the event to handle
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(clone)) {
            // Get the textArea input and set it to the label
            String text = textArea.getText();
            label.setText(text);
        }
    }
}
