package csc171.lab10.tests;

/*
 * IoExamplesTest.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

import csc171.lab10.io.IoExamples;

import java.io.FileNotFoundException;

/**
 * This class tests the IoExamples class
 */

public class IoExamplesTest {

    /**
     * Tests the IoExamples class
     */
    public static void test() throws TestFailedException {
        System.out.println("Testing IoExamples with README.txt");

        if (!IoExamples.doesFileExist("README.txt")) {
            throw new TestFailedException("README.txt check failed. Is working dir correct?");
        }

        System.out.println("Testing IoExamples with aoeu.txt");
        if (IoExamples.doesFileExist("aoeu.txt")) {
            throw new TestFailedException("aoeu.txt exists. It shouldn't...");
        }

        System.out.println("Testing IoExapmles throwable with README.txt");
        try {
            IoExamples.doesFileExistThower("README.txt");
        } catch (FileNotFoundException e) {
            System.out.println("README.txt check failed. Is working dir correct? Rethrowing...");
            throw new TestFailedException(e.getMessage());
        }

        System.out.println("Testing IoExamples throwable with aoeu.txt");
        try {
            IoExamples.doesFileExistThower("aoeu.txt");
            System.out.println("aoeu.txt exists. It shouldn't... Throwing TestFailedException...");
            throw new TestFailedException("aoeu.txt exists. It shouldn't...");
        } catch (FileNotFoundException e) {
            System.out.println("aoeu.txt does not exists and doesFileExist correctly threw an exception");
        }

        System.out.println("IoExamples passed all tests");
    }
}
