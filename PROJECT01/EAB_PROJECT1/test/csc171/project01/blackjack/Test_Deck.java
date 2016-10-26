package csc171.project01.blackjack;

import csc171.project01.blackjack.Deck;

/**
 * Test_Deck.java
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

public class Test_Deck {
	
	public static void main(String[] args) {
		int[][] values = {
			{1, 0, 4},
			{2, 0, 4},
			{3, 0, 4},
			{4, 0, 4},
			{5, 0, 4},
			{6, 0, 4},
			{7, 0, 4},
			{8, 0, 4},
			{9, 0, 4},
			{10, 0, 16},
		};
		boolean[] valUsed = new boolean[10];

		Deck deck = Deck.getDeck();
		System.out.println("Initial deck size : " + deck.cardsRemaining());
		if (deck.cardsRemaining() != 52) {
			System.out.println("Deck size is incorrect.");
			return;
		}

		for (int ci = 0; ci < 52; ci++) {
			Card c = deck.drawCard();

			if (c.getValue() > 10 || c.getValue() < 1) {
					System.out.println("Card out of range.");
			} else {
				for (int i = 0; i < values.length; i++) {
					if (values[i][0] == c.getValue()) {
						valUsed[i] = true;
						values[i][1]++;
					}
				}
			}
			System.out.println("\t" + c.getValue() + "\t" + c.getSuit());
		}

		System.out.println("\n\t" + "Value" + "\t" + "Count" + "\t" + "1+ used?");
		for (int i = 0; i < values.length; i++) {
				System.out.println("\t" + values[i][0] + "\t" + values[i][1] + "/" + values[i][2] + "\t" + valUsed[i]);
		}

		if (deck.cardsRemaining() != 0) {
			System.out.println("Error: cards remain in deck.");
		} else {
			System.out.println("Deck is empty.");
		}

	}
}