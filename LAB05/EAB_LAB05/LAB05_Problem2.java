

/**
 * LAB05_Problem2.java
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

public class LAB05_Problem2 {

    public static void main(String[] args) {
        int a = 4;
        int b = 8;
        if (args.length > 0) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }
        int[] arr = new int[] {a, b};
        swapInArray(arr);
    }
    
    public static void swapInArray(int[] arr) {
        System.out.println("[0] = " + arr[0]);
        System.out.println("[1] = " + arr[1]);
        System.out.println("Swapping...");
        int c = arr[0];
        arr[0] = arr[1];
        arr[1] = c;
        System.out.println("[0] = " + arr[0]);
        System.out.println("[1] = " + arr[1]);
    }
}