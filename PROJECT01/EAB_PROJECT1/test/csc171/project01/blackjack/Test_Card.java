package csc171.project01.blackjack;

import csc171.project01.blackjack.Card;
import java.util.Scanner;

/**
 * Test_Card.java
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

public class Test_Card {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int card = 0;
		int[][] values = {
			{1, 4},
			{2, 4},
			{3, 4},
			{4, 4},
			{5, 4},
			{6, 4},
			{7, 4},
			{8, 4},
			{9, 4},
			{10, 16},
		};
		boolean[] valUsed = new boolean[10];
		boolean[] suitUsed = new boolean[4];

		boolean doContinue = true;
		do {
			for (int l = 0; l < 100; l++) {
				Card c = Card.getRandomCard();
				if (c.getValue() > 10 || c.getValue() < 1) {
					doContinue = false;
					System.out.println("Card out of range");
				} else {
					for (int i = 0; i < values.length; i++) {
						if (values[i][0] == c.getValue()) {
							valUsed[i] = true;
							values[i][1]--;
						}
					}
					suitUsed[c.getSuit().ordinal()] = true;
				}
				System.out.println("\t" + c.getValue() + "\t" + c.getSuit());
			}

			for (int i = 0; i < values.length; i++) {
				System.out.println("\t" + values[i][0] + " x " + values[i][1] + " - " + valUsed[i]);
			}
			for (int i = 0; i < suitUsed.length; i++) {
				System.out.println("\t" + "Suit used " + Suits.values()[i] + " " + suitUsed[i]);
			}
			System.out.println("Continue? (y/n)");
			doContinue = scanner.next().equalsIgnoreCase("y");
		} while (doContinue);
	}
}