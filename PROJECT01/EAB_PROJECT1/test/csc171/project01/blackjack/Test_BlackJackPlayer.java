package csc171.project01.blackjack;

import csc171.project01.blackjack.BlackJackPlayer;

/**
 * Test_BlackJackPlayer.java
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

public class Test_BlackJackPlayer {
	
	public static void main(String[] args) {

		BlackJackPlayer player = new BlackJackPlayer(true);
		Card c0 = new Card(0);
		Card c21 = new Card(21);

		player.giveCard(c0);

		if (player.shouldHit()) {
			System.out.println("Player hit appropriately.");
		}

		if (player.getScore() != 0) {
			System.out.println("Player score summed incorrectly.");
		}

		if (player.hasWon()) {
			System.out.println("Player won prematurely.");
		}

		player.giveCard(c21);

		if (!player.shouldHit()) {
			System.out.println("Player stayed appropriately.");
		}

		if (player.getScore() != 21) {
			System.out.println("Player score summed incorrectly.");
		}

		if (player.hasWon()) {
			System.out.println("Player won appropriately.");
		}

		System.out.println("Player test finished.");
	}
}