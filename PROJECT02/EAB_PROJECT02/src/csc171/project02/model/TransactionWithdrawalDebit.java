package csc171.project02.model;

/*
 * TransactionWithdrawalDebit.java
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
 * A child of the Withdrawal Transaction @TransactionWithdrawal that provides Debit specific details
 */
public class TransactionWithdrawalDebit extends TransactionWithdrawal {

    private final String payee;

    /**
     * Constructs a Debit Withdrawal Transaction
     * @param value the (positive) dollar amount of this Transaction
     * @param payee the payee that is debiting the Account in this Transaction
     */
    public TransactionWithdrawalDebit(double value, String payee) {
        super(value, Type.DEBIT);
        this.payee = payee;
    }

    @Override
    public String toString() {
        return super.toString() + " Payee: " + payee;
    }

    /**
     * This method returns the Payee of this Transaction
     * @return the Transaction payee
     */
    public String getPayee() {
        return payee;
    }
}
