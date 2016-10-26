package csc171.project02.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * AbstractAccount.java
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
 * An abstract Account parent that defines and implements some Account state and behavior
 */
public abstract class AbstractAccount {

    private static long accountNumbers;

    private final long accountNumber;
    private Map<Long, AbstractTransaction> transactions;
    private double balance;

    /**
     * Constructs an AbstractAccount Object.
     * In doing so, sets this Account number to the next unique Account number.
     */
    public AbstractAccount() {
        this.accountNumber = getUniqueAccountNumber();
    }

    @Override
    public String toString() {
        return "#" + accountNumber + " $" + balance;
    }

    /**
     * This method performs Transactions on this Account
     * @param transaction the transaction to perform
     * @return the new balance
     */
    public double transact(AbstractTransaction transaction) {
        balance += transaction.getValue();
        addTransaction(transaction);
        return balance;
    }

    /**
     * This method adds a Transaction to this Account
     * @param transaction is the Transaction to add
     */
    private void addTransaction(AbstractTransaction transaction) {
        if (transactions == null) {
            transactions = new HashMap<Long, AbstractTransaction>();
        }

        transactions.put(transaction.getId(), transaction);
    }

    private long getUniqueAccountNumber() {
        return accountNumbers++;
    }

    /**
     * This method returns the past Transactions on this Account
     * @return the Transactions Map
     */
    public Map<Long, AbstractTransaction> getTransactions() {
        return transactions;
    }

    /**
     * This method returns the balance of this Account
     * @return the Account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * This method returns the Account number
     * @return the Account number
     */
    public long getAccountNumber() {
        return accountNumber;
    }
}
