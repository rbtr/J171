import java.util.Random;

/**
 * LAB05_Problem8.java
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

public class LAB05_Problem8 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			arr[i] = LAB05_Problem7.randomInt(random, 1, 1000);
		}

		int max = 0;
		int maxIndex = 0;
		int min = 1001;
		int minIndex = 0;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		System.out.print("\n");
		System.out.println("Minimum value is " + min + " at " + minIndex);
		System.out.println("Maximum values is " + max + " at " + maxIndex);
	}
}