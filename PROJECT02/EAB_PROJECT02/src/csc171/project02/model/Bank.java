package csc171.project02.model;

import java.util.HashMap;
import java.util.Map;

/*
 * Bank.java
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
 * The heart of the Model - all actions must go through the Bank.
 * The bank should not be casually instantiatable, so its constructors are package-private. See the explanation in the
 * BankFactory for more details.
 */

public class Bank {

    private final String name;

    private Map<String, Customer> customers;

    /**
     * Constructs a Bank Object
     * @param name is the name of the Bank
     * @param customers is a Map of the Customers
     */
    Bank(String name, Map<String, Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    /**
     * Constructs a Bank Object
     * @param name is the name of the Bank
     */
    Bank(String name) {
        this.name = name;
    }

    /**
     * This method adds a Customer to the Map of Customers in the Bank
     * @param customer is the Customer to add
     */
    public void addCustomer(Customer customer) {
        if (customers == null) {
            this.customers = new HashMap<String, Customer>();
        }

        customers.put(customer.getUsername(), customer);
    }

    /**
     * This method returns the name of the Bank
     * @return the name of the Bank
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the Map of the Customers of the Bank
     * @return the Map of Customers of the Bank
     */
    public Map<String, Customer> getCustomers() {
        return customers;
    }
}
