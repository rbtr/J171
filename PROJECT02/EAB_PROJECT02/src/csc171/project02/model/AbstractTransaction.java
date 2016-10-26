package csc171.project02.model;

/*
 * AbstractTransaction.java
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
 * An Abstract Transaction parent object that defines and implements some state and behavior of Transactions
 */
public abstract class AbstractTransaction {
    private static long ids;
    private long id;
    private double value;

    /**
     * Consructs a new AbstractTransaction Object.
     * In construction, the id is set to the next unique Id.
     * @param value is the positive dollar amount of the transaction (always positive!)
     */
    public AbstractTransaction(double value) {
        this.id = ids++;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction #" + id + " $" + value + " ";
    }

    /**
     * This method returns the Id of the Transaction
     * @return the Transaction Id
     */
    public long getId() {
        return id; // Returns the current id, then adds 1 to it
    }

    /**
     * This method returns the dollar amount of the Transaction
     * @return the Transaction value
     */
    public double getValue() {
        return value;
    }
}
