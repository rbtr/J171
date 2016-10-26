package csc171.project02.model;

import java.util.Date;

/*
 * BankFactory.java
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
 * A Factory for creating Bank objects populated with static template data.
 * The Bank should not be casually instantiatable. In a real-world application, it would be a persistent object
 * (probably backed by a database), created at runtime by the controller from the persistent model. In this Project,
 * I've made its constructors package-private to prevent any instantiation outside of the Model package.
 *
 * This factory is provided to ensure that a Bank object is properly and fully constructed and supplied to the
 * Controller, to emulate construction from a persistent and well-formed datasource.
 *
 * Note: the Bank is also a singleton, for the same reasons described above - only one should ever be floating around
 * at runtime.
 */

public abstract class BankFactory {

    private static final String bankName = "Bank of Evan";

    private static final String customerUsername = "cust";
    private static final String customerPassword = "pass";
    private static final String customerFirstName = "iama";
    private static final String customerLastName = "customer";
    private static final Date customerBirthdate = new Date();

    private static final float savingsInterestRate = 0.5f;

    private static Bank bank;

    private static int customerCount = 0;
    private static int accountCount = 0;

    public static Bank getEmptyBank() {
        return new Bank(bankName);
    }

    /**
     * This method returns a Bank populated with some templated data
     * @return a populated Bank
     */
    public static Bank getBank() {
        if (bank == null) {
            bank = new Bank(bankName);
            bank.addCustomer(getCustomer());
            bank.addCustomer(getCustomer());
        }

        return bank;
    }

    private static Customer getCustomer() {
        Customer customer = new Customer(
                customerUsername + String.valueOf(customerCount),
                customerPassword + String.valueOf(customerCount),
                customerFirstName + String.valueOf(customerCount),
                customerLastName  + String.valueOf(customerCount),
                customerBirthdate);

        customer.addAccount(getAccount(customer));
        customer.addAccount(getAccount(customer));
        customer.addAccount(getAccount(customer));

        customerCount++;
        return customer;
    }

    private static AbstractAccount getAccount(Customer customer) {
        AbstractAccount account;

        accountCount = accountCount % 2;

        if (accountCount == 0) {
            account = new AccountChecking();
        } else {
            account = new AccountSaving(savingsInterestRate);
        }

        accountCount++;
        return account;
    }
}
