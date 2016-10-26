package csc171.project02.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * Customer.java
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
 * A Customer Object that defines and implements the necessary state and behavior to define and uniquely identify a
 * Customer to the Bank
 */
public class Customer {

    private final String username, password, firstName, lastName;
    private long birthdate;
    private Map<Long, AbstractAccount> accounts;

    /**
     * Constructs a Customer
     * @param username is the Customer username
     * @param password is the Customer password
     * @param firstName is the Customer first name
     * @param lastName is the Customer last name
     * @param birthdate is the Customer birth date
     */
    public Customer(String username, String password, String firstName, String lastName, Date birthdate) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate.getTime();
    }

    /**
     * Constructs a Customer
     * @param username is the Customer username
     * @param password is the Customer password
     * @param firstName is the Customer first name
     * @param lastName is the Customer last name
     * @param birthdate is the Customer birth date
     */
    public Customer(String username, String password, String firstName, String lastName, long birthdate) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (AbstractAccount a : accounts.values()) {
            sb.append(a).append("\n");
        }

        return username + " "
                + firstName + " "
                + lastName + " "
                + "DOB: " + Util.getFormattedDate(birthdate) + " "
                + "Accounts: " + sb.toString();
    }

    /**
     * This method adds an Account to the Map of Accounts of this Customer
     * @param account is the Account to add to this Customer
     */
    public void addAccount(AbstractAccount account) {
        if (accounts == null) {
            this.accounts = new HashMap<Long, AbstractAccount>();
        }

        accounts.put(account.getAccountNumber(), account);
    }

    /**
     * This method checks whether the passed password matches this Customer's saved password. If so, the Customer is
     * allowed to authenticate.
     * @param password is the password to check against the Customer's private password
     * @return true if the password is correct
     */
    public boolean authenticate(String password) {
        return password.equals(this.password);
    }

    /**
     * @return the Customer user name
     */
    public String getUsername() {
        return username;
    }

    /**
     * Since the Customer is never returned past the Controller layer, this should be allowably secure
     * @return the Customer password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the Customer first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the Customer last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the Customer birthdate
     */
    public long getBirthdate() {
        return birthdate;
    }

    /**
     * @return the Map of Customer Accounts
     */
    public Map<Long, AbstractAccount> getAccounts() {
        return accounts;
    }
}
