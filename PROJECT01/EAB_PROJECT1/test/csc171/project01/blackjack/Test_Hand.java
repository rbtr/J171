package csc171.project01.blackjack;

import csc171.project01.blackjack.Hand;
import java.util.ArrayList;

/**
 * Test_Hand.java
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

public class Test_Hand {
	
	public static void main(String[] args) {
		Card c = Card.getRandomCard();

		Hand h1 = new Hand(new Card[] {c});
		Hand h2 = new Hand();
		h2.addCard(c);

		if (h1.sum() != h2.sum()) {
			System.out.println("Hand constructor / addCard method mismatch.");
		}

		ArrayList<Card> cList1 = h1.getHand();
		ArrayList<Card> cList2 = h2.getHand();

		if (cList1.size() != cList2.size()) {
			System.out.println("Hand cards mismatched.");
		}

		for (int i = 0; i < cList1.size(); i++) {
			if (cList1.get(i).getValue() != cList2.get(i).getValue()) {
				System.out.println("Cards in hand mismatched.");
			}
		}

		System.out.println("Finished test");
	}
}