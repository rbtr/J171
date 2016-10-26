package csc171.lab10.exception;

/*
 * Foo.java
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
 * A basic class that very simple throws my BarException
 */

public class Foo {

    /**
     * Constructs a Foo
     * @param throwMe indicates whether the BarException should be thrown
     * @throws BarException an exception thrown by request
     */
    public Foo(boolean throwMe) throws BarException {
        if (throwMe) {
            throw new BarException("Foo asked to be thrown");
        }
    }
}
