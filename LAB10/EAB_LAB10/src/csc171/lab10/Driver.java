package csc171.lab10;

/*
 * Driver.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

import csc171.lab10.bullseye.Bullseye;
import csc171.lab10.tests.CarTest;
import csc171.lab10.tests.CheckerBoardTest;
import csc171.lab10.tests.IoExamplesTest;
import csc171.lab10.tests.TestFailedException;
import csc171.lab10.wonderland.ButtonLabel;
import csc171.lab10.wonderland.ButtonResize;
import csc171.lab10.wonderland.Cloner;
import csc171.lab10.wonderland.ColorPicker;

import java.util.Scanner;

/**
 * This is a Driver method that handles running the rest of the programs in this assignment and the tests
 */
public class Driver {

    /**
     * Main entry point in to the program
     * @param args arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean doContinue;

        do {
            System.out.print("Select an option\n1) Run CLI tests\n2)Display GUI components\n");

            int selection = -1;
            while (selection < 0) {
                try {
                    selection = scanner.nextInt();
                } catch (Exception e) {
                    // Squash
                }
            }

            switch (selection) {
                case 1:
                    cli();
                    break;
                case 2:
                    gui();
                    break;
            }


            System.out.print("Go again?\n(y)es/no :");
            String input = scanner.next();
            doContinue = isContinue(input);
        } while (doContinue);

        // Clean up - kill the JVM that the graphics windows may have left running
        System.exit(0);
    }

    /**
     * Tests if the passed String evaluates to a "yes" or "continue"
     * @param input the String to evaluate
     * @return if the String is affirmative continue
     */
    private static boolean isContinue(String input) {
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("continue") || input.equalsIgnoreCase("cont");
    }

    /**
     * Runs the CLI Sections
     */
    private static void cli() {

        System.out.println("Section 1");

        try {
            CarTest.test();
        } catch (TestFailedException e) {
            e.printStackTrace();
        }


        System.out.println("Section 2");

        try {
            CheckerBoardTest.test();
        } catch (TestFailedException e) {
            e.printStackTrace();
        }


        System.out.println("Section 8/9");

        try {
            IoExamplesTest.test();
        } catch (TestFailedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the GUI Sections
     */
    private static void gui() {

        System.out.println("Section 3");

        ButtonLabel bl = new ButtonLabel();
        bl.display(true);


        System.out.println("Section 4");

        ButtonResize br = new ButtonResize();
        br.display(true);


        System.out.println("Section 5");

        Cloner c = new Cloner();
        c.display(true);


        System.out.println("Section 6");

        ColorPicker cp = new ColorPicker();
        cp.display(true);


        System.out.println("Section 7");

        Bullseye b = new Bullseye(6);
        b.display();
    }
}
