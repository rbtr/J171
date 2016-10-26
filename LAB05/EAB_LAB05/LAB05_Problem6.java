import java.util.Scanner;
import java.util.Random;

/**
 * LAB05_Problem6.java
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

public class LAB05_Problem6 {

	public static void main(String[] args) {
        Random random = new Random();
        int myNum = random.nextInt(99) + 1;
        if (args.length > 0) {
            myNum = Integer.parseInt(args[0]);
        }
        
        boolean keepGuessing = true;
        Scanner scanner = new Scanner(System.in);
        do {
            keepGuessing = promptForGuess(myNum, scanner);
        } while (keepGuessing);
    }
    
    public static boolean promptForGuess(final int num, Scanner scanner) {
        System.out.println("Guess my number between 1 and 100?");
        int guessNum = scanner.nextInt();
        if (guessNum == num) {
            System.out.println("You guessed correctly!");
            return false;
        }
        String feedback = guessNum > num ? "high" : "low";
        System.out.println("You guessed too " + feedback);
        return true;
    }
}