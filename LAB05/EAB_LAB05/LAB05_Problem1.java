

/**
 * LAB05_Problem1.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 05
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 02/15/15
 */

public class LAB05_Problem1 {

    public static void main(String[] args) {
        int a = 4;
        int b = 8;
        if (args.length > 0) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }
        swap(a, b);
    }
    
    public static void swap(int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Swapping...");
        int c = a;
        a = b;
        b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}