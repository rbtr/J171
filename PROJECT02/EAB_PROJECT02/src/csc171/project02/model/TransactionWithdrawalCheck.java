package csc171.project02.model;

/*
 * TransactionWithdrawalCheck.java
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
 * A child of the Withdrawal Transaction @TransactionWithdrawal that provides specific Check behavior
 */
public class TransactionWithdrawalCheck extends TransactionWithdrawal {

    private final long checkNumber;

    /**
     * Constructs a Cashed Check Withdrawal Transaction
     * @param value is the (positive) dollar amount of the Transaction
     * @param checkNumber is the Check Number to be cashed
     */
    public TransactionWithdrawalCheck(double value, long checkNumber) {
        super(value, Type.CHECK);
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " Check #" + checkNumber;
    }

    /**
     * This method returns the Check Number of this transaction
     * @return the Transaction Check number
     */
    public long getCheckNumber() {
        return checkNumber;
    }
}
