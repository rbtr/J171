package csc171.project02.model;

/*
 * TransactionWithdrawal.java
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
 * A Withdrawal Transaction Object
 */
public class TransactionWithdrawal extends AbstractTransaction {

    /**
     * This enum lists the types of withdrawal possible
     */
    public enum Type {
        ATM,
        DEBIT,
        CHECK
    }

    private Type type;

    /**
     * Constructs a Withdrawal Transaction
     * @param value is the (positive) dollar amount of the Transaction
     */
    public TransactionWithdrawal(double value) {
        super(value);
        this.type = Type.ATM;
    }

    /**
     * Constructs a Withdrawal Transaction of specified type
     * @param value is the (positive) dollar amount of the Transaction
     * @param type is the specific Type of the withdrawal
     */
    public TransactionWithdrawal(double value, Type type) {
        super(value);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " " + type;
    }

    /**
     * This method returns the specific Type of this withdrawal
     * @return the Type of this withdrawal
     */
    public Type getType() {
        return type;
    }
}
