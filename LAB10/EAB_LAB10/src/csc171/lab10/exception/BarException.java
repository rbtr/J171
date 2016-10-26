package csc171.lab10.exception;

/*
 * BarException.java
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
 * This class defines a custom exception
 */

public class BarException extends Exception {

    /**
     * Constructs this exception with the specified error message
     * @param errorMessage the message for the exception
     */
    public BarException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs this exception with the specified throwable
     * @param throwable the throwable for the exception
     */
    public BarException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Constructs this exception with the specified Exception
     * @param exception is the exception for this exception
     */
    public BarException(Exception exception) {
        super(exception);
    }

    /**
     * Constructs this exception from the specified error message and throwable
     * @param errorMessage is the error message for this exception
     * @param throwable is the throwable for this exception
     */
    public BarException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
