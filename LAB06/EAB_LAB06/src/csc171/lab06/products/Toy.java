package csc171.lab06.products;

/**
 * Toy.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 06
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 2/28/15
 */

 public class Toy extends Product {

 	// The age range should never change
 	private final int minAge;
 	private final int maxAge;


 	public Toy(String name, String serial, double price, int minAge, int maxAge) {
 		super(name, serial, price);
 		this.minAge = minAge;
 		this.maxAge = maxAge;
 	}

 	// No setters because the age range is final

 	// Getters
 	public int getMinAge() {
 		return minAge;
 	}

 	public int getMaxAge() {
 		return maxAge;
 	}


 	// Class methods
 	@Override
 	public String toString() {
 		return (super.toString() + "; Ages " + minAge + " - " + maxAge);
 	}
 }