package csc171.project02.model;

/*
 * TransactionDeposit.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: PROJECT 02
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/11/15
 */

/**
 * A Deposit Transaction Object
 */
public class TransactionDeposit extends AbstractTransaction {
    /**
     * Creates a new Deposit Transaction
     * @param value the (positive) dollar amount of the Transaction
     */
    public TransactionDeposit(double value) {
        super(value);
    }
}
