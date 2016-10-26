import java.util.Scanner;

/**
 * LAB05_Problem4.java
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

public class LAB05_Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int size = scanner.nextInt();
        
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = promptForFloat(scanner);
        }
        
        float sum = 0;
        for (int i = 0; i < size; i++) {
            sum = cumulativeSum(sum, arr[i]);
        }
        
        float avg = average(sum, size);
        System.out.println("The average is " + avg);
    }
    
    public static float promptForFloat(Scanner scanner) {
        System.out.print("Enter a decimal value : ");
        return scanner.nextFloat();
    }
    
    public static float cumulativeSum(float prevSum, float newVal) {
        return prevSum + newVal;
    }
    
    public static float average(float sum, int count) {
        return sum / (float) count;
    }
}