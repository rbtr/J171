package csc171.lab10.tests;

/*
 * CheckerBoardTest.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

import csc171.lab10.checkerboard.Checkerboard;

/**
 * Creates a checkerboard
 */

public class CheckerBoardTest {

    private static final int ROWS = 8;
    private static final int COLUMNS = 8;

    /**
     * Creates and displays a checkerboard as a test
     * @throws TestFailedException
     */
    public static void test() throws TestFailedException {
        Checkerboard checkerboard = new Checkerboard(ROWS, COLUMNS);
        System.out.println("Does this checkerboard look ok?");
        System.out.println(checkerboard);
    }
}
