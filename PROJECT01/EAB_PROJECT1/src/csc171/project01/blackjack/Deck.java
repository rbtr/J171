package csc171.project01.blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


/**
 * Deck.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: Project 01
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/5/15
 *
 * This class is a singleton pattern.
 * Only one Deck can exist per game.
 * Any request for a deck will return the same deck if one has already 
 * been made.
 */

public class Deck {

	private static Deck deck;
	private ArrayList<Card> cards;

	private Deck() {
		this.cards = shuffle();
	}

	public static Deck getDeck() {
		if (deck == null) {
			deck = new Deck();
		}
		return deck;
	}

	public int cardsRemaining() {
		return cards.size();
	}

	public Card drawCard() {
		// Pop the top card off the deck
		Card card = cards.get(0);
		// Remove it from the deck so it can't be drawn again
		cards.remove(0);
		// Return it
		return card;
	}

	public void shuffleDeck() {
		Collections.shuffle(this.cards, new Random());
	}

	private ArrayList<Card> shuffle() {
		// Each deck has 52 cards
		// 4 of each number, one with each suit
		// Face cards count as 10s, so there's 16 of those
		ArrayList<Card> cards = new ArrayList<>();
		for (Suits s : Suits.values()) {
			for (int v = 0; v < 13; v++) {
				if (v > 9) {
					cards.add(new Card(10, s));
				} else {
					cards.add(new Card(v + 1, s));
				}
			}
		}

		// Now we have an ordered deck of 52 unique cards.
		// It needs to be shuffled.
		// Make use of the handy Collections#shuffle() method
		// where someone has done the difficult part already.

		Collections.shuffle(cards, new Random());
		return cards;
	}
}