package csc171.lab08;

/**
 * Items.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 07
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 3/21/15
 * 
 * An enhanced interface defining the behavior required to interact with a List of EnhancedItems
 */

public interface EnhancedItems extends Items {
	public Object remove(int index);
	public void insert(Object item, int index);
}