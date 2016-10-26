package csc171.lab06.products;

/**
 * Product.java
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

public class Product {

	// Name and Serial should never change, but the price can.
	private final String name;
	private final String serial;
	private double price;


	// Constructor
	protected Product(String name, String serial, double price) {
		this.name = name;
		this.serial = serial;
		this.price = price;
	}

	// Setters
	// Name and Serial should never change, but the price can.
	protected void setPrice(double price) {
		this.price = price;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getSerial() {
		return serial;
	}

	public double getPrice() {
		return price;
	}


	// Class methods
	@Override
	public String toString() {
		return ("Name: " + name + "; Serial: #" + serial + "; Price: $" + price);
	}
}