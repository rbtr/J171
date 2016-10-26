import java.util.Random;
import java.util.Scanner;

/**
 * LAB05_Problem5.java
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

public class LAB05_Problem5 {

    public static void main(String[] args) {
        Random random = new Random();
        int myNum = random.nextInt(9) + 1;
        if (args.length > 0) {
            myNum = Integer.parseInt(args[0]);
        }
        
        boolean keepGuessing = true;
        Scanner scanner = new Scanner(System.in);
        while (keepGuessing) {
            keepGuessing = promptForGuess(myNum, scanner);
        }
    }
    
    public static boolean promptForGuess(final int num, Scanner scanner) {
        System.out.println("Guess my number between 1 and 10?");
        int guessNum = scanner.nextInt();
        if (guessNum > 10 || guessNum < 1) {
            insult();
            return false;
        } else if (guessNum == num) {
            System.out.println("You guessed correctly!");
            return false;
        }
        System.out.println("Wrong.");
        return true;
    }
    
    public static void insult() {
        System.out.println("I said between 1 and 10, genius. Can you count?");
    }
}