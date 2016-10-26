

/**
 * LAB05_Problem3.java
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

public class LAB05_Problem3 {

    public static void main(String[] args) {
        char[] str = "My reversible string".toCharArray();
        if (args.length > 0) {
            str = args[0].toCharArray();
        }
        reverseString(str);
    }
    
    public static void reverseString(char[] str) {
        System.out.println(str);
        System.out.println("Reversing...");
        int length = str.length;
        for (int i = 0; i < length/2; i++) {
            char a = str[i];
            str[i] = str[(length - 1) - i];
            str[(length - 1) - i] = a;
        }
        System.out.println(str);
    }
}