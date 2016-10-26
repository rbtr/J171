package csc171.project01.blackjack;

import java.util.ArrayList;

/**
 * Hand.java
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

public class Hand {
	
	ArrayList<Card> cards = new ArrayList<>();

	public Hand(Card[] cards) {
		for (Card c : cards) {
			this.cards.add(c);
		}
	}

	public Hand() {}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public ArrayList<Card> getHand() {
		return cards;
	}

	public int sum() {
		int scoreSum = 0;
		int numAces = 0;
		for (Card c : cards) {
			if (c.getValue() == 1) {
				// Track aces, deal with them later
				numAces++;
			} else {
				scoreSum += c.getValue();
			}
		}
		// Now we've summed all but the aces
		if (numAces > 0) {
			scoreSum = sumAces(numAces, scoreSum);
		}
		return scoreSum;
	}

	private int sumAces(int numAces, int scoreSum) {
		// nonzero number of aces and score passed
		// there can be at most one eleven point ace, the rest must be ones
		while (numAces > 1) {
			scoreSum++;
			numAces--;
		}
		if ((scoreSum + 11) > 21) {
			scoreSum++;
		} else {
			scoreSum += 11;
		}
		return scoreSum;
	}
}