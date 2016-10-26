package csc171.lab10.io;

/*
 * IoExamples.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class tries to access a file and gives feedback on the existence of the file
 */
public class IoExamples {

    /**
     * This method takes a filename as a String and checks to see if it exists in the current working directory
     * @param filename the filaname to check
     * @return if the file exists
     */
    public static boolean doesFileExist(String filename) {

        // I wrote this for Section 8 as I normally would before even reading Section 9 (that says to modify and add the
        // null check and finally block to close. The only difference between this and the next method is this one
        // catches and the next one rethrows

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filename);
            System.out.println("File found!");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
            return false;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // Squash
                }
            }
        }
    }

    public static void doesFileExistThower(String filename) throws FileNotFoundException {

        // Nearly identical to the above method except rethrows the FileNotFoundException instead of handling it

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filename);
            System.out.println("File found!");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // Squash
                }
            }
        }
    }

}
