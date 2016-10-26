package csc171.lab10.tests;

/*
 * TestFailedException.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

/**
 * A custom exception that indicates that a Test failed. Thrown by the test classes if something breaks.
 */
public class TestFailedException extends Exception {

    /**
     * Constructs a TestFailedException with the passed message
     * @param message the exception message
     */
    TestFailedException(String message) {
        super(message);
    }
}
