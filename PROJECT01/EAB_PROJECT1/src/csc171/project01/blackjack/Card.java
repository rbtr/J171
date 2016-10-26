package csc171.project01.blackjack;

import java.util.Random; 

/**
 * Card.java
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

public class Card {
	private int value;
	private Suits suit;

	public Card(int value) {
		this.value = value;
	}

	public Card(int value, Suits suit) {
		this.value = value;
		this.suit = suit;
	}

	public static Card getRandomCard() {
		return new Card(randomValue(), randomSuit());
	}

	private static int randomValue() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	private static Suits randomSuit() {
		Random random = new Random();
		int suit = random.nextInt(4);
		return Suits.values()[suit];
	}

	public Suits getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public void setValue() {
		this.value = value;
	}
}