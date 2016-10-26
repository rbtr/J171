package csc171.project02.controller;

import csc171.project02.model.*;

import java.util.Date;
import java.util.Map;

/*
 * BankController.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: PROJECT 02
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/11/15
 *
 */

/**
 * The BankController is a controller layer than abstracts out interaction with the Bank and related model objects.
 * On first interaction, the BankController can either authenticate a customer or create a new customer. In any case,
 * the customer must be instantiated before any other actions take place.
 * Once a customer reference exists, there also needs to be an active account on which further actions are performed.
 */
public class BankController {

    private Bank bank;
    private Customer customer;
    private AbstractAccount account;
    private AbstractTransaction transaction;

    /**
     * Sets up a new BankController to allow interaction with the Bank Model
     * @param bank is the Bank to set the Controller to interface with. Must be created elsewhere and supplied to the
     *             controller, as the controller is blind to the creation logic. In fact, the Bank constructor is
     *             package-private, and thus must be instantiated from within the model package (use the BankFactory).
     */
    public BankController(Bank bank) {
        this.bank = bank;
    }

    /**
     * This static method creates an instance of this class with a Bank from the BankFactory
     * It is not necessary to get the Controllor using this method, but is useful for testing when a persistent Bank
     * model does not exist.
     * @return an instance of the BankController with a Bank from the BankFactory supplied for it to interface with
     */
    public static BankController getBankController() {
        return new BankController(BankFactory.getBank());
    }

    /**
     * This method returns the name of the Bank active in the Controller
     * @return the name of the Bank
     */
    public String getBankName() {
        if (bank == null) {
            throw new IllegalStateException("Controller is not connected to a Bank");
        }

        return bank.getName();
    }

    private Map<String, Customer> getCustomers() {
        return bank.getCustomers();
    }

    private boolean doesCustomerExist(String username) {
        Map<String, Customer> customers = getCustomers();
        return customers.containsKey(username);
    }

    /**
     * This method creates a new Customer (if the username does not yet exist) and then marks that Customer as active
     * so that further actions may be performed with that Customer
     * @param username is the username to create the Customer with
     * @param password is the password to create the Customer with
     * @param firstName is the first name of the Customer
     * @param lastName is the last name of the Customer
     * @param birthdate is the birthdate of the Customer
     */
    public void createCustomer(String username, String password, String firstName, String lastName, Date birthdate) {
        if (!doesCustomerExist(username)) {
            Customer customer = new Customer(username, password, firstName, lastName, birthdate);
            bank.addCustomer(customer);
            authenticateCustomer(customer.getUsername(), customer.getPassword());
        } else {
            throw new IllegalStateException("Username already exists");
        }
    }

    /**
     * This method authenticates the Controller with a Customer marks that Customer as active for further actions to
     * be performed with that Customer
     * @param username is the username to attempt to authenticate
     * @param password is the password to attempt to authenticate
     */
    public void authenticateCustomer(String username, String password) {
        Map<String, Customer> customers = getCustomers();

        if (doesCustomerExist(username)) {
            Customer customer = customers.get(username);
            if (customer.authenticate(password)) {
                this.customer = customer;
            } else {
                throw new IllegalStateException("Incorrect password");
            }
        } else {
            throw new IllegalStateException("Customer does not exist with this username");
        }
    }

    /**
     * This method returns the username of the active Customer from this Controller
     * @return the active Customer username
     */
    public String getCustomerUsername() {
        if (customer == null) {
            throw new IllegalStateException("Not logged in");
        }

        return customer.getUsername();
    }

    /**
     * This method returns the first name of the active Customer from this Controller
     * @return the active Customer first name
     */
    public String getCustomerFirstName() {
        if (customer == null) {
            throw new IllegalStateException("Not logged in");
        }

        return customer.getFirstName();
    }

    /**
     * This method returns the last name of the active Customer from this Controller
     * @return the active Customer last name
     */
    public String getCustomerLastName() {
        if (customer == null) {
            throw new IllegalStateException("Not logged in");
        }

        return customer.getLastName();
    }

    /**
     * This method returns the birthdate of the active Customer from this Controller
     * @return the active Customer birthdate
     */
    public long getCustomerBirthdate() {
        if (customer == null) {
            throw new IllegalStateException("Not logged in");
        }

        return customer.getBirthdate();
    }

    /**
     * This method gets all of the accounts connected to the active Customer
     * @return a Map of accounts for the active Customer
     */
    public Map<Long, AbstractAccount> getAccounts() {
        if (customer == null) {
            throw new IllegalStateException("Not logged in");
        }

        return customer.getAccounts();
    }

    /**
     * This method creates a new Checking Account and adds it to the currently active Customer
     */
    public void createCheckingAccount() {
        if (customer == null) {
            throw new IllegalStateException("Not logged in");
        }

        AccountChecking accountChecking = new AccountChecking();
        customer.addAccount(accountChecking);
        account = accountChecking;
    }

    /**
     * This method creates a new Savings Account and adds it to the currently active Customer
     * @param interestRate is the Interest Rate to set up the Savings Account with
     */
    public void createSavingsAccount(float interestRate) {
        if (customer == null) {
            throw new IllegalStateException("Not logged in");
        }

        AccountSaving accountSaving = new AccountSaving(interestRate);
        customer.addAccount(accountSaving);
        account = accountSaving;
    }

    /**
     * This method marks the active Account so that actions can be performed on that Account
     * @param accountNumber is the id Account to activate
     */
    public void selectAccount(long accountNumber) {
        if (!getAccounts().containsKey(accountNumber)) {
            throw new IllegalStateException("Invalid account");
        }

        account = getAccounts().get(accountNumber);
    }

    /**
     * This methods returns the active Account out of the Controller
     * @return the active Account
     */
    public AbstractAccount getAccount() {
        if (account == null) {
            throw new IllegalStateException("No account selected");
        }

        return account;
    }

    /**
     * This method returns the Account number of the active Account in the Controller
     * @return the Account number
     */
    public long getAccountNumber() {
        if (account == null) {
            throw new IllegalStateException("No account selected");
        }

        return account.getAccountNumber();
    }

    /**
     * This method returns the balance of the active Account in the Controller
     * @return the Account balance
     */
    public double getAccountBalance() {
        if (account == null) {
            throw new IllegalStateException("No account selected");
        }

        return account.getBalance();
    }

    /**
     * This method returns the transaction of the active Account in the Controller
     * @return the transactions of the Account
     */
    public Map<Long, AbstractTransaction> getAccountTransactions() {
        if (account == null) {
            throw new IllegalStateException("No account selected");
        }

        return account.getTransactions();
    }

    private void addTransaction(AbstractTransaction transaction) {
        if (account == null) {
            throw new IllegalStateException("No account selected");
        }

        account.transact(transaction);
    }

    public float getSavingAccountInterestRate() {
        if (account == null) {
            throw new IllegalStateException("No account selected");
        }

        if (!(account instanceof AccountSaving)) {
            throw new IllegalStateException("Selected account of wrong type");
        }

        return ((AccountSaving) account).getInterestRate();
    }

    /**
     * This method deposits the passed amount in to the currently selected Account and logs the transaction
     * @param amount is the amount to deposit, as a positive value
     */
    public void deposit(double amount) {
        TransactionDeposit deposit = new TransactionDeposit(amount);
        addTransaction(deposit);
    }

    /**
     * This method withdraws the passed amount from the currently selected Account and logs the transaction
     * @param amount is the amount to withdraw, as a positive value
     * @param checkNumber is the check number to log the withdrawal against
     */
    public void cashCheck(double amount, long checkNumber) {
        TransactionWithdrawalCheck withdrawalCheck = new TransactionWithdrawalCheck(-amount, checkNumber);
        addTransaction(withdrawalCheck);
    }

    /**
     * This method withdraws the passed amount from the currently selected Account and logs the transaction
     * @param amount is the amount to withdraw, as a positive value
     * @param payee is the name of the payee that is debiting the account
     */
    public void debit(double amount, String payee) {
        TransactionWithdrawalDebit withdrawalDebit = new TransactionWithdrawalDebit(-amount, payee);
        addTransaction(withdrawalDebit);
    }

    /**
     * This method withdraws the passed amount from the currently selected Account and logs the transaction
     * @param amount is the amount to withdraw, as a positive value
     */
    public void withdraw(double amount) {
        TransactionWithdrawal withdrawal = new TransactionWithdrawal(-amount);
        addTransaction(withdrawal);
    }

    /**
     * This method sets a Transaction as the active Transaction in this Controller
     * @param transactionNumber is the Transaction to select
     */
    public void selectTransaction(long transactionNumber) {
        if (!getAccountTransactions().containsKey(transactionNumber)) {
            throw new IllegalStateException("Invalid transaction");
        }

        transaction = getAccountTransactions().get(transactionNumber);
    }

    public double getTransactionAmount() {
        if (transaction == null) {
            throw new IllegalStateException("No transaction selected");
        }

        return transaction.getValue();
    }
}
