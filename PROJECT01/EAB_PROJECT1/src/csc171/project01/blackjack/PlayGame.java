package csc171.project01.blackjack;

import java.util.Scanner;

/**
 * PlayGame.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: Project 01
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/5/15
 */

public class PlayGame {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = scanner.next();
		System.out.println("Ok, " + name + ", how many AI players would you like in the game?");
		int playerCount = 0;
		try {
			 playerCount = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Not a valid number.");
		}
		if (playerCount < 0) {
			System.out.println("There can't be negative players.");
			playerCount = 1;
		}

		BlackJack blackJack = new BlackJack(playerCount + 1, name);


		while (!blackJack.isGameOver()) {
			blackJack.playRound();
			blackJack.printScores();
		}
		blackJack.whoWon();
	}
}