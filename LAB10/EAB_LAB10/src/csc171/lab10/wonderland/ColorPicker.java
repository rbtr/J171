package csc171.lab10.wonderland;

/*
 * ColorPicker.java
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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class displays a radio button group of colors and changes the color of a label to match the selection
 */
public class ColorPicker extends DynamicFrame implements ActionListener {

    private static final String red = "Red";
    private static final String blue = "Blue";
    private static final String green = "Green";
    private static final String yellow = "Yellow";
    private static final String purple = "Purple";

    private static final String choose = "Choose!";

    private static final String noColor = "Select a color.";

    private JLabel label;
    private ButtonGroup group;

    /**
     * Child specific Ui
     */
    @Override
    void specificUi() {
        makeRadioButtons();
        makeButton();
        makeLabel();
    }

    /**
     * Makes the Radio Buttons of colors (and groups them)
     */
    private void makeRadioButtons() {
        // Make buttons
        JRadioButton button0 = new JRadioButton(red);
        button0.setVerticalTextPosition(AbstractButton.CENTER);
        button0.setHorizontalTextPosition(AbstractButton.LEADING);
        button0.setActionCommand(red);

        JRadioButton button1 = new JRadioButton(blue);
        button1.setVerticalTextPosition(AbstractButton.CENTER);
        button1.setHorizontalTextPosition(AbstractButton.LEADING);
        button1.setActionCommand(blue);

        JRadioButton button2 = new JRadioButton(green);
        button2.setVerticalTextPosition(AbstractButton.CENTER);
        button2.setHorizontalTextPosition(AbstractButton.LEADING);
        button2.setActionCommand(green);

        JRadioButton button3 = new JRadioButton(yellow);
        button3.setVerticalTextPosition(AbstractButton.CENTER);
        button3.setHorizontalTextPosition(AbstractButton.LEADING);
        button3.setActionCommand(yellow);


        JRadioButton button4 = new JRadioButton(purple);
        button4.setVerticalTextPosition(AbstractButton.CENTER);
        button4.setHorizontalTextPosition(AbstractButton.LEADING);
        button4.setActionCommand(purple);


        // Make a button group
        group = new ButtonGroup();

        // Add the buttons to the group
        group.add(button0);
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);

        // Add the buttons to the view
        add(button0);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    /**
     * Makes the choose Button
     */
    private void makeButton() {
        // Make button 2
        JButton button = new JButton(choose);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.LEADING);
        button.setActionCommand(choose);
        button.addActionListener(this);

        // Add the buttons
        add(button);
    }

    /**
     * Adds a label
     */
    protected void makeLabel() {
        // Make the label
        label = new JLabel(noColor);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        // Add the label
        add(label);
    }

    /**
     * Handles the button onClick actions
     * @param e is the action selected
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase(choose)) {
            label.setForeground(getSelectedColor());
            label.setText("You selected " + getSelectedText() + "!");
        }
    }

    /**
     * This method gets the currently selected radio button and returns the corresponding color
     * @return the Color selected
     */
    private Color getSelectedColor() {
        String selectedText = getSelectedText();

        if (selectedText.equalsIgnoreCase(red)) {
            return new Color(255, 0, 0);
        }

        if (selectedText.equalsIgnoreCase(blue)) {
            return new Color(0, 55, 255);
        }
        if (selectedText.equalsIgnoreCase(green)) {
            return new Color(0, 255, 0);
        }

        if (selectedText.equalsIgnoreCase(yellow)) {
            return new Color(255, 255, 0);
        }

        if (selectedText.equalsIgnoreCase(purple)) {
           return new Color(145, 0, 255);
        }

        return new Color(255, 255, 255);
    }

    /**
     * This method returns the action from the selected item in the Radio Button Group
     * @return the selected button action
     */
    private String getSelectedText() {
        return group.getSelection().getActionCommand();
    }
}
