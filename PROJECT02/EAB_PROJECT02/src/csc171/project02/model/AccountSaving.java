package csc171.project02.model;

/*
 * AccountSaving.java
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
 * This Saving Account object inherits from the Abstract Account parent and provides additional Savings-specific
 * state and behavior
 */
public class AccountSaving extends AbstractAccount {

    private final float interestRate;

    /**
     * Constructs an Savings Account Object
     * @param interestRate is the interest rate to set up the Account with
     */
    public AccountSaving(float interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + " Savings" + " %" + interestRate;
    }

    /**
     * This method returns the interest rate of this Saving Account
     * @return the Account interest rate
     */
    public float getInterestRate() {
        return interestRate;
    }
}
